package com.example.animalcrossing.model;

import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "ARTWORK_NAMES", schema = "PUBLIC")
public class ArtworkName {
    @Id
    private Integer id;
    private String locale;
    @JsonValue
    private String name;
    private Integer artwork_id;
}
