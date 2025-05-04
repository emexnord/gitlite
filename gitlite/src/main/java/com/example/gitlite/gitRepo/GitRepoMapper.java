package com.example.gitlite.gitRepo;

import com.example.gitlite.gitRepo.domain.GitRepo;
import com.example.gitlite.gitRepo.domain.dto.GitRepoRequestDto;
import com.example.gitlite.gitRepo.domain.dto.GitRepoResponseDto;

public class GitRepoMapper {

    public static GitRepoResponseDto toResponseDto(GitRepo gitRepo) {
        return GitRepoResponseDto.builder()
                .id(gitRepo.getId())
                .name(gitRepo.getName())
                .description(gitRepo.getDescription())
                .build();
    }

    public static GitRepo toEntity(GitRepoRequestDto requestDto) {
        return GitRepo.builder()
                .name(requestDto.getName())
                .description(requestDto.getDescription())
                .build();
    }
}