package ee.taltech.recordstore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String Title;
    private Integer releaseYear;

    @ManyToOne
    @JoinColumn(name="genre_id")
    private Genre genre;

    @ManyToOne
    @JoinColumn(name="artist_id")
    private Artist artist;

}
