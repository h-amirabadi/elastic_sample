package com.h.elastic_sample.data.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Map;


@Document(indexName = "document_object")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MultilangDocument {

    @Id
    private String identifier;
    private Map<String, String> body;
}
