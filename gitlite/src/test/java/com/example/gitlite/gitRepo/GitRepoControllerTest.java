package com.example.gitlite.gitRepo;

import com.example.gitlite.gitRepo.domain.dto.GitRepoRequestDto;
import com.example.gitlite.gitRepo.domain.GitRepo;
import com.example.gitlite.gitRepo.domain.GitRepoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.mockito.BDDMockito.*;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GitRepoController.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GitRepoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GitRepoService gitRepoService;

    @Autowired
    private ObjectMapper objectMapper;

    GitRepo gitRepo;

    @BeforeEach
    public void setup() {
        gitRepo = GitRepo.builder()
                .name("GitLite")
                .description("GitLite is a lightweight version of Git")
                .build();
    }

    // Post controller
    @Test
    @Order(1)
    public void createGitRepoTest() throws Exception {
        // Given
        given(gitRepoService.create(any(GitRepo.class))).willReturn(gitRepo);

        // When
        ResultActions response = mockMvc.perform(post("/repos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(gitRepo)));

        // Then
        response.andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("GitLite"))
                .andExpect(jsonPath("$.description").value("GitLite is a lightweight version of Git"));
    }

}