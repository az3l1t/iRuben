package net.az3l1t.LanguageProject.Alphabet.Controller;

import net.az3l1t.LanguageProject.Alphabet.Model.Alphabet;
import net.az3l1t.LanguageProject.Alphabet.Service.AlphabetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/alphabet")
public class AlphabetController {
    private AlphabetService service;

    public AlphabetController(AlphabetService service) {
        this.service = service;
    }

    @GetMapping
    public List<Alphabet> getAlphabet(){
        return service.getAllAlphabet();
    }

    @GetMapping("/{consumerId}")
    public Optional<Alphabet> getLetterById(@PathVariable("consumerId") Long id){
        return service.getLetter(id);
    }
}
