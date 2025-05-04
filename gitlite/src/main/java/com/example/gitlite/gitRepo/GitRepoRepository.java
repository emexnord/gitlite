package com.example.gitlite.gitRepo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gitlite.gitRepo.domain.GitRepo;

public interface GitRepoRepository extends JpaRepository<GitRepo, UUID> {
    // Optional<GitRepo> findByName(String name);
    // boolean existsByName(String name);
    // List<GitRepo> findAllByNameContainingIgnoreCase(String name);

}