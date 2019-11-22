package br.com.quintoandar.sakuraerrorcaptor.service.interfaces;

import br.com.quintoandar.sakuraerrorcaptor.model.Occurrence;

import br.com.quintoandar.sakuraerrorcaptor.model.json.OccurrenceJson;

import java.util.Optional;

public interface OccurrenceService {

    public Optional<Occurrence> findById(Long id);
    public Occurrence findByTitle(String title);
    public Occurrence save(Occurrence occurrence);
    public Occurrence save(String title, String detail);
    public Optional<Occurrence> findByTitleAndDetail(String title,String detail);
    public Occurrence saveOccurrenceFromArchive(OccurrenceJson occurrenceJson);
    public Occurrence saveOccurrenceFromArchive(String title, String detail);

}
