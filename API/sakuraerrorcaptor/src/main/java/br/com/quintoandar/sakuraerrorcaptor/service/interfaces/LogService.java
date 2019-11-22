package br.com.quintoandar.sakuraerrorcaptor.service.interfaces;

import java.util.List;
import java.util.Optional;

import br.com.quintoandar.sakuraerrorcaptor.model.enums.Environment;
import br.com.quintoandar.sakuraerrorcaptor.model.enums.Level;
import br.com.quintoandar.sakuraerrorcaptor.model.Log;
import br.com.quintoandar.sakuraerrorcaptor.model.TrackedSystem;

public interface LogService {

	public Optional<Log> findById(Long id);
	public List<Log> findAll();
	public Log save(Log log);
	public void delete(Long id);
	
	public List<Log> findByEnvironment(Environment environment);
	public List<Log> findByLevel(Level level);
	public List<Log> findByTenantId(Long id);
	public List<Log> findByTenantUserId(Long id);
	public List<Log> findByTenantIdAndTrackedSystemId(Long id);
	public Log saveLogFromArchive(Environment environment, Level level, TrackedSystem trackedSystem);
	


}
