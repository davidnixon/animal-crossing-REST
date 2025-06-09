package com.example.animalcrossing.model;

import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "FOSSIL_NAMES", schema = "PUBLIC")
public class FossilName {

    @Id
    private Integer id;

    @Column("FOSSIL_ID")
    private Integer fossilId;

    @Column("LOCALE")
    private String locale;

    @Column("NAME")
    @JsonValue
    private String name;
}

