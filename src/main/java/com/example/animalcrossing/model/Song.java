package com.example.animalcrossing.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Map;

@Table(name = "SONGS", schema = "PUBLIC")
public class Song {

    @Id
    @JsonProperty("id")
    @Column("ID")
    public int id;

    @JsonProperty("file-name")
    @Column("FILE_NAME")
    public String fileName;

    @JsonProperty("isOrderable")
    @Column("IS_ORDERABLE")
    public Boolean isOrderable;

    @JsonProperty("buy-price")
    @Column("BUY_PRICE")
    public Integer buyPrice;

    @JsonProperty("sell-price")
    @Column("SELL_PRICE")
    public Integer sellPrice;

    @JsonProperty("image_uri")
    @Column("IMAGE_URI")
    public String imageUri;

    @JsonProperty("music_uri")
    @Column("MUSIC_URI")
    public String musicUri;

    @MappedCollection(idColumn = "SONG_ID", keyColumn = "LOCALE")
    @JsonProperty("name")
    private Map<String, SongName> name;
}