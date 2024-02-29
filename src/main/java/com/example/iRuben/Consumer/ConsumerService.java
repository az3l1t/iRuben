package com.example.iRuben.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ConsumerService {
    private final ConsumerRepository consumerRepository;
    @Autowired
    public ConsumerService(ConsumerRepository consumerRepository) {
        this.consumerRepository = consumerRepository;
    }
    public List<Consumer> getConsumers(){
        return consumerRepository.findAll();
    }
    public void registerNewConsumer(Consumer consumer){
        Optional<Consumer> consumerByEmail = consumerRepository.findConsumerByEmail(consumer.getEmail());
        if(consumerByEmail.isPresent()){
            throw new IllegalStateException("Юзер с таким email уже существует!");
        }
        consumerRepository.save(consumer);
    }
    public void deleteConsumer(Long consumerId){
        boolean exists = consumerRepository.existsById(consumerId);
        if(!exists){
            throw new IllegalStateException("Юзера с таким id не существует!");
        }
        consumerRepository.deleteById(consumerId);
    }
    @Transactional
    public void updateConsumer(Long consumerId, String name, String email){
        Consumer consumer = consumerRepository.findById(consumerId)
                .orElseThrow(()-> new IllegalStateException("" +
                        "Юзер с таким id не найден!"));
        if(name!=null && name.length()>0 && !Objects.equals(consumer.getUsername(),name)){
            consumer.setUsername(name);
        }
        if(email !=null && email.length()>0 && !Objects.equals(consumer.getEmail(),email)){
            Optional<Consumer> consumerOptional = consumerRepository
                    .findConsumerByEmail(email);
            if(consumerOptional.isPresent()){
                throw new IllegalStateException("Почта уже взята!");
            }
            consumer.setEmail(email);
        }
    }

    @Transactional
    public void addExperience(Long consumerId){
        Consumer consumer = consumerRepository.findById(consumerId)
                .orElseThrow(()-> new IllegalStateException("" +
                        "Юзер с таким id не найден!"));
        if(consumer.getExperience()>0 && consumer.getExperience()<39){
            consumer.addExperience();
        }
        else{
            throw new IllegalStateException("Что-то с опытом не так!");
        }
    }
}
