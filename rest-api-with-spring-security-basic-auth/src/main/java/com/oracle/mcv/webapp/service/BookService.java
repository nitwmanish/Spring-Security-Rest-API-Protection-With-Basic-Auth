package com.oracle.mcv.webapp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.mcv.webapp.controller.BookController;
import com.oracle.mcv.webapp.model.Book;
import com.oracle.mcv.webapp.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BookService.class);
	

	@PostConstruct
	private void init() {
		List<Book> books = Arrays.asList(new Book("978-0321356680", "Effective Java", "Addison Wesley"),
				new Book("978-1617292545", "Spring Boot in Action", "Manning Publications"),
				new Book("978-1491900864", "Java 8 Pocket Guide", "O''Reilly"), new Book("978-0321349606",
						"Java Concurrency in Practice", "Java Concurrency in Practice','Addison Wesley"));

		for (Book book : books) {
			bookRepository.save(book);
		}
		LOGGER.info("init sucess");
	}

	public List<Book> getAllBooks() {
		List<Book> books = new ArrayList<>();
		bookRepository.findAll().forEach(books::add);
		LOGGER.info("getAllBooks sucess");
		return books;
	}

	public Optional<Book> getBook(String isbn) {
		LOGGER.info("getBook sucess");
		return bookRepository.findById(isbn);
	}

	public void addBook(Book book) {
		LOGGER.info("addBook sucess");
		bookRepository.save(book);
	}

	public void updateBook(Book book, String isbn) {
		LOGGER.info("updateBook sucess");
		bookRepository.save(book);
	}

	public void deleteBook(String isbn) {
		LOGGER.info("deleteBook sucess");
		bookRepository.deleteById(isbn);
	}

}
