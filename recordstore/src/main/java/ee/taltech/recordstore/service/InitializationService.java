package ee.taltech.recordstore.service;

import ee.taltech.recordstore.entity.*;
import ee.taltech.recordstore.repository.*;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor

public class InitializationService {

    private final GenreRepository GenreRepository;
    private final ArtistRepository ArtistRepository;
    private final AlbumRepository AlbumRepository;
    private final SongRepository SongRepository;
    private final LyricRepository LyricRepository;


    @PostConstruct
    private void initAppData() {

        GenreRepository.save(new Genre("classic"));
        GenreRepository.save(new Genre("pop"));
        GenreRepository.save(new Genre("punk"));
        GenreRepository.save(new Genre("rock"));

        ArtistRepository.save(new Artist("Lady Gaga"));
        ArtistRepository.save(new Artist("Korol I Shut"));
        ArtistRepository.save(new Artist("Ariana Grande"));
        ArtistRepository.save(new Artist("Rammstein"));
        ArtistRepository.save(new Artist("Nicollo Paganini"));

        var ladyGaga = ArtistRepository.findArtistByName("Lady Gaga");
        var rammstein = ArtistRepository.findArtistByName("Rammstein");
        var arianaGrande = ArtistRepository.findArtistByName("Ariana Grande");
        var nicolloPaganini = ArtistRepository.findArtistByName("Nicollo Paganini");


        AlbumRepository.save(new Album("The fame", 2008, ladyGaga));

        AlbumRepository.save(new Album("Sonner", 2001, rammstein));
        AlbumRepository.save(new Album("Reise, Reise", 2004, rammstein));

        AlbumRepository.save(new Album("Sweetener", 2018, arianaGrande));

        AlbumRepository.save(new Album("Capricci 24", 1802, nicolloPaganini));

        var pop = GenreRepository.findGenreByName("pop");
        var fameAlbum = AlbumRepository.findAlbumByArtistAndReleaseYear(ladyGaga, 2008);

        var rock= GenreRepository.findGenreByName("rock");
        var mutterAlbum = AlbumRepository.findAlbumByArtistAndReleaseYear(rammstein, 2001);
        var reiseAlbum = AlbumRepository.findAlbumByArtistAndReleaseYear(rammstein, 2004);

        var classic = GenreRepository.findGenreByName("classic");
        var capricciAlbum = AlbumRepository.findAlbumByArtistAndReleaseYear( nicolloPaganini, 1802);

        var justDanceLyrics = "Lyrics for Just Dance";
        var paparazziLyrics = "Lyrics for Paparazzi";

        var sonneLyrics = "Lyrics for Sonne";
        var feuerFreiLyrics = "Lyrics for Feuer frei!";

        var ohneDichLyrics = "Lyrics for Ohne dich!";
        var amourLyrics = "Lyrics for Amour";

        var noneLyrics = "none";

        var lyricJD = LyricRepository.save(new Lyric("Just Dance", justDanceLyrics));
        var lyricPP = LyricRepository.save(new Lyric("Paparazzi", paparazziLyrics));

        var lyricSO = LyricRepository.save(new Lyric("Sonne", sonneLyrics));
        var lyricFF = LyricRepository.save(new Lyric("Feuer frei!", feuerFreiLyrics));

        var lyricOD = LyricRepository.save(new Lyric("Ohne dich!", ohneDichLyrics));
        var lyricAM = LyricRepository.save(new Lyric("Feuer frei!", amourLyrics));

        var lyricNP = LyricRepository.save(new Lyric("Capricci 24", noneLyrics));

        var releaseDate = LocalDate.of(2008, 4, 26);
        SongRepository.save(new Song("Just Dance", releaseDate, fameAlbum, ladyGaga, pop,lyricJD ));
        SongRepository.save(new Song("Paparazzi", releaseDate, fameAlbum, ladyGaga, pop,lyricPP));

        var releaseDate2 = LocalDate.of(2001, 5, 20);
        SongRepository.save(new Song("Sonne", releaseDate2, mutterAlbum, rammstein, rock, lyricSO));
        SongRepository.save(new Song("Feuer frei!", releaseDate2,mutterAlbum, rammstein, rock, lyricFF));

        var releaseDate3 = LocalDate.of(2004, 9, 27);
        SongRepository.save(new Song("Ohne dich!", releaseDate3, reiseAlbum, rammstein, rock, lyricOD));
        SongRepository.save(new Song("Amour", releaseDate3,reiseAlbum, rammstein, rock, lyricAM));

        var releaseDate4 = LocalDate.of(1802, 8, 14);
        SongRepository.save(new Song("Capricci 24", releaseDate4, capricciAlbum, nicolloPaganini, classic, lyricNP));


    }


    }

