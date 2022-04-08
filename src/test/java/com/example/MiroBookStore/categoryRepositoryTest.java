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
public class categoryRepositoryTest {

    @Autowired
    private categoryRepository cRepository;

    @Test
    public void findByNameShouldReturnCategory() {
        List<Category> categories = cRepository.findByName("Horror");
        assertThat(categories).hasSize(1);
        assertThat(categories.get(0).getName()).isEqualTo("Horror");
    }

    @Test
    public void createNewCategory() {
        Category category = new Category("Gothic");
        cRepository.save(category);
        assertThat(category.getName()).isNotNull();
    }

    @Test
    public void deleteNewCategory() {
        List<Category> categories = cRepository.findByName("Horror");
        Category category = categories.get(0);
        cRepository.delete(category);
        List<Category> newCategories = cRepository.findByName("Horror");
        assertThat(newCategories).hasSize(0);


    }
}

