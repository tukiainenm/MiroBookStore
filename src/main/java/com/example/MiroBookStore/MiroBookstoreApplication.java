package com.example.MiroBookStore;

import com.example.MiroBookStore.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class MiroBookstoreApplication {
    private static final Logger Log = LoggerFactory.getLogger(MiroBookstoreApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MiroBookstoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(bookRepository bRepository, categoryRepository cRepository, userRepository uRepository) {
        return (args) -> {
            Log.info("Categories");
            cRepository.save(new Category("Fantasy"));
            cRepository.save(new Category("Horror"));
            cRepository.save(new Category("Comedy"));
            Log.info("----------------------------------------------------");

            Log.info("Example books");
            bRepository.save(new Book("The Lord Of The Rings", " J.R.R. Tolkien", 2002, "1292-23", 223, cRepository.findByName("Fantasy").get(0)));
            bRepository.save(new Book("The Hobbit", " J.R.R. Tolkien", 1937, "1292-23", 21.0, cRepository.findByName("Fantasy").get(0)));
            bRepository.save(new Book("The Shining", " Stephen King", 1977, "1293-23", 21.3, cRepository.findByName("Horror").get(0)));
            bRepository.save(new Book("The Stand", " Stephen King", 1978, "1294-23", 22.5, cRepository.findByName("Horror").get(0)));
            Log.info("----------------------------------------------------");

            User user1 = new User("admin", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "admin");
            uRepository.save(user1);
            };


        };
    }




