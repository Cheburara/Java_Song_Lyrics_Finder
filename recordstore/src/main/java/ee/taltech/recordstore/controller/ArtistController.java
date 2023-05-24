package ee.taltech.recordstore.controller;

import ee.taltech.recordstore.dto.ArtistDto;
import ee.taltech.recordstore.service.ArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/artists")
@RequiredArgsConstructor

public class ArtistController {

    private final ArtistService artistService;
    @GetMapping
    public List<ArtistDto> getAllArtists(){
        return artistService.getAllArtist();

    }

}
