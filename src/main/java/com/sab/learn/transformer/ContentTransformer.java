package com.sab.learn.transformer;

import com.sab.learn.entity.Content;
import com.sab.learn.model.ContentDto;
import com.sab.learn.model.ContentType;
import com.sab.learn.model.Status;

import java.time.LocalDateTime;

public class ContentTransformer {

    public static Content updateExistingRecords(Content content, ContentDto contentDto) {
        return new Content(
                content.id(),
                contentDto.title,
                contentDto.description,
                ContentType.valueOf(contentDto.contentType),
                Status.valueOf(contentDto.status),
                content.createdDate(),
                LocalDateTime.now(),
                contentDto.url
        );
    }

    public static Content createNewEntity(ContentDto source) {
        return new Content(null, source.title,
                source.description,
                ContentType.valueOf(source.contentType),
                Status.valueOf(source.status),
                LocalDateTime.now(),
                null,
                source.url);
    }
}
