package com.example.animalcrossing.model;

import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "SEA_CREATURE_NAMES", schema = "PUBLIC")
public class SeaCreatureName {

    @Column("SEA_CREATURE_ID")
    public int seaCreatureId;

    @Column("LOCALE")
    public String locale;

    @JsonValue
    @Column("NAME")
    public String name;
}