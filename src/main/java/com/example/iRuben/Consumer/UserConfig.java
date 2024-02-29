package com.example.iRuben.Consumer;

import com.example.iRuben.Consumer.Consumer;
import com.example.iRuben.Consumer.ConsumerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner runner(ConsumerRepository repository){
        return args -> {
            Consumer admin = new Consumer(
                    1L,
                    "admin",
                    "eternity_cr9p@mail.ru",
                    "admin",
                    39
            );
            repository.save(admin);
        };
    }
}
