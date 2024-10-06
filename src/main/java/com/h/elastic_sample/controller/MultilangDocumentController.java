package com.h.elastic_sample.controller;

import com.h.elastic_sample.data.dto.MultilangDocumentDto;
import com.h.elastic_sample.data.model.MultilangDocument;
import com.h.elastic_sample.service.MultilangDocumentService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    public MultilangDocumentDto findById(@PathVariable String id) {
        MultilangDocumentDto multilangDocumentDto = null;

        Optional<MultilangDocument> optionalDocument = multilangDocumentService.findById(id);
        if(optionalDocument.isPresent()){
            multilangDocumentDto = new MultilangDocumentDto();
            MultilangDocument multilangDocument = optionalDocument.get();

            multilangDocumentDto.setIdentifier(multilangDocument.getIdentifier());
            multilangDocumentDto.setBody(multilangDocument.getBody());
        }

        return multilangDocumentDto;
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
