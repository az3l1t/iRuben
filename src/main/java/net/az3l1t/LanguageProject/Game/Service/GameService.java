package net.az3l1t.LanguageProject.Game.Service;

import net.az3l1t.LanguageProject.Game.Model.Game;
import net.az3l1t.LanguageProject.Game.Repository.GameRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Service
public class GameService {
    private GameRepository repository;
    public GameService(GameRepository repository) {
        this.repository = repository;
    }

    public List<Game> getAllWords(){
        return repository.findAll();
    }
}
