package com.example.gitlite.gitRepo;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.gitlite.gitRepo.domain.GitRepo;
import com.example.gitlite.gitRepo.domain.dto.GitRepoRequestDto;
import com.example.gitlite.gitRepo.domain.dto.GitRepoResponseDto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GitRepoServiceUnitTest {

    @Mock
    private GitRepoServiceImpl serviceImpl;

    @InjectMocks
    private GitRepoService service;

    private GitRepo gitRepo;

    @BeforeEach
    public void setup() {
        gitRepo = GitRepo.builder()
                .id(UUID.randomUUID())
                .name("Test Repo")
                .description("Test Description")
                .build();

    }

    @Test
    public void GitRepoService_create_ReturnCreatedGitRepo() {
        // Given
        GitRepoRequestDto requestDto = new GitRepoRequestDto();
        requestDto.setName("Test Repo");
        requestDto.setDescription("Test Description");

        // When
        when(serviceImpl.create(any(GitRepo.class))).thenReturn(gitRepo);
        GitRepoResponseDto responseDto = service.create(requestDto);

        // Then
        assertNotNull(responseDto);
        assertEquals(gitRepo.getId(), responseDto.getId());
        assertEquals(gitRepo.getName(), responseDto.getName());
    }

    @Test
    public void GitRepoService_findAll_ReturnAllGitRepos() {
        GitRepo gitRepo1 = GitRepo.builder()
                .id(UUID.randomUUID())
                .name("Test Repo 1")
                .description("Test Description 1")
                .build();

        when(serviceImpl.findAll()).thenReturn(List.of(gitRepo, gitRepo1));
        Collection<GitRepoResponseDto> responseDtos = service.findAll();

        assertNotNull(responseDtos);
        assertEquals(2, responseDtos.size());
    }

    @Test
    public void GitRepoService_findOne_ReturnGitRepo() {
        // Given
        UUID id = gitRepo.getId();

        // When
        when(serviceImpl.findOne(id)).thenReturn(Optional.of(gitRepo));
        GitRepoResponseDto responseDto = service.findOne(id).orElse(null);

        // Then
        assertNotNull(responseDto);
        assertEquals(gitRepo.getId(), responseDto.getId());
    }

    @Test
    public void GitRepoService_update_ReturnUpdatedGitRepo() {
        // Given
        UUID id = gitRepo.getId();
        GitRepoRequestDto requestDto = new GitRepoRequestDto();
        requestDto.setName("Updated Repo");
        requestDto.setDescription("Updated Description");

        // When
        when(serviceImpl.findOne(id)).thenReturn(Optional.of(gitRepo));
        when(serviceImpl.update(any(GitRepo.class))).thenReturn(gitRepo);
        GitRepoResponseDto responseDto = service.update(id, requestDto);

        // Then
        assertNotNull(responseDto);
        assertEquals(gitRepo.getId(), responseDto.getId());
        assertEquals("Updated Repo", responseDto.getName());
    }

    @Test
    public void GitRepoService_delete_ReturnDeletedGitRepo() {
        // Given
        UUID id = gitRepo.getId();

        // When
        when(serviceImpl.isExist(id)).thenReturn(true);
        service.delete(id);

        // Then
        assertThat(service.findOne(id)).isEmpty();
    }
}
