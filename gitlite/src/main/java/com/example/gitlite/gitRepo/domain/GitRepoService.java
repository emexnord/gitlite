package com.example.gitlite.gitRepo.domain;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface GitRepoService {
    GitRepo create(GitRepo gitRepo);

    Collection<GitRepo> findAll();

    Optional<GitRepo> findOne(UUID id);

    GitRepo update(GitRepo gitRepo);

    void delete(UUID id);

    Boolean isExist(UUID id);
}
