package ee.taltech.recordstore.controller;

import ee.taltech.recordstore.dto.LyricDto;
import ee.taltech.recordstore.dto.SongDto;
import ee.taltech.recordstore.repository.SongRepository;
import ee.taltech.recordstore.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/songs")
@RequiredArgsConstructor

public class SongController {

    private final SongService songService;

    @GetMapping
    public List<SongDto> getSong(@RequestParam(name = "genre", required = false) String genre){
        if (genre == null || genre == ""){
            return songService.getAllSongs();
        }
        return songService.getSongsByGenre(genre);
    }
    @GetMapping("by-artist")
    public List<SongDto> getSongByArtist(@RequestParam String artist){
        return songService.getSongsByArtist(artist);
    }

    @GetMapping("by-lyrics")
    public List<LyricDto> getSongsByLyrics(@RequestParam (name = "lyric", required = false) String lyric) {
        if (lyric == null || lyric == ""){
            return songService.findAllBySongTitle(lyric);
        }
        return  songService.findAllBySongTitle(lyric); }

}
