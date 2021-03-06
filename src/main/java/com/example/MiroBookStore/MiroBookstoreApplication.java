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
            cRepository.save(new Category("Romance"));
            cRepository.save(new Category("Drama"));
            cRepository.save(new Category("Mystery"));
            cRepository.save(new Category("Thriller"));
            cRepository.save(new Category("Science Fiction"));
            cRepository.save(new Category("Biography"));
            Log.info("----------------------------------------------------");

            Log.info("Example books");
            bRepository.save(new Book("The Lord Of The Rings", " J.R.R. Tolkien", 2002, "1292-23", 223, cRepository.findByName("Fantasy").get(0)));
            bRepository.save(new Book("The Hobbit", " J.R.R. Tolkien", 1937, "1292-23", 21.0, cRepository.findByName("Fantasy").get(0)));
            bRepository.save(new Book("The Shining", " Stephen King", 1977, "1293-23", 21.3, cRepository.findByName("Horror").get(0)));
            bRepository.save(new Book("The Stand", " Stephen King", 1978, "1294-23", 22.5, cRepository.findByName("Horror").get(0)));
            Log.info("----------------------------------------------------");


            };


        };
    }




