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
public class Lyric {



    public Lyric(Song song, String title, String lyric) {
        this.song = song;
        this.title = title;
        this.lyric = lyric;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @OneToOne
    @JoinColumn(name="song.title")
    private Song song;
    private String title;
    private String lyric;
}
