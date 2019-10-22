package com.oracle.mcv.webapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.mcv.webapp.model.Book;
import com.oracle.mcv.webapp.service.BookService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);

	@RequestMapping("/books")
	public ResponseEntity<List<Book>> getAllBooks() {
		List<Book> books = null;
		try {
			books = bookService.getAllBooks();
			LOGGER.info("getAllBooks sucess");
			return new ResponseEntity<>(books, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("getAllBooks eception " + e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping("/books/{isbn}")
	public ResponseEntity<Book> getBook(@PathVariable String isbn) {
		Optional<Book> optional = null;
		try {
			optional = bookService.getBook(isbn);
			Book book = optional.get();
			LOGGER.info("getBook sucess");
			return new ResponseEntity<>(book, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("getBook eception " + e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(method = RequestMethod.POST, value = "/books")
	public ResponseEntity<?> addBook(@RequestBody Book book) {
		try {
			bookService.addBook(book);
			LOGGER.info("addBook sucess");
			return new ResponseEntity(HttpStatus.CREATED);
		} catch (Exception e) {
			LOGGER.error("addBook eception " + e.getMessage());
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/books/{isbn}")
	public ResponseEntity<?> updateBook(@RequestBody Book book, @PathVariable String isbn) {

		try {
			bookService.updateBook(book, isbn);
			LOGGER.info("updateBook sucess");
			return new ResponseEntity(HttpStatus.ACCEPTED);
		} catch (Exception e) {
			LOGGER.error("updateBook eception " + e.getMessage());
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(method = RequestMethod.PATCH, value = "/books/{isbn}")
	public ResponseEntity<?> partialUpdateBook(@RequestBody Book book, @PathVariable String isbn) {

		try {
			bookService.updateBook(book, isbn);
			LOGGER.info("partialUpdateBook sucess");
			return new ResponseEntity(HttpStatus.ACCEPTED);
		} catch (Exception e) {
			LOGGER.error("partialUpdateBook eception " + e.getMessage());
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/books/{isbn}")
	public ResponseEntity<?> deleteBook(@PathVariable String isbn) {
		try {
			bookService.deleteBook(isbn);
			LOGGER.info("deleteBook sucess");
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			LOGGER.error("deleteBook eception " + e.getMessage());
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
