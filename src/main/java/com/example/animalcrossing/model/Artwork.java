package com.example.animalcrossing.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Map;

@Table(name = "ARTWORKS", schema = "PUBLIC")
public class Artwork {
    @Id
    @JsonProperty(value="id")
    private int id;
    @JsonProperty(value="file-name")
    private String file_name;
    private boolean has_fake;
    @JsonProperty(value="buy-price")
    private int buy_price;
    @JsonProperty(value="sell-price")
    private int sell_price;
    @JsonProperty(value="image_uri")
    private String image_uri;
    @JsonProperty(value="museum-desc")
    private String museum_desc;
    @MappedCollection(idColumn = "ARTWORK_ID", keyColumn = "LOCALE")
    @JsonProperty(value="name")
    private Map<String, ArtworkName> name;
}
