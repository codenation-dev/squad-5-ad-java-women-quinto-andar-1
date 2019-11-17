package br.com.quintoandar.sakuraerrorcaptor.service.interfaces;

import br.com.quintoandar.sakuraerrorcaptor.model.TrackedSystem;

import java.util.List;
import java.util.Optional;

public interface TrackedSystemService {
    public Iterable<TrackedSystem> findAll();
    public Optional<TrackedSystem> findById(Long id);
    public TrackedSystem save(TrackedSystem trackedSystem);
    public TrackedSystem put(TrackedSystem trackedSystem);
    public void delete(Long id);
    public void delete(TrackedSystem trackedSystem);

    public List<TrackedSystem> findByName(String name);
    public Optional<TrackedSystem> findByToken(String token);
    public List<TrackedSystem> findByTenantId(Long tenantId);

}
