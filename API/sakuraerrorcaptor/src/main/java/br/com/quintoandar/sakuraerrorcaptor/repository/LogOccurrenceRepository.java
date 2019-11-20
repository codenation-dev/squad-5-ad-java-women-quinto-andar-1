package br.com.quintoandar.sakuraerrorcaptor.repository;

import java.util.List;

import javax.persistence.Tuple;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.quintoandar.sakuraerrorcaptor.model.enums.Environment;
import br.com.quintoandar.sakuraerrorcaptor.model.enums.Level;
import br.com.quintoandar.sakuraerrorcaptor.model.LogOccurrence;

@Repository
public interface LogOccurrenceRepository extends JpaRepository<LogOccurrence, Long>{
	public List<LogOccurrence> findByLogIdAndOccurrenceId(Long logId,Long occurrenceId);

	public List<LogOccurrence> findByLogLevel(Level level);
	public List<LogOccurrence> findByOccurrenceTitle(String title);
	public List<LogOccurrence> findByLogTrackedSystemLocation(String location);

	public List<LogOccurrence> findByLogEnvironment(Environment environment);
	public List<LogOccurrence> findByLogEnvironmentAndLogLevel(Environment environment, Level level);
	public List<LogOccurrence> findByLogEnvironmentAndOccurrenceTitle(Environment environment, String title);
	public List<LogOccurrence> findByLogEnvironmentAndLogTrackedSystemLocation(Environment environment, String location);

	@Query(nativeQuery = true, value = "Select count(*) as event, l.level, l.environment, o.title, o.detail, lo.log_id, lo.occurrence_id, t.location  "
			+ "from log_occurrence lo, log l, occurrence o, tracked_system t "
			+ "where lo.log_id=l.id and lo.occurrence_id=o.id and l.tracked_system_id=t.id"
			+ " and l.id=?1 and o.id=?2 "
			+ "group by l.level, l.environment, o.title, o.detail, lo.log_id, lo.occurrence_id, t.location;")
	public List<Tuple> countLogOccurrence(Long logId, Long occurrenceId);
}
