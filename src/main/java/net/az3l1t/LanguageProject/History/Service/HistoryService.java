package net.az3l1t.LanguageProject.History.Service;

import net.az3l1t.LanguageProject.History.Model.History;
import net.az3l1t.LanguageProject.History.Repository.HistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoryService {
    private HistoryRepository repository;

    public HistoryService(HistoryRepository repository) {
        this.repository = repository;
    }

    public List<History> getAllHistories(){
        return repository.findAll();
    }

    public Optional<History> getHistoryById(Long id){
        if (repository.findById(id)==null){
            throw new IllegalStateException("No that History!");
        }
        return repository.findById(id);
    }
}
