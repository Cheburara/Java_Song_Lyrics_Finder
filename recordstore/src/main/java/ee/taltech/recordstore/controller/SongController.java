package ee.taltech.recordstore.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/songs?")
@RequiredArgsConstructor

public class SongController {

    @GetMapping
    public String getSong(@RequestParam("n") Integer number){
        System.out.println(number);
        if(number > 5){
            return "Hello, Five";
        }
        return "Hello, whatever";
    }
}
