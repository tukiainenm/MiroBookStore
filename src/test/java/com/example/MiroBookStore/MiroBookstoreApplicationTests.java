package com.example.MiroBookStore;

import com.example.MiroBookStore.web.BookController;
import com.example.MiroBookStore.web.userController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class MiroBookstoreApplicationTests {

	@Autowired
	private BookController bookController;

	@Test
	void contextLoads() throws Exception {
		assertThat(bookController).isNotNull();
	}

	@Autowired
	private userController userController;

	@Test
	void contextLoads1() throws Exception {
		assertThat(userController).isNotNull();
	}

}
