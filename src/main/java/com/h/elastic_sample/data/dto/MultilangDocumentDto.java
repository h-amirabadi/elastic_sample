package com.h.elastic_sample.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MultilangDocumentDto {

    private String identifier;
    private Map<String, String> body;
}
