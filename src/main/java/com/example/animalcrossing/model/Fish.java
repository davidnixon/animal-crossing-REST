package com.example.animalcrossing.model;

import com.example.animalcrossing.utils.CsvUtils;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Map;

@Table(name = "FISH", schema = "PUBLIC")
public class Fish {

    @Id
    @JsonProperty("id")
    @Column("ID")
    public int id;

    @JsonProperty("file-name")
    @Column("FILE_NAME")
    public String fileName;

    @JsonProperty("price")
    @Column("PRICE")
    public int price;

    @JsonProperty("price-cj")
    @Column("PRICE_CJ")
    public int priceCj;

    @JsonProperty("shadow")
    @Column("SHADOW")
    public String shadow;

    @JsonProperty("catch-phrase")
    @Column("CATCH_PHRASE")
    public String catchPhrase;

    @JsonProperty("museum-phrase")
    @Column("MUSEUM_PHRASE")
    public String museumPhrase;

    @JsonProperty("image_uri")
    @Column("IMAGE_URI")
    public String imageUri;

    @JsonProperty("icon_uri")
    @Column("ICON_URI")
    public String iconUri;

    @Column("MONTH_NORTHERN")
    private String monthNorthern;

    @Column("MONTH_SOUTHERN")
    private String monthSouthern;

    @Column("TIME")
    private String time;

    @Column("IS_ALL_DAY")
    private boolean isAllDay;

    @Column("IS_ALL_YEAR")
    private boolean isAllYear;

    @Column("LOCATION")
    private String location;

    @Column("RARITY")
    private String rarity;

    @Column("MONTH_ARRAY_NORTHERN")
    private String monthArrayNorthern;

    @Column("MONTH_ARRAY_SOUTHERN")
    private String monthArraySouthern;

    @Column("TIME_ARRAY")
    private String timeArray;

    @MappedCollection(idColumn = "FISH_ID", keyColumn = "LOCALE")
    @JsonProperty("name")
    private Map<String, FishName> name;

    @JsonGetter("availability")
    public Map<String, ?> getAvailability() {
        return Map.ofEntries(
                Map.entry("month-northern", monthNorthern),
                Map.entry("month-southern", monthSouthern),
                Map.entry("time", time),
                Map.entry("isAllDay", isAllDay),
                Map.entry("isAllYear", isAllYear),
                Map.entry("location", location),
                Map.entry("rarity", rarity),
                Map.entry("month-array-northern", CsvUtils.parseCsvToIntList(monthArrayNorthern)),
                Map.entry("month-array-southern", CsvUtils.parseCsvToIntList(monthArraySouthern)),
                Map.entry("time-array", CsvUtils.parseCsvToIntList(timeArray))
        );
    }
}
