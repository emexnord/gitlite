package com.example.demo.post;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(PostController.class)
@AutoConfigureMockMvc
public class PostControllerTest {

    @Autowired
    MockMvc mockMvc;

    List<Post> posts = new ArrayList<>();

    @BeforeEach
    void setUp() {
        posts = List.of(
                new Post(1L, "The Catcher in the Rye", "J.D. Salinger"),
                new Post(2L, "To Kill a Mockingbird", "Harper Lee"),
                new Post(3L, "1984", "George Orwell"));
    }

    @AfterEach
    void tearDown() {
        posts.clear();
    }

    @Test
    void shouldFindAllPosts() throws Exception {
        this.mockMvc.perform(get("/api/posts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("The Catcher in the Rye"))
                .andExpect(jsonPath("$[1].title").value("To Kill a Mockingbird"))
                .andExpect(jsonPath("$[2].title").value("1984"));
    }

}
