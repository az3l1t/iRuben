package net.az3l1t.LanguageProject.Consumer.Service;

import net.az3l1t.LanguageProject.Consumer.JWTService;
import net.az3l1t.LanguageProject.Consumer.Model.Consumer;
import net.az3l1t.LanguageProject.Consumer.Repository.ConsumerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ConsumerService {
    private ConsumerRepository repository;
    private JWTService JWTService;


    public ConsumerService(ConsumerRepository repository, JWTService JWTService) {
        this.repository = repository;
        this.JWTService = JWTService;
    }
    public List<Consumer> getConsumers(){
        return repository.findAll();
    }

    public Optional<Consumer> getConsumerById(Long id){
        return repository.findById(id);
    }

    public int getLetterForCurrentUser(Long userId) {
        Consumer consumer = repository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        return consumer.getLetter();
    }


    public Consumer checkConsumer(Consumer consumer){
        Optional<Consumer> consumerByEmail = repository.findConsumerByEmail(consumer.getEmail());
        if (consumerByEmail.isPresent()){
            return consumer;
        }
        throw new IllegalStateException("That consumer is not exists");
    }

    @Transactional
    public void addLetter(Long consumerId){
        Consumer consumer = repository.findById(consumerId)
                .orElseThrow(()-> new IllegalStateException("" +
                        "No user with that id!"));
        if(consumer.getLetter()>=0 && consumer.getLetter()<39){
            consumer.addLetter();
        }
        else{
            throw new IllegalStateException("Experience?!");
        }
    }
    public Consumer registerNewConsumer(Consumer consumer){
        Optional<Consumer> consumerByEmail = repository.findConsumerByEmail(consumer.getEmail());
        if (consumerByEmail.isPresent()){
            throw new IllegalStateException("Consumer with that email exists");
        }
        repository.save(consumer);
        Consumer savedConsumer = repository.findById(consumer.getId()).orElseThrow();

        String jwtToken = JWTService.generateToken(savedConsumer.getId());
        savedConsumer.setJwtToken(jwtToken);

        repository.save(savedConsumer);
        return savedConsumer;
    }
    public void deleteConsumer(Long consumerId){
        boolean exists = repository.existsById(consumerId);
        if(!exists){
            throw new IllegalStateException("No consumer with that id");
        }
        repository.deleteById(consumerId);
    }
    @Transactional
    public void updateConsumer(Long consumerId, String name, String email) throws Throwable {
        Consumer consumer = (Consumer) repository.findById(consumerId)
                .orElseThrow(()-> new IllegalStateException("" +
                        "Юзер с таким id не найден!"));
        if(name!=null && name.length()>0 && !Objects.equals(consumer.getNickname(),name)){
            consumer.setNickname(name);
        }
        if(email !=null && email.length()>0 && !Objects.equals(consumer.getEmail(),email)){
            Optional<Consumer> consumerOptional = repository
                    .findConsumerByEmail(email);
            if(consumerOptional.isPresent()){
                throw new IllegalStateException("That email exists");
            }
            consumer.setEmail(email);
        }
    }
}
