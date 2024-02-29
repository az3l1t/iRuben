package com.example.iRuben.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/consumer")
public class ConsumerController {
    private final ConsumerService consumerService;
    @Autowired
    public ConsumerController(ConsumerService consumerService) {
        this.consumerService = consumerService;
    }
    @GetMapping
    public List<Consumer> getConsumers(){
        return consumerService.getConsumers();
    }
    @PostMapping
    public void registerNewConsumer(@RequestBody Consumer consumer){
        consumerService.registerNewConsumer(consumer);
    }
    @DeleteMapping(path = "{consumerId}")
    public void deleteConsumer(@PathVariable("consumerId") Long consumerId){
        consumerService.deleteConsumer(consumerId);
    }
    @PutMapping(path = "{consumerId}")
    public void updateStudent(
            @PathVariable("consumerId") Long consumerId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email)
            {
                consumerService.updateConsumer(consumerId,name,email);
    }

    @PutMapping(path="{consumerId}/add")
    public void addExperience(@PathVariable("consumerId") Long consumerId){
        consumerService.addExperience(consumerId);
    }
}
