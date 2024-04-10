package com.sab.learn.entity;

import com.fasterxml.jackson.databind.annotation.EnumNaming;
import com.sab.learn.model.ContentType;
import com.sab.learn.model.Status;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table(value = "content")
public record Content(
        @Id
        Integer id,
        @NotBlank
        String title,
        @NotBlank
        String description,
        ContentType contentType,
        Status status,
        LocalDateTime createdDate,
        LocalDateTime modifiedDate,
        String url
) {
}
