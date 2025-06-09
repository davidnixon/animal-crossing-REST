package com.example.animalcrossing.model;

import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "VILLAGER_CATCH_TRANSLATIONS", schema = "PUBLIC")
public class VillagerCatchTranslation {

    @Column("VILLAGER_ID")
    public int villagerId;

    @Column("LOCALE")
    public String locale;

    @JsonValue
    @Column("PHRASE")
    public String phrase;
}