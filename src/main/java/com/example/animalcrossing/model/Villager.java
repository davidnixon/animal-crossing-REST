package com.example.animalcrossing.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Map;

@Table(name = "VILLAGERS", schema = "PUBLIC")
public class Villager {

    @Id
    @JsonProperty("id")
    @Column("ID")
    public int id;

    @JsonProperty("file-name")
    @Column("FILE_NAME")
    public String fileName;

    @JsonProperty("personality")
    @Column("PERSONALITY")
    public String personality;

    @JsonProperty("birthday")
    @Column("BIRTHDAY")
    public String birthday;

    @JsonProperty("birthday-string")
    @Column("BIRTHDAY_STRING")
    public String birthdayString;

    @JsonProperty("species")
    @Column("SPECIES")
    public String species;

    @JsonProperty("gender")
    @Column("GENDER")
    public String gender;

    @JsonProperty("subtype")
    @Column("SUBTYPE")
    public String subtype;

    @JsonProperty("hobby")
    @Column("HOBBY")
    public String hobby;

    @JsonProperty("catch-phrase")
    @Column("CATCH_PHRASE")
    public String catchPhrase;

    @JsonProperty("icon_uri")
    @Column("ICON_URI")
    public String iconUri;

    @JsonProperty("image_uri")
    @Column("IMAGE_URI")
    public String imageUri;

    @JsonProperty("bubble-color")
    @Column("BUBBLE_COLOR")
    public String bubbleColor;

    @JsonProperty("text-color")
    @Column("TEXT_COLOR")
    public String textColor;

    @JsonProperty("saying")
    @Column("SAYING")
    public String saying;

    @MappedCollection(idColumn = "VILLAGER_ID", keyColumn = "LOCALE")
    @JsonProperty("name")
    private Map<String, VillagerName> name;

    @MappedCollection(idColumn = "VILLAGER_ID", keyColumn = "LOCALE")
    @JsonProperty("catch-translations")
    private Map<String, VillagerCatchTranslation> catchTranslations;
}