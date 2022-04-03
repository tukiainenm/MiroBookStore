package com.example.MiroBookStore.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface categoryRepository extends CrudRepository<Category, Long> {

    List<Category> findByName(String name);



}
