package br.com.quintoandar.sakuraerrorcaptor.repository;

import br.com.quintoandar.sakuraerrorcaptor.model.TrackedSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TrackedSystemRepository extends JpaRepository<TrackedSystem, Long> {
    public List<TrackedSystem> findByName(String name);
    public Optional<TrackedSystem> findByToken(String token);
    public List<TrackedSystem> findByTenantId(Long tenantId);
}
