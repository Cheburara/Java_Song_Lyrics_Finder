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
        GenreRepository.save(new Genre("techno"));
        GenreRepository.save(new Genre("pop"));
        GenreRepository.save(new Genre("punk"));
        GenreRepository.save(new Genre("rock"));

        ArtistRepository.save(new Artist("Lady Gaga"));
        ArtistRepository.save(new Artist("Korol I Shut"));
        ArtistRepository.save(new Artist("Ariana Grande"));
        ArtistRepository.save(new Artist("Rammstein"));

        var ladyGaga = ArtistRepository.findArtistByName("Lady Gaga");
        var rammstein = ArtistRepository.findArtistByName("Rammstein");
        var arianaGrande = ArtistRepository.findArtistByName("Ariana Grande");

        AlbumRepository.save(new Album("The fame", 2008, ladyGaga));

        AlbumRepository.save(new Album("Sonner", 2001, rammstein));
        AlbumRepository.save(new Album("Reise, Reise", 2004, rammstein));

        AlbumRepository.save(new Album("Sweetener", 2018, arianaGrande));

        var pop = GenreRepository.findGenreByName("pop");
        var fameAlbum = AlbumRepository.findAlbumByArtistAndReleaseYear(ladyGaga, 2008);

        var rock= GenreRepository.findGenreByName("rock");
        var mutterAlbum = AlbumRepository.findAlbumByArtistAndReleaseYear(rammstein, 2001);
        var reiseAlbum = AlbumRepository.findAlbumByArtistAndReleaseYear(rammstein, 2004);

        var releaseDate = LocalDate.of(2008, 4, 26);
        SongRepository.save(new Song("Just Dance", releaseDate, fameAlbum, ladyGaga, pop));
        SongRepository.save(new Song("Paparazzi", releaseDate, fameAlbum, ladyGaga, pop));


        var releaseDate2 = LocalDate.of(2001, 5, 20);
        SongRepository.save(new Song("Sonne", releaseDate2, mutterAlbum, rammstein, rock));
        SongRepository.save(new Song("Feuer frei!", releaseDate2,mutterAlbum, rammstein, rock));

        var releaseDate3 = LocalDate.of(2004, 9, 27);
        SongRepository.save(new Song("Ohne dich!", releaseDate3, reiseAlbum, rammstein, rock));
        SongRepository.save(new Song("Amour", releaseDate3,reiseAlbum, rammstein, rock));



//        var justDanceSong = SongRepository.save(new Song("Just Dance", releaseDate, fameAlbum, ladyGaga, pop));
//        var paparazziSong = SongRepository.save(new Song("Paparazzi", releaseDate, fameAlbum, ladyGaga, pop));
//
//        LyricRepository.save(new Lyric(justDanceSong, "Sample lyrics for Just Dance"));
//        LyricRepository.save(new Lyric(paparazziSong, "Sample lyrics for Paparazzi"));

    }


    }

