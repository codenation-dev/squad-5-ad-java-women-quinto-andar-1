package br.com.quintoandar.sakuraerrorcaptor.service.interfaces;

import java.util.Optional;
import java.time.LocalDateTime;
import java.util.List;

import br.com.quintoandar.sakuraerrorcaptor.model.Environment;
import br.com.quintoandar.sakuraerrorcaptor.model.Level;
import br.com.quintoandar.sakuraerrorcaptor.model.Log;
import br.com.quintoandar.sakuraerrorcaptor.model.LogOccurrence;
import br.com.quintoandar.sakuraerrorcaptor.model.Occurrence;

public interface LogOccurrenceService {
	
	public Optional <LogOccurrence> findById(Long id);
	public List<LogOccurrence> findAll();
	public void delete (Long id);
	public LogOccurrence saveFromArchive(Long id,Log log, Occurrence occurrence, LocalDateTime occurredIn);
	public LogOccurrence save (LogOccurrence logoccurrence);
	public List<LogOccurrence> findByLevel(Level level);
	public List<LogOccurrence> findByEnvironment(Environment environment);
	public List<LogOccurrence> findByEnvironmentAndLevel(Environment environment, Level level);
	public List<LogOccurrence> findByLogIdAndOccurrenceId(Long logId, Long occurrenceId);

    List<LogOccurrence> findByDescription(String description);
}
