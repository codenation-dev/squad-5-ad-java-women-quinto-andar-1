package br.com.quintoandar.sakuraerrorcaptor.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.quintoandar.sakuraerrorcaptor.exception.ArchiveNotFoundException;
import br.com.quintoandar.sakuraerrorcaptor.model.Archive;
import br.com.quintoandar.sakuraerrorcaptor.model.json.ArchiveJson;
import br.com.quintoandar.sakuraerrorcaptor.model.json.LogOccurrenceJson;
import br.com.quintoandar.sakuraerrorcaptor.model.json.OccurrenceJson;
import br.com.quintoandar.sakuraerrorcaptor.model.json.TrackedSystemJson;
import br.com.quintoandar.sakuraerrorcaptor.repository.ArchiveRepository;
import br.com.quintoandar.sakuraerrorcaptor.service.interfaces.ArchiveServiceInterface;

@Service
public class ArchiveService implements ArchiveServiceInterface{

    @Autowired
    ArchiveRepository archiveRepository;
    
    @Autowired
    OccurrenceRepository occurrenceRepository;
    
    @Autowired
    LogRepository logRepository;
    
    @Autowired
    LogOccurrenceRepository logOccurrenceRepository;
    
    @Override
    public Optional<Archive> findById(Long id) {
        return archiveRepository.findById(id);
    }
    
    @Override
    public boolean deleteById(Long id) {
        if (archiveRepository.findById(id).isPresent()) {
            archiveRepository.deleteById(id);
            return true;
        } 
        throw new ArchiveNotFoundException(id);
    }
   
    @Override
    public boolean save(ArchiveJson archiveJson) {
        Archive archive = new Archive();
        archive.setArchive(archiveJson);
        archive.setArchivedIn(LocalDateTime.now());
        
        try {
            archiveRepository.save(archive);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }        
    }
    
    @Override
	public boolean sendLogOccurrenceToArchive(Long logOccurrenceId) {
		LogOccurrence logOccurrence = logOccurrenceRepository.findById(logOccurrenceId);
		Log log = logOccurrence.getLog();
		Occurrence occurrence = logOccurrence.getOccurrence();
		ArchiveJson archiveJson = setArchiveJson(log, occurrence);
		
		try {
			archiveRepository.save(archiveJson);
			logOccurrenceRepository.deleteById(logOccurrenceId);	
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}		
	}
	
	private ArchiveJson setArchiveJson(Log log, Occurrence occurrence) {
		ArchiveJson archiveJson = new ArchiveJson();
		archiveJson.setEnvironment(log.getEnvironent());
		archiveJson.setLevel(log.getLevel());
		archiveJson.setTenantId(log.getTenantId());
		archiveJson.setTenant("");
		
		TrackedSystem trackedSystem = log.getTrackedSystem();
		List<TrackedSystemJson> trackedSystemJson = new ArrayList<TrackedSystemJson>();
		trackedSystemJson.add(new TrackedSystemJson(trackedSystem.getId(), 
				                                    trackedSystem.getName(),
				                                    trackedSystem.getLocation(),
				                                    trackedSystem.getToken()
				                                    )
				              );
		archiveJson.setTrackedSystem(trackedSystemJson);
		
		List<LogOccurrenceJson> logOccurrencesJson = new ArrayList<LogOccurrenceJson>();
		List<LogOccurrence> logOccurrences = logOccurrenceRepository.findByLogIdAndOccurrenceId(logId,occurrenceId);
		for (LogOccurence l: logOccurrences) {
			logOccurrencesJson.add(new LogOccurrenceJson(l.getOccurredIn()));
		}
		
		List<OccurrenceJson> occurrences = new ArrayList<OccurrenceJson>;
		occurrences.add(new OccurrenceJson(occurrence.getTitle(), occurrence.getDetail(),logOccurrencesJson));
		archiveJson.setOccurrences(occurrences);
		return archiveJson;
	}
    
    @Override
    public boolean sendArchiveToLog(Long id) {
        if (archiveRepository.findById(id).isPresent()) {
            Archive archive = archiveRepository.findById(id).get();            
            saveFromJson(archive.getArchive());
            archiveRepository.deleteById(id);
            return true;
        } else {
            return false;
        }        
    }
    
    private void saveFromJson(ArchiveJson archiveJson) {
        Log log = saveLogFromArchive(archiveJson.getEnvironment(), 
                archiveJson.getLevel(), 
                archiveJson.getTenant(),
                archiveJson.getTrackedSystem().get(0));
        
        for(OccurrenceJson o: archiveJson.getOccurrences()) {
            Occurrence occurrence = saveOccurrenceFromArchive(o);
            for (LogOccurrenceJson l: o.getLogOccurrences()) {
                saveLogOccurrence(log,occurrence,l.getOccurredIn());
            }
        }
    }    
    
    private Log saveLogFromArchive(String environment, String level, Long tenantId, TrackedSystemJson trackedSystemJson) {
        if (!logRepository.findByEnvironmentAndLevelAndTenantIdAndTrackedSystemId(environment,level,tenantId,trackedSystemJson.getId()).isPresent()) {
            Log log = new Log(environment,level,tenantId,trackedSystemJson.getId());
            logRepository.save(log);
        }
        return logRepository.findByEnvironmentAndLevelAndTenantIdAndTrackedSystemId(environment,level,tenantId,trackedSystemJson.getId()).get();
    }
    
    private Occurrence saveOccurrenceFromArchive(OccurrenceJson occurrenceJson) {
        if (!occurrenceRepository.findByTitleAndDetail(occurrenceJson.getTitle(), occurrenceJson.getDetail()).isPresent()) {
            Occurrence occurrence = new Occurrence(occurrenceJson.getId(),occurrenceJson.getTitle(),occurrenceJson.getDetail());
            occurrenceRepository.save(occurrence);
        }
        return occurrenceRepository.findByTitle(o.getTitle()).get();
    }
}