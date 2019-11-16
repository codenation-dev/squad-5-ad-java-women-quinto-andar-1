package br.com.quintoandar.sakuraerrorcaptor.repository;

import br.com.quintoandar.sakuraerrorcaptor.model.TrackedSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackedSystemRepository extends JpaRepository<TrackedSystem, Long> {
    
}
