
package com.example.animalcrossing.model;

import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "SONG_NAMES", schema = "PUBLIC")
public class SongName {

    @Column("SONG_ID")
    public int songId;

    @Column("LOCALE")
    public String locale;

    @JsonValue
    @Column("NAME")
    public String name;
}