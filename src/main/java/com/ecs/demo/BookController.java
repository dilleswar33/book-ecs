package com.ecs.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class BookController {
	
	private static final Book[] books= {
			new Book(1,"Nemesis","Isaac Asimov"),
			new Book(2,"Great Expectations","Charles Dickens"),
			new Book(3,"The Chronicles of Narnia","C.S. Lewis"),
			new Book(4,"The Answers To Big Questions","Stephen Hawking"),
			new Book(5,"Beyond Time","Albert Einstein")
	};
	
	@GetMapping("/books")
	public Book[] books() {
		return books;
	}
	
	@GetMapping("/books/{id}")
	public Book book(@PathVariable int id) {
		for(Book book : books) {
			if(book.getId()==id) {
				return book;
			}
		}
		throw new ResponseStatusException(
				HttpStatus.NOT_FOUND,"Entity Not Found");
	}

}
