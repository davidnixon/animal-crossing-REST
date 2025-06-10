package com.example.animalcrossing.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "HOURLY", schema = "PUBLIC")
public class Hourly {

    @Id
    @JsonProperty("id")
    @Column("ID")
    public int id;

    @JsonProperty("file-name")
    @Column("FILE_NAME")
    public String fileName;

    @JsonProperty("hour")
    @Column("HOUR")
    public Integer hour;

    @JsonProperty("weather")
    @Column("WEATHER")
    public String weather;

    @JsonProperty("music_uri")
    @Column("MUSIC_URI")
    public String musicUri;
}