package com.example.MiroBookStore;

import com.example.MiroBookStore.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class bookRepositoryTest {

    @Autowired
    private bookRepository bRepository;

    @Autowired
    private categoryRepository cRepository;

    @Test
    public void findByTitleShouldReturnBook() {
        List<Book> books = bRepository.findByTitle("The Lord Of The Rings");
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getTitle()).isEqualTo("The Lord Of The Rings");
    }

    @Test
    public void createNewBook() {
        Book book = new Book("Goosebumps", "R.L. Stine", 1978, "1294-29", 22.5, cRepository.findByName("Horror").get(0));
        bRepository.save(book);
        assertThat(book.getId()).isNotNull();
    }

    @Test
    public void deleteNewBook() {
        List<Book> books = bRepository.findByTitle("The Lord Of The Rings");
        Book book = books.get(0);
        bRepository.delete(book);
        List<Book> newBooks = bRepository.findByTitle("The Lord Of The Rings");
        assertThat(newBooks).hasSize(0);


    }
}