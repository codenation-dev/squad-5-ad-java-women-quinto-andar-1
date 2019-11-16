package br.com.quintoandar.sakuraerrorcaptor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.quintoandar.sakuraerrorcaptor.model.Archive;

@Repository
public interface ArchiveRepository extends JpaRepository<Archive, Long> {
	@Query(value = "select * from archive where archive->>'trackedSystemId')::long = ?1", nativeQuery = true)
	public List<Archive> findByLogOccurenceId(Long id);
	
	@Query(value = "delete * from archive where archive->>'trackedSystemId')::long = ?1", nativeQuery = true)
	public void deleteByLogOccurenceId(Long id);
}
