package com.sab.learn.controller;

import com.sab.learn.entity.Content;
import com.sab.learn.exception.BadRequestException;
import com.sab.learn.exception.ErrorObject;
import com.sab.learn.model.ContentDto;
import com.sab.learn.service.ContentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/content")
@CrossOrigin
public class ContentController {

    private final ContentService contentService;

    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @GetMapping("")
    public List<Content> getContent() {
        return contentService.getAllContent();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveContent(@Valid @RequestBody ContentDto c) {
        contentService.createContent(c);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateContent(@PathVariable Integer id, @Valid @RequestBody ContentDto c) {
        try {
            Content content = contentService.updateContent(id, c);
            return ResponseEntity.status(HttpStatus.OK).body(content);
        } catch (Exception e) {
            return buildErrorResponse(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getContent(@PathVariable Integer id) {

        Optional<Content> content = contentService.getById(id);
        if (content.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(content);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorObject("id is not present"));
        }
    }

    @DeleteMapping("/{id}")
    public void deleteContent(@PathVariable Integer id) {
        contentService.deleteById(id);
    }

    private ResponseEntity<Object> buildErrorResponse(Exception e) {
        ErrorObject eo = new ErrorObject(e.getMessage());
        if (e instanceof BadRequestException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(eo);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(eo);
    }
}

