package ee.taltech.recordstore.service;

import ee.taltech.recordstore.dto.ArtistDto;
import ee.taltech.recordstore.mapper.RecordStoreMapper;
import ee.taltech.recordstore.repository.ArtistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ArtistService {

    private final ArtistRepository artistRepository;

    private final RecordStoreMapper mapper;

    public List<ArtistDto> getAllArtist(){
        return mapper.mapArtistEntitiesToDtos(artistRepository.findAll());
    }
}
