package br.com.quintoandar.sakuraerrorcaptor.service.interfaces;

import java.util.Optional;
import java.time.LocalDateTime;
import java.util.List;

import br.com.quintoandar.sakuraerrorcaptor.model.Log;
import br.com.quintoandar.sakuraerrorcaptor.model.LogOccurrence;
import br.com.quintoandar.sakuraerrorcaptor.model.Occurrence;

public interface LogOccurrenceService {
	
	Optional <LogOccurrence> findById(Long id);
	List<LogOccurrence> findAll();
	void delete (Long id);
	LogOccurrence saveFromArchive(Long id,Log log, Occurrence occurrence, LocalDateTime occurredIn);
	LogOccurrence save (LogOccurrence logoccurrence);
	List<LogOccurrence> findByLogIdAndOccurrenceId(Long logId, Long occurrenceId);

	List<LogOccurrence> findByFilter(String environment, String level, String title, String location, String orderBy);
}
