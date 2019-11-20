package br.com.quintoandar.sakuraerrorcaptor.service.interfaces;

import java.util.Optional;

import java.time.LocalDateTime;
import java.util.List;

import br.com.quintoandar.sakuraerrorcaptor.dto.LogOccurrenceDTO;
import br.com.quintoandar.sakuraerrorcaptor.model.Log;
import br.com.quintoandar.sakuraerrorcaptor.model.LogOccurrence;
import br.com.quintoandar.sakuraerrorcaptor.model.Occurrence;

public interface LogOccurrenceService {
	
	public Optional <LogOccurrence> findById(Long id);
	public List<LogOccurrence> findAll();
	public void delete (Long id);
	public LogOccurrence saveFromArchive(Long id,Log log, Occurrence occurrence, LocalDateTime occurredIn);
	public LogOccurrence save (LogOccurrence logoccurrence);
	public List<LogOccurrence> findByLogIdAndOccurrenceId(Long logId, Long occurrenceId);

	public List<LogOccurrence> findByFilter(String environment, String level, String title, String location, String orderBy);
	public List<LogOccurrenceDTO> countLogOccurrence(Long logId, Long occurrenceId);
}
