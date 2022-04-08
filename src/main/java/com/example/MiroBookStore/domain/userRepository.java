package com.example.MiroBookStore.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface userRepository extends CrudRepository<User, Long> {

    User findByUserName(String userName);


}
