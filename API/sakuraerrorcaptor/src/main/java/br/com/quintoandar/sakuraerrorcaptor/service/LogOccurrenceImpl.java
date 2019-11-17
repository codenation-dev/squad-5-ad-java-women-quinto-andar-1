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
	public Optional<LogOccurrence> findById(Long id) {
		// TODO Auto-generated method stub
		return logOccurrenceRepository.findById(id);
	}

	@Override
	public List<LogOccurrence> findAll() {
		// TODO Auto-generated method stub
		return logOccurrenceRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		logOccurrenceRepository.deleteById(id);
	}

	@Override
	public LogOccurrence save(LogOccurrence logoccurrence) {
		// TODO Auto-generated method stub
		return logOccurrenceRepository.save(logoccurrence);
	}

	@Override
	public List<LogOccurrence> findByLevel(Level level) {
		// TODO Auto-generated method stub
		return logOccurrenceRepository.findByLogLevel(level);
	}

	@Override
	public List<LogOccurrence> findByEnvironment(Environment environment) {
		// TODO Auto-generated method stub
		return logOccurrenceRepository.findByLogEnvironment(environment);
	}

	@Override
	public List<LogOccurrence> findByEnvironmentAndLevel(Environment environment,Level level) {
		// TODO Auto-generated method stub
		return logOccurrenceRepository.findByLogEnvironmentAndLogLevel(environment, level);
	}

	@Override
	public List<LogOccurrence> findByLogIdAndOccurrenceId(Long logId, Long occurrenceId) {
		return logOccurrenceRepository.findByLogIdAndOccurrenceId(logId, occurrenceId);
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
