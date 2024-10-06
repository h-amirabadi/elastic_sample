package com.h.elastic_sample.data.repo;


import com.h.elastic_sample.data.model.MultilangDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface MultilangDocumentRepo extends ElasticsearchRepository<MultilangDocument, String> {
}
