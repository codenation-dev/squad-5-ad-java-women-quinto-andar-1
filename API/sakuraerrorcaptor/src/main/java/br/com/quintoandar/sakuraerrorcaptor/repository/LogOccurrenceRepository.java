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

	public void deleteByLogIdAndOccurrenceId(Long logId, Long occurrenceId);

	@Query(nativeQuery = true, value = "Select count(*) as event,max(lo.occurred_in) as occurred_in, l.level, "
			+ "l.environment, o.title, o.detail, lo.log_id, lo.occurrence_id, t.location, t.token  "
			+ "from log_occurrence lo, log l, occurrence o, tracked_system t "
			+ "where lo.log_id=l.id and lo.occurrence_id=o.id and l.tracked_system_id=t.id "
			+ " and l.id=?1 and o.id=?2 "
			+ "group by l.level, l.environment, o.title, o.detail, lo.log_id, lo.occurrence_id, t.location, t.token ;")
	public List<Tuple> countLogOccurrencebyLogIdAndOccurrenceId(Long logId, Long occurrenceId);
	
	@Query(nativeQuery = true, value = "Select count(*) as event,max(lo.occurred_in) as occurred_in, l.level, "
			+ " l.environment, o.title, o.detail, lo.log_id, lo.occurrence_id, t.location, t.token  "
			+ " from log_occurrence lo, log l, occurrence o, tracked_system t "
			+ " where lo.log_id=l.id and lo.occurrence_id=o.id and l.tracked_system_id=t.id "
			+ " and case "
			+ "   when ?1<>'' then l.environment=?1"
			+ "   else l.environment is not null"
			+ " end "
			+ " and case ?2 "
			+ "  when 'level' then l.level=?3  "
			+ "  when 'description' then (o.title like '%'||?3||'%' or o.detail like '%'||?3||'%')"
			+ "  when 'origin' then (t.location like '%'||?3||'%' or t.name like '%'||?3||'%')"
			+ "  else 1=1"
			+ " end "
			+ " group by l.level, l.environment, o.title, o.detail, lo.log_id, lo.occurrence_id, t.location, t.token  "
			+ " order by count(*) desc;")
	public List<Tuple> countLogOccurrenceOrderByCount(String environment,String filterBy, String filter);
	
	@Query(nativeQuery = true, value = "Select count(*) as event,max(lo.occurred_in) as occurred_in, l.level, "
			+ " l.environment, o.title, o.detail, lo.log_id, lo.occurrence_id, t.location, t.token  "
			+ " from log_occurrence lo, log l, occurrence o, tracked_system t "
			+ " where lo.log_id=l.id and lo.occurrence_id=o.id and l.tracked_system_id=t.id "
			+ " and"
			+ " case "
			+ "   when ?1<>'' then l.environment=?1"
			+ "   else l.environment is not null"
			+ " end and "
			+ " case ?2 "
			+ "  when 'level' then l.level=?3  "
			+ "  when 'description' then (o.title like '%'||?3||'%' or o.detail like '%'||?3||'%')"
			+ "  when 'origin' then (t.location like '%'||?3||'%' or t.name like '%'||?3||'%')"
			+ "  else 1=1"
			+ " end "
			+ " group by l.level, l.environment, o.title, o.detail, lo.log_id, lo.occurrence_id, t.location, t.token  "
			+ " order by l.level desc;")
	public List<Tuple> countLogOccurrenceOrderByLevel(String environment,String filterBy, String filter);
	
	
}
