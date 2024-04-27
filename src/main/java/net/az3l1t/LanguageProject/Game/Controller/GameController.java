package net.az3l1t.LanguageProject.Game.Controller;

import net.az3l1t.LanguageProject.Game.Model.Game;
import net.az3l1t.LanguageProject.Game.Service.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("api/v1/game")
public class GameController {
    private GameService service;

    public GameController(GameService service) {
        this.service = service;
    }

    @GetMapping
    public List<Game> getAllWords(){
        return service.getAllWords();
    }

    @GetMapping("/random-word")
    public ResponseEntity<Map<String, String>> getRandomWord() {
        List<Game> allWords = service.getAllWords();

        if (allWords.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("error", "No words found in the database."));
        }

        Random random = new Random();
        Game randomWord = allWords.get(random.nextInt(allWords.size()));

        Map<String, String> wordMap = new HashMap<>();
        wordMap.put("word", randomWord.getWord());
        wordMap.put("translation", randomWord.getRussianWord());

        return ResponseEntity.ok(wordMap);
    }

}
