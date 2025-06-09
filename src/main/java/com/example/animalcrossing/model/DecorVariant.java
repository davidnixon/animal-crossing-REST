package com.example.animalcrossing.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "DECOR_VARIANTS", schema = "PUBLIC")
public class DecorVariant {

    @Column("DECOR_ID")
    private int wallMountedId;

    @Column("VARIANT")
    @JsonProperty("variant")
    public String variant;

    @Column("COLOR_1")
    @JsonProperty("color-1")
    public String color1;

    @Column("COLOR_2")
    @JsonProperty("color-2")
    public String color2;

    @Column("FILE_NAME")
    @JsonProperty("file-name")
    public String fileName;

    @Column("VARIANT_ID")
    @JsonProperty("variant-id")
    public String variantId;

    @Column("IMAGE_URI")
    @JsonProperty("image_uri")
    public String imageUri;

    @Column("PATTERN")
    @JsonProperty("pattern")
    public String pattern;
}