package com.h.elastic_sample.controller;

import com.h.elastic_sample.data.dto.MultilangDocumentDto;
import com.h.elastic_sample.data.model.MultilangDocument;
import com.h.elastic_sample.service.MultilangDocumentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/document")
public class MultilangDocumentController {

    private final MultilangDocumentService multilangDocumentService;

    public MultilangDocumentController(MultilangDocumentService multilangDocumentService) {
        this.multilangDocumentService = multilangDocumentService;
    }

    @PostMapping
    public MultilangDocument save(@RequestBody MultilangDocumentDto multilangDocumentDto) {
        MultilangDocument multilangDocument =  new MultilangDocument();
        multilangDocument.setIdentifier(multilangDocumentDto.getIdentifier());
        multilangDocument.setBody(multilangDocumentDto.getBody());

        return multilangDocumentService.save(multilangDocument);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MultilangDocumentDto> findById(@PathVariable String id) {
        return multilangDocumentService.findById(id)
                .map(document -> new MultilangDocumentDto(document.getIdentifier(), document.getBody()))
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<Iterable<MultilangDocumentDto>> findAll() {
        Iterable<MultilangDocumentDto> documents = StreamSupport.stream(multilangDocumentService.findAll().spliterator(), false)
                .map(document -> new MultilangDocumentDto(document.getIdentifier(), document.getBody()))
                .collect(Collectors.toList());

        return documents.iterator().hasNext() ? ResponseEntity.ok(documents) : ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        multilangDocumentService.deleteById(id);
    }
}
