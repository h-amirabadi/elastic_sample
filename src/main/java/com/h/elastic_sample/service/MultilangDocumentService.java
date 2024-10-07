package com.h.elastic_sample.service;

import com.h.elastic_sample.data.dto.MultilangDocumentDto;
import com.h.elastic_sample.data.model.MultilangDocument;
import com.h.elastic_sample.data.repo.MultilangDocumentRepo;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MultilangDocumentService {

    private final MultilangDocumentRepo multilangDocumentRepo;
    private final ElasticsearchTemplate elasticsearchTemplate;

    public MultilangDocumentService(MultilangDocumentRepo multilangDocumentRepo, ElasticsearchTemplate elasticsearchTemplate) {
        this.multilangDocumentRepo = multilangDocumentRepo;
        this.elasticsearchTemplate = elasticsearchTemplate;
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

    public List<MultilangDocumentDto> searchByTextAndLang(String text, String lang) {
        String field = "body." + lang;

        Criteria criteria = Criteria.where(field).matches(text);
        Query query = new CriteriaQuery(criteria);

        SearchHits<MultilangDocument> searchHits = elasticsearchTemplate.search(query, MultilangDocument.class);

        return searchHits.stream()
                .map(hit -> {
                    MultilangDocument doc = hit.getContent();
                    return new MultilangDocumentDto(doc.getIdentifier(), doc.getBody());
                })
                .collect(Collectors.toList());
    }

    public void deleteById(String id) {
        multilangDocumentRepo.deleteById(id);
    }
}
