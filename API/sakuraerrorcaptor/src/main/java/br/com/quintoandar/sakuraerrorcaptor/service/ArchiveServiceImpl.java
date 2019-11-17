package br.com.quintoandar.sakuraerrorcaptor.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import br.com.quintoandar.sakuraerrorcaptor.error.ArchiveNotFoundException;
import br.com.quintoandar.sakuraerrorcaptor.model.Archive;
import br.com.quintoandar.sakuraerrorcaptor.model.Log;
import br.com.quintoandar.sakuraerrorcaptor.model.LogOccurrence;
import br.com.quintoandar.sakuraerrorcaptor.model.Occurrence;
import br.com.quintoandar.sakuraerrorcaptor.model.Tenant;
import br.com.quintoandar.sakuraerrorcaptor.model.TrackedSystem;
import br.com.quintoandar.sakuraerrorcaptor.model.json.ArchiveJson;
import br.com.quintoandar.sakuraerrorcaptor.model.json.LogOccurrenceJson;
import br.com.quintoandar.sakuraerrorcaptor.model.json.OccurrenceJson;
import br.com.quintoandar.sakuraerrorcaptor.model.json.TrackedSystemJson;
import br.com.quintoandar.sakuraerrorcaptor.repository.ArchiveRepository;
import br.com.quintoandar.sakuraerrorcaptor.repository.TenantRepository;
import br.com.quintoandar.sakuraerrorcaptor.repository.TrackedSystemRepository;
import br.com.quintoandar.sakuraerrorcaptor.service.interfaces.ArchiveService;
import br.com.quintoandar.sakuraerrorcaptor.service.interfaces.LogOccurrenceService;
import br.com.quintoandar.sakuraerrorcaptor.service.interfaces.LogService;
import br.com.quintoandar.sakuraerrorcaptor.service.interfaces.OccurrenceService;

@Service
public class ArchiveServiceImpl implements ArchiveService{

    @Autowired
    ArchiveRepository archiveRepository;
    
    @Autowired
    OccurrenceService occurrenceService;
    
    @Autowired
    LogService logService;
    
    @Autowired
    LogOccurrenceService logOccurrenceService;
    
    @Autowired
    TrackedSystemRepository trackedSystemRepository;
    
    @Autowired
    TenantRepository tenantRepository;
    
    @Override
    public Optional<Archive> findById(Long id) {
        return archiveRepository.findById(id);
    }
    
    @Override
	public List<Archive> findAll() {		
		return archiveRepository.findAll();
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
	public boolean sendLogOccurrenceToArchive(Long logOccurrenceId) throws NotFoundException {
		LogOccurrence logOccurrence = logOccurrenceService.findById(logOccurrenceId).orElseThrow(()-> new NotFoundException());
		Log log = logOccurrence.getLog();
		Occurrence occurrence = logOccurrence.getOccurrence();
		ArchiveJson archiveJson = setArchiveJson(log, occurrence);
		
		try {
			save(archiveJson);
			logOccurrenceService.delete(logOccurrenceId);	
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}		
	}
	
	private ArchiveJson setArchiveJson(Log log, Occurrence occurrence) {
		ArchiveJson archiveJson = new ArchiveJson();
		archiveJson.setEnvironment(log.getEnvironment());
		archiveJson.setLevel(log.getLevel());
		archiveJson.addTenant(log.getTenant().getId(), log.getTenant().getName());
		
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
		List<LogOccurrence> logOccurrences = logOccurrenceService.findByLogIdAndOccurrenceId(log.getId(),occurrence.getId());
		for (LogOccurrence l: logOccurrences) {
			logOccurrencesJson.add(new LogOccurrenceJson(l.getId(),l.getOccurredIn()));
		}
		
		List<OccurrenceJson> occurrences = new ArrayList<OccurrenceJson>();
		occurrences.add(new OccurrenceJson(occurrence.getTitle(), occurrence.getDetail(),logOccurrencesJson));
		archiveJson.setOccurrences(occurrences);
		
		return archiveJson;
	}
    
    @Override
    public boolean sendArchiveToLog(Long id) {
        if (archiveRepository.findById(id).isPresent()) {
            Archive archive = archiveRepository.findById(id).get();            
            try{
            	saveFromJson(archive.getArchive());
            	archiveRepository.deleteById(id);
            } catch (NotFoundException e) {
				System.out.println(e.getMessage());
				return false;
			}            
            return true;
        } else {
            return false;
        }        
    }
    
    private void saveFromJson(ArchiveJson archiveJson)  throws NotFoundException {
    	Long trackedSystemId = archiveJson.getTrackedSystem().get(0).getId();
    	TrackedSystem trackedSystem = trackedSystemRepository.findById(trackedSystemId).orElseThrow(()-> new NotFoundException());
        
    	Long tenantId = archiveJson.getTenant().get(0).getId();
    	Tenant tenant = tenantRepository.findById(tenantId).get();
        
    	Log log = logService.saveLogFromArchive(
    			archiveJson.getEnvironment(), 
                archiveJson.getLevel(), 
                tenant,
                trackedSystem
                );
        
        for(OccurrenceJson o: archiveJson.getOccurrences()) {
            Occurrence occurrence = occurrenceService.saveOccurrenceFromArchive(o);
            
            for (LogOccurrenceJson l: o.getLogOccurrences()) {
                logOccurrenceService.saveFromArchive(l.getId(),log,occurrence,l.getOccurredIn());
            }
        }
    }
}