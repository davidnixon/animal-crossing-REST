package com.example.animalcrossing.model;

import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "VILLAGER_NAMES", schema = "PUBLIC")
public class VillagerName {

    @Column("VILLAGER_ID")
    public int villagerId;

    @Column("LOCALE")
    public String locale;

    @JsonValue
    @Column("NAME")
    public String name;
}