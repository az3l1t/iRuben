package net.az3l1t.LanguageProject.History.Controller;

import net.az3l1t.LanguageProject.History.Model.History;
import net.az3l1t.LanguageProject.History.Service.HistoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/history")
public class HistoryController {
    private HistoryService service;

    public HistoryController(HistoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<History> getAllHistories(){
        return service.getAllHistories();
    }

    @GetMapping("/getById/{id}")
    public Optional<History> getHistory(@PathVariable("id") Long id){
        return service.getHistoryById(id);
    }
}
