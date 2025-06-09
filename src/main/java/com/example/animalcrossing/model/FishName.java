package com.example.animalcrossing.model;

import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "FISH_NAMES", schema = "PUBLIC")
public class FishName {

    @Column("FISH_ID")
    public int fishId;

    @Column("LOCALE")
    public String locale;

    @JsonValue
    @Column("NAME")
    public String name;
}
