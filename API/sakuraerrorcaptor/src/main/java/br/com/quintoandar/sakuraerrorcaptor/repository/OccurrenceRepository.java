package br.com.quintoandar.sakuraerrorcaptor.repository;

import br.com.quintoandar.sakuraerrorcaptor.model.Occurrence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OccurrenceRepository extends JpaRepository<Occurrence, Long> {

    public Occurrence findByTitle(String title);
    public Optional<Occurrence> findByTitleAndDetail(String title,String detail);

}
