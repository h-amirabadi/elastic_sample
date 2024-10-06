package com.h.elastic_sample.data.repo;


import com.h.elastic_sample.data.entity.MultilangDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface MultilangDocumentRepo extends ElasticsearchRepository<MultilangDocument, String> {
}
