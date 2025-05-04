package com.example.gitlite.core.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Data
public class AbstractAuditableModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    Date updatedAt;
}
