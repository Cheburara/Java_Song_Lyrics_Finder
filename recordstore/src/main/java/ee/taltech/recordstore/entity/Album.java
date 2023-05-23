package ee.taltech.recordstore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Album {

    public Album(String title, Integer releaseYear, Artist artist){
        this.Title = title;
        this.releaseYear = releaseYear;
        this.artist = artist;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String Title;
    @ManyToOne
    @JoinColumn(name="artist_id")
    private Artist artist;

//    @ManyToMany
//    @JoinColumn(name="artist_id.album_id")
//    private List<Artist> artist;

    private Integer releaseYear;

}
