package br.com.quintoandar.sakuraerrorcaptor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.quintoandar.sakuraerrorcaptor.model.Environment;
import br.com.quintoandar.sakuraerrorcaptor.model.Level;
import br.com.quintoandar.sakuraerrorcaptor.model.Log;
import br.com.quintoandar.sakuraerrorcaptor.model.Tenant;
import br.com.quintoandar.sakuraerrorcaptor.model.TrackedSystem;
import br.com.quintoandar.sakuraerrorcaptor.repository.LogRepository;
import br.com.quintoandar.sakuraerrorcaptor.service.interfaces.LogService;

@Service
public class LogServiceImpl implements LogService{
	
	@Autowired
	LogRepository logRepository;
	
	@Override
	public List<Log> findByEnvironment(Environment environment) {
		return logRepository.findByEnvironment(environment);
	}

	@Override
	public List<Log> findByLevel(Level level) {
		return logRepository.findByLevel(level);
	}

	@Override
	public List<Log> findByTenantId(Long id) {
		//return logRepository.findByTenantId(id);
		return null;
	}

	@Override
	public List<Log> findByTenantUserId(Long id) {
		//return logRepository.findByTenantUserId(id);
		return null;
	}

	@Override
	public List<Log> findByTenantIdAndTrackedSystemId(Long id) {
		return logRepository.findByTrackedSystemId(id);
	}

	@Override
	public Log saveLogFromArchive(Environment environment, Level level,	TrackedSystem trackedSystem) {
		 if (!logRepository.findByEnvironmentAndLevelAndTrackedSystemId(environment,level,trackedSystem.getId()).isPresent()) {
	            Log log = new Log(null, environment,level,trackedSystem);
	            logRepository.save(log);
	        }
	        return logRepository.findByEnvironmentAndLevelAndTrackedSystemId(environment,level,trackedSystem.getId()).get();
	}

	@Override
	public Optional<Log> findById(Long id) {
		return logRepository.findById(id);
	}

	@Override
	public List<Log> findAll() {
		return logRepository.findAll();
	}

	@Override
	public Log save(Log log) {
		return logRepository.save(log);
	}

	@Override
	public void delete(Long id) {

		logRepository.deleteById(id);
	}

}
