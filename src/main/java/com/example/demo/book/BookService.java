package com.example.demo.book;

import org.springframework.stereotype.Service;

import com.example.demo.repo.BookRepository;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + id, null));
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }
}
