package com.h.elastic_sample.controller;

import com.h.elastic_sample.data.entity.MultilangDocument;
import com.h.elastic_sample.service.MultilangDocumentService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/document")
public class MultilangDocumentController {

    private MultilangDocumentService multilangDocumentService;

    public MultilangDocumentController(MultilangDocumentService multilangDocumentService) {
        this.multilangDocumentService = multilangDocumentService;
    }

    @PostMapping
    public MultilangDocument save(@RequestBody MultilangDocument entity) {
        return multilangDocumentService.save(entity);
    }

    @GetMapping("/{id}")
    public Optional<MultilangDocument> findById(@PathVariable String id) {
        return multilangDocumentService.findById(id);
    }

    @GetMapping
    public Iterable<MultilangDocument> findAll() {
        return multilangDocumentService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        multilangDocumentService.deleteById(id);
    }
}
