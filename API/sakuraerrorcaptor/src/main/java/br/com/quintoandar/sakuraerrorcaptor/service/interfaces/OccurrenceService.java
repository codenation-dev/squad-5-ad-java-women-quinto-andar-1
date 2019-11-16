package br.com.quintoandar.sakuraerrorcaptor.service.interfaces;

import br.com.quintoandar.sakuraerrorcaptor.model.Occurrence;

import java.util.Optional;

public interface OccurrenceService {

    public Optional<Occurrence> findById(Long id);
    public Occurrence findByTitle(String title);
    public Occurrence save(Occurrence occurrence);

}
