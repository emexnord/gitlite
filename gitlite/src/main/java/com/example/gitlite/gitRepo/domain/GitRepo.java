package com.example.gitlite.gitRepo.domain;

import java.util.UUID;

import com.example.gitlite.core.model.AbstractAuditableModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
@Table(name = "git_repo")
public class GitRepo extends AbstractAuditableModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "gitrepo_uuid", nullable = false, unique = true)
    UUID id;
    String name;
    String description;

}
