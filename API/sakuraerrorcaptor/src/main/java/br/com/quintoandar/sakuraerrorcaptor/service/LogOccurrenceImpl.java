package br.com.quintoandar.sakuraerrorcaptor.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.quintoandar.sakuraerrorcaptor.model.enums.Environment;
import br.com.quintoandar.sakuraerrorcaptor.model.enums.Level;
import br.com.quintoandar.sakuraerrorcaptor.dto.LogDetailsDTO;
import br.com.quintoandar.sakuraerrorcaptor.mapper.LogOccurrenceMapper;
import br.com.quintoandar.sakuraerrorcaptor.model.Log;
import br.com.quintoandar.sakuraerrorcaptor.model.LogOccurrence;
import br.com.quintoandar.sakuraerrorcaptor.model.Occurrence;
import br.com.quintoandar.sakuraerrorcaptor.repository.LogOccurrenceRepository;
import br.com.quintoandar.sakuraerrorcaptor.service.interfaces.LogOccurrenceService;

@Service
public class LogOccurrenceImpl implements LogOccurrenceService{

	@Autowired
	private LogOccurrenceRepository logOccurrenceRepository;
	private LogOccurrenceMapper mapper = new LogOccurrenceMapper();

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
			return this.findByEnvironmentAndLevel(Environment.valueOf(environment), Level.valueOf(level));
		}

		if(!title.isEmpty()){
			return this.findByEnvironmentAndTitle(Environment.valueOf(environment), title);
		}

		if(!location.isEmpty()){
			return this.findByEnvironmentAndLocation(Environment.valueOf(environment), location);
		}

		return this.findByEnvironment(Environment.valueOf(environment));
	}

	private List<LogOccurrence> findByEnvironmentAndLevel(Environment environment, Level level) {
		return logOccurrenceRepository.findByLogEnvironmentAndLogLevel(environment, level);
	}

	private List<LogOccurrence> findByEnvironmentAndTitle(Environment environment, String title) {
		return logOccurrenceRepository.findByLogEnvironmentAndOccurrenceTitle(environment, title);
	}

	private List<LogOccurrence> findByEnvironmentAndLocation(Environment environment, String location) {
		return logOccurrenceRepository.findByLogEnvironmentAndLogTrackedSystemLocation(environment, location);
	}

	private List<LogOccurrence> findByEnvironment(Environment environment) {
		return logOccurrenceRepository.findByLogEnvironment(environment);
	}

	@Override
	public List<LogOccurrence> findByLogIdAndOccurrenceId(Long logId, Long occurrenceId) {
		return logOccurrenceRepository.findByLogIdAndOccurrenceId(logId, occurrenceId);
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

	@Override
	public void delete(Long id) {
		logOccurrenceRepository.deleteById(id);
	}

	@Override
	public List<LogDetailsDTO> countLogOccurrenceByLogIdAndOccurrenceId(Long logId, Long occurrenceId) {
		return mapper.mapTupleToDTO(logOccurrenceRepository.countLogOccurrencebyLogIdAndOccurrenceId(logId, occurrenceId));
	}

	@Override
	public List<LogDetailsDTO> countLogOccurrence(Optional<String> environment, Optional<String> filterBy,
			Optional<String> filter, Optional<String> orderBy) {
		
		String queryFilter = "";
		String queryFilterBy = "";
		String queryEnvironment = "";
		
		if (environment.isPresent()) {			
			queryEnvironment = environment.get();
			Environment.isFound(queryEnvironment);
		}
		
		if(filterBy.isPresent() && filter.isPresent()) {
			queryFilter = filter.get();
			queryFilterBy = filterBy.get();
		}
		
		if (orderBy.isPresent() && orderBy.equals("level")) {
			return mapper.mapTupleToDTO(logOccurrenceRepository.countLogOccurrenceOrderByLevel(queryEnvironment, queryFilterBy, queryFilter));
		}
		return mapper.mapTupleToDTO(logOccurrenceRepository.countLogOccurrenceOrderByCount(queryEnvironment, queryFilterBy, queryFilter));
	}

	@Override
	public List<LogDetailsDTO> countAllLogOccurrence() {
		return mapper.mapTupleToDTO(logOccurrenceRepository.countLogOccurrenceOrderByLevel("", "", ""));
	}

	@Override
	@Transactional
	public void deleteByLogIdAndOccurrenceId(Long logId, Long occurrenceId) {
		logOccurrenceRepository.deleteByLogIdAndOccurrenceId(logId, occurrenceId);
	}
}
