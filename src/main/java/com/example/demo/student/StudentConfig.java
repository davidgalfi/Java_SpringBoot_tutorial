package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student david = new Student(
                    "David",
                    "david@gmail.com",
                    LocalDate.of(2002, Month.JUNE, 8)
            );
            Student adam = new Student(
                    "Adam",
                    "adam@gmail.com",
                    LocalDate.of(2005, Month.JANUARY, 10)
            );
            repository.saveAll(List.of(david, adam));
        };
    }
}
