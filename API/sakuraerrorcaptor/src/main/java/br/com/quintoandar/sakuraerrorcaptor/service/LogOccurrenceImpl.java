package br.com.quintoandar.sakuraerrorcaptor.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.quintoandar.sakuraerrorcaptor.model.Environment;
import br.com.quintoandar.sakuraerrorcaptor.model.Level;
import br.com.quintoandar.sakuraerrorcaptor.model.Log;
import br.com.quintoandar.sakuraerrorcaptor.model.LogOccurrence;
import br.com.quintoandar.sakuraerrorcaptor.model.Occurrence;
import br.com.quintoandar.sakuraerrorcaptor.repository.LogOccurrenceRepository;
import br.com.quintoandar.sakuraerrorcaptor.service.interfaces.LogOccurrenceService;

@Service
public class LogOccurrenceImpl implements LogOccurrenceService{

	@Autowired
	LogOccurrenceRepository logOccurrenceRepository;

	@Override
	public List<LogOccurrence> findAll() {
		return logOccurrenceRepository.findAll();
	}

	@Override
	public Optional<LogOccurrence> findById(Long id) {
		return logOccurrenceRepository.findById(id);
	}

	@Override
	public List<LogOccurrence> findByFilter(String environment, String level, String title, String location, String orderBy) {
		if(!level.isEmpty()){
			return this.findByLevel(Level.valueOf(level));
		}

		if(!title.isEmpty()){
			return this.findByTitle(title);
		}

		if(!location.isEmpty()){
			return this.findByLocation(location);
		}

		return findAll();
	}

	private List<LogOccurrence> findByLevel(Level level) {
		return logOccurrenceRepository.findByLogLevel(level);
	}

	private List<LogOccurrence> findByTitle(String title) {
		return logOccurrenceRepository.findByOccurrenceTitle(title);
	}

	private List<LogOccurrence> findByLocation(String location) {
		return logOccurrenceRepository.findByLogTrackedSystemLocation(location);
	}

	@Override
	public List<LogOccurrence> findByEnvironment(Environment environment) {
		return logOccurrenceRepository.findByLogEnvironment(environment);
	}

	@Override
	public List<LogOccurrence> findByLogIdAndOccurrenceId(Long logId, Long occurrenceId) {
		return logOccurrenceRepository.findByLogIdAndOccurrenceId(logId, occurrenceId);
	}

	@Override
	public void delete(Long id) {
		logOccurrenceRepository.deleteById(id);
	}

	@Override
	public LogOccurrence save(LogOccurrence logoccurrence) {
		return logOccurrenceRepository.save(logoccurrence);
	}

	@Override
	public LogOccurrence saveFromArchive(Long id, Log log, Occurrence occurrence, LocalDateTime occurredIn) {
		if (!logOccurrenceRepository.findById(id).isPresent()) {
			LogOccurrence logOccurrence = new LogOccurrence();
			logOccurrence.setId(id);
			logOccurrence.setLog(log);
			logOccurrence.setOccurrence(occurrence);
			logOccurrence.setOccurredIn(occurredIn);
			
			return logOccurrenceRepository.save(logOccurrence);
		}
		return logOccurrenceRepository.findById(id).get();
	}
	
	
}
