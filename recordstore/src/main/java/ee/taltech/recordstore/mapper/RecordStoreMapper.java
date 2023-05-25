package ee.taltech.recordstore.mapper;

import ee.taltech.recordstore.dto.ArtistDto;
import ee.taltech.recordstore.dto.SongDto;
import ee.taltech.recordstore.entity.Artist;
import ee.taltech.recordstore.entity.Song;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component

public class RecordStoreMapper {

    public List<SongDto> mapSongEntitiesToDtos(List<Song> entities) {
        return entities.stream().map(this::mapSongEntityToDto).collect(Collectors.toList());
    }

    public SongDto mapSongEntityToDto(Song entity){
        var dto = new SongDto();
        dto.setTitle(entity.getTitle());
        dto.setReleaseDate(entity.getReleaseYear());
        dto.setAlbumName(entity.getAlbum().getTitle());
        dto.setArtistName(entity.getArtist().getName());
        dto.setGenre(entity.getGenre().getName());
        dto.setLyricText(entity.getLyric().getLyric());
        return dto;

    }

    public List<ArtistDto> mapArtistEntitiesToDtos(List<Artist> entities) {
        return entities.stream().map(this::mapArtistEntitytoDto).toList();

    }

    public ArtistDto mapArtistEntitytoDto(Artist entity){
        var dto = new ArtistDto();
        dto.setName(entity.getName());
        return dto;
    }

    //Song mapSongDtoToEntity(SongDto dto)
}

