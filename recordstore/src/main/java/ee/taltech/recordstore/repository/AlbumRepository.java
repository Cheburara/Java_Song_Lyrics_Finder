package ee.taltech.recordstore.repository;

import ee.taltech.recordstore.entity.Album;
import ee.taltech.recordstore.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AlbumRepository extends JpaRepository<Album, UUID> {
    List<Album> findAllByArtist(Artist artist);

    Album findAlbumByArtistAndReleaseYear(Artist artist, int releaseYear);
}
