package com.example.gitlite.gitRepo;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.Locale.Category;

import org.springframework.stereotype.Component;

import com.example.gitlite.core.exceptions.BadRequestException;
import com.example.gitlite.core.exceptions.NotFoundException;
import com.example.gitlite.gitRepo.domain.GitRepo;
import com.example.gitlite.gitRepo.domain.dto.GitRepoRequestDto;
import com.example.gitlite.gitRepo.domain.dto.GitRepoResponseDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class GitRepoService {

    private final GitRepoServiceImpl serviceImpl;

    public GitRepoResponseDto create(GitRepoRequestDto requestDto) throws BadRequestException {
        GitRepo gitRepo = GitRepoMapper.toEntity(requestDto);
        return GitRepoMapper.toResponseDto(serviceImpl.create(gitRepo));
    }

    public Collection<GitRepoResponseDto> findAll() {
        Collection<GitRepo> gitRepos = serviceImpl.findAll();
        return gitRepos.stream().map(GitRepoMapper::toResponseDto).toList();
    }

    public Optional<GitRepoResponseDto> findOne(UUID id) {
        Optional<GitRepo> gitRepo = serviceImpl.findOne(id);
        return gitRepo.map(GitRepoMapper::toResponseDto);
    }

    public GitRepoResponseDto update(UUID id, GitRepoRequestDto requestDto) throws BadRequestException {
        Optional<GitRepo> existingGitRepo = Optional.ofNullable(
                serviceImpl.findOne(id).orElseThrow(
                        () -> new NotFoundException("GitRepo not found")));

        if (existingGitRepo.isPresent()) {
            GitRepo gitRepo = existingGitRepo.get();
            gitRepo.setName(requestDto.getName());
            gitRepo.setDescription(requestDto.getDescription());
            return GitRepoMapper.toResponseDto(serviceImpl.update(gitRepo));
        }
        throw new BadRequestException("GitRepo not found");
    }

    public void delete(UUID id) {
        Boolean exists = serviceImpl.isExist(id);
        if (!exists) {
            throw new NotFoundException("GitRepo not found");
        }
        serviceImpl.delete(id);
    }

}
