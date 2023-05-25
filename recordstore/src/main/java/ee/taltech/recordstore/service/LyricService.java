package ee.taltech.recordstore.service;

import ee.taltech.recordstore.dto.ArtistDto;
import ee.taltech.recordstore.dto.LyricDto;
import ee.taltech.recordstore.mapper.RecordStoreMapper;
import ee.taltech.recordstore.repository.ArtistRepository;
import ee.taltech.recordstore.repository.LyricRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class LyricService {

    private final LyricRepository lyricRepository;
    private final RecordStoreMapper mapper;

    public List<LyricDto> findAllBySongTitle(){
        return mapper.mapLyricEntitiesToDtos(lyricRepository.findAll());
    }
}
