package com.example.MiroBookStore.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface bookRepository extends CrudRepository<Book, Long> {

    List<Book> findByTitle(String title);


}
