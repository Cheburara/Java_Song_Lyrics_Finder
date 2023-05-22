package ee.taltech.recordstore.repository;

import ee.taltech.recordstore.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GenreRepository extends JpaRepository<Genre, UUID> {

   Genre findGenreByName(String name);
}
