package ee.taltech.recordstore.repository;

import ee.taltech.recordstore.entity.Genre;
import ee.taltech.recordstore.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository

public interface SongRepository extends JpaRepository<Song, UUID> {

  List<Song> findAllByGenre(Genre genre);
}
