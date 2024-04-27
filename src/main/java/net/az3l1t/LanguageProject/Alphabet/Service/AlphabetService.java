package net.az3l1t.LanguageProject.Alphabet.Service;

import net.az3l1t.LanguageProject.Alphabet.Model.Alphabet;
import net.az3l1t.LanguageProject.Alphabet.Repository.AlphabetRepository;
import net.az3l1t.LanguageProject.Consumer.Model.Consumer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlphabetService {
    private AlphabetRepository repository;

    public AlphabetService(AlphabetRepository repository) {
        this.repository = repository;
    }

    public Optional<Alphabet> getLetter(Long id){
        return repository.findById(id);
    }
    public List<Alphabet> getAllAlphabet(){
        return repository.findAll();
    }

}
