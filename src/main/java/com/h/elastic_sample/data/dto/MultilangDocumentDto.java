package com.h.elastic_sample.data.dto;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Map;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MultilangDocumentDto {

    private String identifier;
    private Map<String, String> body;
}
