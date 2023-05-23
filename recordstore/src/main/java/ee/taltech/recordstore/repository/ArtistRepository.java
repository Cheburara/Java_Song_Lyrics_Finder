package ee.taltech.recordstore.repository;

import ee.taltech.recordstore.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository

public interface ArtistRepository extends JpaRepository<Artist, UUID> {

    Artist findArtistByName (String name);
}
