package com.example.animalcrossing.model;

import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "DECOR_NAMES", schema = "PUBLIC")
public class DecorName {

    @Column("DECOR_ID")
    public int wallMountedId;

    @Column("LOCALE")
    public String locale;

    @JsonValue
    @Column("NAME")
    public String name;
}