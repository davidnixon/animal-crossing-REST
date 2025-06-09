package com.example.animalcrossing.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Map;
import java.util.Set;

@Table(name = "DECOR", schema = "PUBLIC")
public class Decor {

    @Id
    @JsonProperty("id")
    @Column("ID")
    public int id;

    @JsonProperty("category")
    @Column("CATEGORY")
    public String category;

    @JsonProperty("kind")
    @Column("KIND")
    public String kind;

    @JsonProperty("body-title")
    @Column("BODY_TITLE")
    public String bodyTitle;

    @JsonProperty("pattern-title")
    @Column("PATTERN_TITLE")
    public String patternTitle;

    @JsonProperty("isDIY")
    @Column("IS_DIY")
    public Boolean isDiy;

    @JsonProperty("canCustomizeBody")
    @Column("CAN_CUSTOMIZE_BODY")
    public Boolean canCustomizeBody;

    @JsonProperty("canCustomizePattern")
    @Column("CAN_CUSTOMIZE_PATTERN")
    public Boolean canCustomizePattern;

    @JsonProperty("kit-cost")
    @Column("KIT_COST")
    public Integer kitCost;

    @JsonProperty("size")
    @Column("SIZE")
    public String size;

    @JsonProperty("source")
    @Column("SOURCE")
    public String source;

    @JsonProperty("source-detail")
    @Column("SOURCE_DETAIL")
    public String sourceDetail;

    @JsonProperty("version")
    @Column("VERSION")
    public String version;

    @JsonProperty("hha-concept-1")
    @Column("HHA_CONCEPT_1")
    public String hhaConcept1;

    @JsonProperty("hha-concept-2")
    @Column("HHA_CONCEPT_2")
    public String hhaConcept2;

    @JsonProperty("hha-series")
    @Column("HHA_SERIES")
    public String hhaSeries;

    @JsonProperty("hha-set")
    @Column("HHA_SET")
    public String hhaSet;

    @JsonProperty("isInteractive")
    @Column("IS_INTERACTIVE")
    public Boolean isInteractive;

    @JsonProperty("tag")
    @Column("TAG")
    public String tag;

    @JsonProperty("isOutdoor")
    @Column("IS_OUTDOOR")
    public Boolean isOutdoor;

    @JsonProperty("lighting-type")
    @Column("LIGHTING_TYPE")
    public String lightingType;

    @JsonProperty("isDoorDeco")
    @Column("IS_DOOR_DECO")
    public Boolean isDoorDeco;

    @JsonProperty("isCatalog")
    @Column("IS_CATALOG")
    public Boolean isCatalog;

    @JsonProperty("internal-id")
    @Column("INTERNAL_ID")
    public Integer internalId;

    @JsonProperty("buy-price")
    @Column("BUY_PRICE")
    public Integer buyPrice;

    @JsonProperty("sell-price")
    @Column("SELL_PRICE")
    public Integer sellPrice;

    @MappedCollection(idColumn = "DECOR_ID", keyColumn = "LOCALE")
    @JsonProperty("name")
    private Map<String, DecorName> name;

    @MappedCollection(idColumn = "DECOR_ID")
    @JsonProperty("variants")
    private Set<DecorVariant> variants;
}