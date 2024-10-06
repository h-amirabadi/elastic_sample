package com.h.elastic_sample.service;

import com.h.elastic_sample.data.entity.MultilangDocument;
import com.h.elastic_sample.data.repo.MultilangDocumentRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MultilangDocumentService {

    private final MultilangDocumentRepo multilangDocumentRepo;

    public MultilangDocumentService(MultilangDocumentRepo multilangDocumentRepo) {
        this.multilangDocumentRepo = multilangDocumentRepo;
    }


    public MultilangDocument save(MultilangDocument entity) {
        return multilangDocumentRepo.save(entity);
    }

    public Optional<MultilangDocument> findById(String id) {
        return multilangDocumentRepo.findById(id);
    }

    public Iterable<MultilangDocument> findAll() {
        return multilangDocumentRepo.findAll();
    }

    public void deleteById(String id) {
        multilangDocumentRepo.deleteById(id);
    }
}
