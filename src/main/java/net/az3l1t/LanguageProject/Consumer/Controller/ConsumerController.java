package net.az3l1t.LanguageProject.Consumer.Controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import net.az3l1t.LanguageProject.Consumer.JWTService;
import net.az3l1t.LanguageProject.Consumer.Model.Consumer;
import net.az3l1t.LanguageProject.Consumer.Service.ConsumerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/consumer")
public class ConsumerController {
    private ConsumerService service;
    private JWTService jwtService;

    public ConsumerController(ConsumerService service,JWTService jwtService) {
        this.service = service;
        this.jwtService = jwtService;
    }

    @GetMapping("/getAllConsumer")
    public List<Consumer> getAllConsumer(){
        return service.getConsumers();
    }

    @GetMapping("/alphabetPage")
    public String alphabetPage(Model model, @RequestParam("userId") Long userId) {
        int letter = service.getLetterForCurrentUser(userId);
        model.addAttribute("letter", letter);
        return "alphabetPage";
    }

    @GetMapping("/getUserData/{userId}")
    public ResponseEntity<?> getUserData(@PathVariable Long userId) {
        // Получение данных пользователя по его идентификатору userId
        Optional<Consumer> userData = service.getConsumerById(userId);
        if (userData != null) {
            return ResponseEntity.ok(userData);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/check")
    public ResponseEntity<Consumer> checkConsumer(@RequestBody Consumer consumer){
        try {
            Consumer userId = service.checkConsumer(consumer);
            return ResponseEntity.ok(userId);
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerNewConsumer(@RequestBody Consumer consumer) {
        try {
            Consumer registeredConsumer = service.registerNewConsumer(consumer);
            return ResponseEntity.ok(registeredConsumer);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    @DeleteMapping("/delete/{consumerId}")
    public void deleteConsumer(@PathVariable("consumerId") Long consumerId){
        service.deleteConsumer(consumerId);
    }

    @PutMapping("/update/{consumerId}")
    public void updateConsumer(@PathVariable("consumerId") Long consumerId,
                                @RequestParam(required = false) String name,
                                @RequestParam(required = false) String email) throws Throwable {
        service.updateConsumer(consumerId,name,email);
    }

    @PutMapping("/addLetter/{consumerId}")
    public void addExperience(@PathVariable("consumerId") Long consumerId){
        service.addLetter(consumerId);
    }
}
