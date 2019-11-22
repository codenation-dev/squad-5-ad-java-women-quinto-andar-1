package br.com.quintoandar.sakuraerrorcaptor.service;

import br.com.quintoandar.sakuraerrorcaptor.dto.TrackedSystemDTO;
import br.com.quintoandar.sakuraerrorcaptor.mapper.TrackedSystemMapper;
import br.com.quintoandar.sakuraerrorcaptor.model.TrackedSystem;
import br.com.quintoandar.sakuraerrorcaptor.repository.TrackedSystemRepository;
import br.com.quintoandar.sakuraerrorcaptor.service.interfaces.TrackedSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackedSystemImpl implements TrackedSystemService {

    private final TrackedSystemRepository _trackedSystemRepository;

    @Autowired
    public TrackedSystemImpl(TrackedSystemRepository trackedSystemRepository) {
        this._trackedSystemRepository = trackedSystemRepository;
    }

    @Override
    public Iterable<TrackedSystem> findAll() {
        return _trackedSystemRepository.findAll();
    }

    @Override
    public Optional<TrackedSystem> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<TrackedSystem> findByName(String name) {
        return _trackedSystemRepository.findByName(name);
    }

    @Override
    public Optional<TrackedSystem> findByToken(String token) {
        return Optional.empty();
    }

    @Override
    public List<TrackedSystem> findByTenantId(Long tenantId) {
        return _trackedSystemRepository.findByTenantId(tenantId);
    }

    @Override
    public TrackedSystem save(TrackedSystemDTO trackedSystemDto) {
    	TrackedSystemMapper mapper = new TrackedSystemMapper();
    	TrackedSystem ts = mapper.map(trackedSystemDto);
        return _trackedSystemRepository.save(ts);
    }

    @Override
    public TrackedSystem put(TrackedSystem trackedSystem) {
        return _trackedSystemRepository.save(trackedSystem);
    }

    @Override
    public void delete(Long id) {
        _trackedSystemRepository.deleteById(id);
    }

    @Override
    public void delete(TrackedSystem trackedSystem) {
        _trackedSystemRepository.delete(trackedSystem);
    }
}
