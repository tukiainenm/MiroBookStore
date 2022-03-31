package com.example.MiroBookStore;

import com.example.MiroBookStore.domain.Book;
import com.example.MiroBookStore.domain.bookRepository;
import org.apache.commons.logging.Log;
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
    public CommandLineRunner demo(bookRepository repository) {
        return (args) -> {
            Log.info("Example books");
            repository.save(new Book(2L, "Epic adventure", "John Johnson", 2011, "2932-23", 20));
            repository.save(new Book(3L, "Epic adventure 2", "John Johnson", 2013, "2932-24", 22));

            Log.info("Fetch all books");
            for (Book book : repository.findAll()) ; {
                Log.info(String.valueOf(new Book()));
            }
        };
    }

}
