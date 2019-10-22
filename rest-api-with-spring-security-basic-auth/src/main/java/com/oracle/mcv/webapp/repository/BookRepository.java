package com.oracle.mcv.webapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.oracle.mcv.webapp.model.Book;

public interface BookRepository extends CrudRepository<Book, String>{

}
