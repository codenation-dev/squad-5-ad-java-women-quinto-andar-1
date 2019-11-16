package br.com.quintoandar.sakuraerrorcaptor.repository;

import br.com.quintoandar.sakuraerrorcaptor.model.Occurrence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OccurrenceRepository extends JpaRepository<Occurrence, Long> {

    public Occurrence findByTitle(String title);

}
