package com.h.elastic_sample.data.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

import java.util.Map;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "document_object")
@Mapping(mappingPath = "mappings/MultilangDocumentTemplate.json")
public class MultilangDocument {

    @Id
    private String identifier;

    @Field(type = FieldType.Object, dynamic = Dynamic.TRUE)
    private Map<String, String> body;
}
