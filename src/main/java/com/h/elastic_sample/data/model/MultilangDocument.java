package com.h.elastic_sample.data.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Map;


@Document(indexName = "document_object")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MultilangDocument {

    @Id
    private String identifier;
    private Map<String, String> body;
}
