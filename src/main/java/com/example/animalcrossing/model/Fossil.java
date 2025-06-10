package com.example.animalcrossing.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Map;

@Table(name = "FOSSILS", schema = "PUBLIC")
public class Fossil {

    @Id
    private Integer id;

    @Column("FILE_NAME")
    @JsonProperty("file-name")
    private String fileName;

    @Column("PRICE")
    @JsonProperty("price")
    private Integer price;

    @Column("MUSEUM_PHRASE")
    @JsonProperty("museum-phrase")
    private String museumPhrase;

    @Column("IMAGE_URI")
    @JsonProperty("image_uri")
    private String imageUri;

    @Column("PART_OF")
    @JsonProperty("part-of")
    private String partOf;

    @MappedCollection(idColumn = "FOSSIL_ID", keyColumn = "LOCALE")
    @JsonProperty(value="name")
    private Map<String, FossilName> name;
}

