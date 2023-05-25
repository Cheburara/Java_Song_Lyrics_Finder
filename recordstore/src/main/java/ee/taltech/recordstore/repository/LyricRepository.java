package ee.taltech.recordstore.repository;

import ee.taltech.recordstore.entity.Lyric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository

public interface LyricRepository extends JpaRepository<Lyric, UUID> {
    List<Lyric> findAllBySongTitle (String title);

}
