package com.example.demo.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookController {

  @Autowired
  private final BookService bookService;

  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @PostMapping
  public Book createBook(@RequestBody Book book) {
    System.err.println("createBook: " + book);
    return this.bookService.createBook(book);
  }

  @GetMapping
  public Book findAll() {
    System.err.println("findAll");
    return this.bookService.getBookById(12L);
  }

}
