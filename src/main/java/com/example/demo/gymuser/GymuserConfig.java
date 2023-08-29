package com.example.demo.gymuser;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class GymuserConfig {

    @Bean
    CommandLineRunner commandLineRunnerGym(GymuserRepository gymuserRepository){
        return args -> {
            Gymuser david = new Gymuser(
                    "david",
                    "david@gmail.com",
                    LocalDate.of(2002, Month.JUNE, 8),
                    10
            );
            Gymuser adam = new Gymuser(
                    "adam",
                    "adam@gmail.com",
                    LocalDate.of(2004, Month.JANUARY, 12),
                    6
            );
            gymuserRepository.saveAll(List.of(david, adam));
        };
    }
}
