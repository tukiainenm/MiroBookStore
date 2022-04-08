package com.example.MiroBookStore;

import com.example.MiroBookStore.domain.User;
import com.example.MiroBookStore.domain.userRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class userRepositoryTest {

    @Autowired
    private userRepository uRepository;

    @Test
    public void findByUserNameShouldReturnUser() {
        User user = uRepository.findByUserName("user");
        assertThat(user.getUserName()).isEqualTo("user");

    }

    @Test
    public void createNewUser() {
        User user = new User("user4", "password", "user");
        uRepository.save(user);
        assertThat(user.getUserName()).isEqualTo("user4");
    }
}
