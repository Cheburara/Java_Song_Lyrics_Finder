package ee.taltech.recordstore.controller;

import ee.taltech.recordstore.dto.ArtistDto;
import ee.taltech.recordstore.dto.LyricDto;
import ee.taltech.recordstore.service.LyricService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/lyrics")
@RequiredArgsConstructor

public class LyricController {

    private final LyricService lyricService;
    @GetMapping
    public List<LyricDto> findAllBySongTitle(){
        return lyricService.findAllBySongTitle();

    }

}
