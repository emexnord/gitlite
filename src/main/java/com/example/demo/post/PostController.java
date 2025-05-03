package com.example.demo.post;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @GetMapping
    public Post findAll() {
        return new Post(1L, "Sample Title", "Sample Content");
    }

}
