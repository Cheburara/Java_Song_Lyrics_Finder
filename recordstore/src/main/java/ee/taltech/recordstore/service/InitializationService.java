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

        ArtistRepository.save(new Artist("Lady Gaga"));
        ArtistRepository.save(new Artist("Korol I Shut"));
        ArtistRepository.save(new Artist("Ariana Grande"));

        var ladyGaga = ArtistRepository.findArtistByName("Lady Gaga");
        AlbumRepository.save(new Album("The fame", 2008, ladyGaga));

        var pop = GenreRepository.findGenreByName("pop");
        var fameAlbum = AlbumRepository.findAlbumByArtistAndReleaseYear(ladyGaga, 2008);
        var releaseData = LocalDate.of(2008, 4, 26);

//        SongRepository.save(new Song("Just Dance", fameAlbum, ladyGaga, pop));
//        SongRepository.save(new Song("Paparazzi", fameAlbum, ladyGaga, pop));

        var justDanceSong = SongRepository.save(new Song("Just Dance", fameAlbum, ladyGaga, pop));
        var paparazziSong = SongRepository.save(new Song("Paparazzi", fameAlbum, ladyGaga, pop));

        LyricRepository.save(new Lyric(justDanceSong, "Sample lyrics for Just Dance"));
        LyricRepository.save(new Lyric(paparazziSong, "Sample lyrics for Paparazzi"));
//        LyricRepository.save(new lyric(justDanceSong, "Sample lyrics for Just Dance"));
//        LyricRepository.save(new Lyric(paparazziSong, "Sample lyrics for Paparazzi"));


    }


    }

