package com.example.gitlite.gitRepo;

import com.example.gitlite.gitRepo.domain.GitRepo;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

// import com.example.gitlite.gitRepo.domain.GitRepo;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class GitRepoRepositoryUnitTest {

    @Autowired
    private GitRepoRepository gitRepoRepository;

    @Test
    @DisplayName("Test 1:Create repo test")
    @Order(1)
    @Rollback(value = true)
    public void GitRepoRepository_CreateRepo_ReturnCreatedRepo() {

        GitRepo gitRepo = GitRepo.builder()
                .name("GitLite")
                .description("GitLite is a lightweight version of Git")
                .build();

        System.out.println("GitRepo: " + gitRepo);

        GitRepo savedGitRepo = gitRepoRepository.save(gitRepo);
        Assertions.assertThat(savedGitRepo.getId() != null);
    }

    @Test
    @DisplayName("Test 2:Get all repos test")
    @Order(2)
    @Rollback(value = true)
    public void GitRepoRepository_GetAll_ReturnAllRepos() {
        // Given
        GitRepo gitRepo1 = GitRepo.builder()
                .name("GitLite")
                .description("GitLite is a lightweight version of Git")
                .build();

        GitRepo gitRepo2 = GitRepo.builder()
                .name("GitLite2")
                .description("GitLite2 is a lightweight version of Git")
                .build();

        gitRepoRepository.save(gitRepo1);
        gitRepoRepository.save(gitRepo2);

        // When
        List<GitRepo> gitRepos = gitRepoRepository.findAll();
        // Then
        Assertions.assertThat(gitRepos.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("Test 3:Get repo by id test")
    @Order(3)
    @Rollback(value = true)
    public void GitRepoRepository_GetById_ReturnRepo() {
        // Given
        GitRepo gitRepo = GitRepo.builder()
                .name("GitLite")
                .description("GitLite is a lightweight version of Git")
                .build();

        gitRepoRepository.save(gitRepo);

        // When
        GitRepo foundGitRepo = gitRepoRepository.findById(gitRepo.getId()).orElse(null);

        // Then
        Assertions.assertThat(foundGitRepo).isNotNull();
        Assertions.assertThat(foundGitRepo.getName()).isEqualTo(gitRepo.getName());
    }

}
