package br.com.quintoandar.sakuraerrorcaptor.service;

import br.com.quintoandar.sakuraerrorcaptor.model.Occurrence;

import br.com.quintoandar.sakuraerrorcaptor.model.json.OccurrenceJson;

import br.com.quintoandar.sakuraerrorcaptor.repository.OccurrenceRepository;
import br.com.quintoandar.sakuraerrorcaptor.service.interfaces.OccurrenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import javax.transaction.Transactional;

@Service
public class OccurrenceServiceImpl implements OccurrenceService {

    private final OccurrenceRepository repository;

    @Autowired
    OccurrenceServiceImpl(OccurrenceRepository repository){
        this.repository = repository;
    }

    @Override
    public Optional<Occurrence> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Occurrence findByTitle(String title) {
        return repository.findByTitle(title);
    }

    @Override
    public Occurrence save(Occurrence occurrence) {
        return repository.save(occurrence);
    }

	@Override
	public Occurrence saveOccurrenceFromArchive(OccurrenceJson occurrenceJson) {
		if (!repository.findById(occurrenceJson.getId()).isPresent()) {
            Occurrence occurrence = new Occurrence(occurrenceJson.getId(),occurrenceJson.getTitle(),occurrenceJson.getDetail());
            repository.save(occurrence);
        }
        return repository.findById(occurrenceJson.getId()).get();
	}

	@Override
	public Occurrence save(String title, String detail) {
		Occurrence o = new Occurrence(null, title, detail);
		return repository.save(o);
	}

	@Override
	public Optional<Occurrence> findByTitleAndDetail(String title, String detail) {
		return repository.findByTitleAndDetail(title, detail);
	}

	@Override
	@Transactional
	public Occurrence saveOccurrenceFromArchive(String title, String detail) {
		if (!repository.findByTitleAndDetail(title,detail).isPresent()) {
			save(title,detail);
		}
		return repository.findByTitleAndDetail(title,detail).get();
	}
}
