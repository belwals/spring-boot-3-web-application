package com.sab.learn.service;

import com.sab.learn.entity.Content;
import com.sab.learn.exception.BadRequestException;
import com.sab.learn.model.ContentDto;
import com.sab.learn.repository.ContentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.sab.learn.transformer.ContentTransformer.createNewEntity;
import static com.sab.learn.transformer.ContentTransformer.updateExistingRecords;

@Service
public class ContentService {
    private final ContentRepository repository;

    public ContentService(ContentRepository repository) {
        this.repository = repository;
    }

    public void createContent(ContentDto content) {
        Content transform = createNewEntity(content);
        repository.save(transform);
    }

    public Content updateContent(Integer id, ContentDto contentDto) throws Exception {
        Optional<Content> existing = repository.findById(id);
        if (existing.isEmpty()) {
            throw new BadRequestException("content id not found");
        }
        Content updatedContent = updateExistingRecords(existing.get(), contentDto);
        return repository.save(updatedContent);
    }

    public List<Content> getAllContent() {
        return repository.findAll();
    }

    public Optional<Content> getById(Integer id) {
        return repository.findById(id);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
