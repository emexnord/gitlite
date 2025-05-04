package com.example.gitlite.gitRepo;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.gitlite.gitRepo.domain.GitRepo;
import com.example.gitlite.gitRepo.domain.GitRepoService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class GitRepoServiceImpl implements GitRepoService {

    private final GitRepoRepository repo;

    @Override
    public GitRepo create(GitRepo gitRepo) {
        return repo.save(gitRepo);
    }

    @Override
    public Collection<GitRepo> findAll() {
        return List.copyOf(repo.findAll());
    }

    @Override
    public Optional<GitRepo> findOne(UUID id) {
        return Optional.ofNullable(repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("GitRepo not found with id: " + id)));
    }

    @Override
    public GitRepo update(GitRepo gitRepo) {
        return repo.save(gitRepo);
    }

    @Override
    public void delete(UUID id) {
        repo.deleteById(id);
    }

    @Override
    public Boolean isExist(UUID id) {
        return repo.existsById(id);
    }

}
