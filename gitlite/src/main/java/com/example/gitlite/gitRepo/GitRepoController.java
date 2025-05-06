package com.example.gitlite.gitRepo;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.gitlite.gitRepo.domain.dto.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/repos")
public class GitRepoController {
    private final GitRepoService gitRepoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<GitRepoResponseDto> create(@RequestBody GitRepoRequestDto requestDto) {
        GitRepoResponseDto gitRepoResponseDto = gitRepoService.create(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(gitRepoResponseDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    private ResponseEntity<Collection<GitRepoResponseDto>> findAll() {
        Collection<GitRepoResponseDto> gitRepos = gitRepoService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(gitRepos);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    private ResponseEntity<Optional<GitRepoResponseDto>> findOne(@PathVariable("id") UUID id) {
        Optional<GitRepoResponseDto> gitRepo = gitRepoService.findOne(id);
        return ResponseEntity.status(HttpStatus.OK).body(gitRepo);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    private ResponseEntity<GitRepoResponseDto> update(@RequestBody GitRepoRequestDto req, @PathVariable("id") UUID id) {
        GitRepoResponseDto gitRepoDto = gitRepoService.update(id, req);
        return ResponseEntity.status(HttpStatus.OK).body(gitRepoDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void delete(@PathVariable("id") UUID id) {
        gitRepoService.delete(id);
    }

}