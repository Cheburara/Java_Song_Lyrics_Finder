package ee.taltech.recordstore.service;

import ee.taltech.recordstore.entity.Album;
import ee.taltech.recordstore.entity.Artist;
import ee.taltech.recordstore.entity.Genre;
import ee.taltech.recordstore.entity.Song;
import ee.taltech.recordstore.repository.AlbumRepository;
import ee.taltech.recordstore.repository.ArtistRepository;
import ee.taltech.recordstore.repository.GenreRepository;
import ee.taltech.recordstore.repository.SongRepository;
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


    @PostConstruct
    private void initAppData() {
        GenreRepository.save(new Genre("techno"));
        GenreRepository.save(new Genre("pop"));
        GenreRepository.save(new Genre("punk"));

        ArtistRepository.save(new Artist("Lady Gaga"));
        ArtistRepository.save(new Artist("Korol I Shut"));
        ArtistRepository.save(new Artist("Ariana Grande"));

        var ladyGaga = ArtistRepository.findArtistByName("Lady Gaga");

        var pop =GenreRepository.findGenreByName("pop");
        var fameAlbum = AlbumRepository.findAlbumByArtistAndReleaseYear(ladyGaga, 2008);
        var releaseData = LocalDate.of(2008, 4, 26);

        SongRepository.save(new Song("Just Dance", fameAlbum, ladyGaga, pop));
    }


    }

