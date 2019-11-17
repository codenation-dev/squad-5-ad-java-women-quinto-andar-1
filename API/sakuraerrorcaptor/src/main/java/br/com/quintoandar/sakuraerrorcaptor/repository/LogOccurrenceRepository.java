package br.com.quintoandar.sakuraerrorcaptor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.quintoandar.sakuraerrorcaptor.model.Environment;
import br.com.quintoandar.sakuraerrorcaptor.model.Level;
import br.com.quintoandar.sakuraerrorcaptor.model.LogOccurrence;

@Repository
public interface LogOccurrenceRepository extends JpaRepository<LogOccurrence, Long>{
	public List<LogOccurrence> findByLogIdAndOccurrenceId(Long logId,Long occurrenceId);

	public List<LogOccurrence> findByLogLevel(Level level);
	public List<LogOccurrence> findByOccurrenceTitle(String title);
	public List<LogOccurrence> findByLogTrackedSystemLocation(String location);

	public List<LogOccurrence> findByLogEnvironment(Environment environment);
	public List<LogOccurrence> findByLogEnvironmentAndLogLevel(Environment environment, Level level);
}
