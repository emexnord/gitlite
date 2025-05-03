package com.example.demo.book;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(BookController.class)
@AutoConfigureMockMvc
public class BookControllerTest {

    @Autowired
    MockMvc mockMvc;

    List<Book> books = new ArrayList<>();

    @BeforeEach
    void setUp() {
        books = List.of(
                new Book("The Catcher in the Rye", "J.D. Salinger"),
                new Book("To Kill a Mockingbird", "Harper Lee"),
                new Book("1984", "George Orwell"));
    }

    @Test
    void shouldFindAllBooks() throws Exception {
        mockMvc.perform(get("/api/books"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("The Catcher in the Rye"))
                .andExpect(jsonPath("$[1].title").value("To Kill a Mockingbird"))
                .andExpect(jsonPath("$[2].title").value("1984"));
    }

}
