package com.h.elastic_sample.conf;

import com.h.elastic_sample.data.model.MultilangDocument;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.data.elasticsearch.core.document.Document;

import java.util.List;
import java.util.Map;

@Configuration
public class ElasticsearchConfig {
    private final ElasticsearchOperations elasticsearchOperations;

    public ElasticsearchConfig(ElasticsearchOperations elasticsearchOperations) {
        this.elasticsearchOperations = elasticsearchOperations;
    }


    /**
     * Another method to implement the dynamic mapping in our index was to use the following method,
     * which was disabled due to the use of @Mapping annotation and json file mapping.
     */
//    @PostConstruct
    public void createIndexWithMapping() {
        IndexOperations indexOperations = elasticsearchOperations.indexOps(MultilangDocument.class);

        if (!indexOperations.exists()) {
            Map<String, Object> mapping = Map.of(
                    "dynamic_templates", List.of(
                            Map.of(
                                    "body_fields", Map.of(
                                            "path_match", "body.*",
                                            "mapping", Map.of(
                                                    "type", "text",
                                                    "analyzer", "standard"
                                            )
                                    )
                            )
                    ),
                    "properties", Map.of(
                            "identifier", Map.of("type", "text"),
                            "body", Map.of(
                                    "type", "object",
                                    "dynamic", "true"
                            )
                    )
            );
            indexOperations.create();
            indexOperations.putMapping((Document) mapping);
        }
    }
}
