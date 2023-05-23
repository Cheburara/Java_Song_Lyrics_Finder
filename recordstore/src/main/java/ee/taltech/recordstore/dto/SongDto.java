package ee.taltech.recordstore.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class SongDto {
    private String Title;
    private LocalDate releaseDate;
    private String genre;
    private String albumName;
    private String artistName;
    private String lyricText;

}
