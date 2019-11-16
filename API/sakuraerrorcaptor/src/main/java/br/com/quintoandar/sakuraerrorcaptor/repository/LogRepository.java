package br.com.quintoandar.sakuraerrorcaptor.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.quintoandar.sakuraerrorcaptor.model.Environment;
import br.com.quintoandar.sakuraerrorcaptor.model.Level;
import br.com.quintoandar.sakuraerrorcaptor.model.Log;

@Repository
public interface LogRepository extends JpaRepository<Log, Long>{
	
	public List<Log> findByEnvironment(Environment environment);
	public List<Log> findByLevel(Level level);
	public List<Log> findByTenantId(Long id);
	public List<Log> findByTenantUserId(Long id);
	public List<Log> findByTenantIdAndTrackedSystemId(Long id);
	public Optional<Log> findByEnvironmentAndLevelAndTenantIdAndTrackedSystemId(Environment environment, Level level,
			Long tenantId, Long id);

}
