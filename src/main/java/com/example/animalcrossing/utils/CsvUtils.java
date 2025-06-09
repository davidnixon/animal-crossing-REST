package com.example.animalcrossing.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.logging.Logger;

public class CsvUtils {

    private static final Logger LOGGER = Logger.getLogger(CsvUtils.class.getName());

    private CsvUtils() {
        // Prevent instantiation
    }

    public static List<Integer> parseCsvToIntList(String csv) {
        if (csv == null || csv.isBlank()) {
            return Collections.emptyList();
        }

        return Arrays.stream(csv.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .map(s -> {
                    try {
                        return Integer.parseInt(s);
                    } catch (NumberFormatException e) {
                        LOGGER.warning("Skipping invalid integer value in CSV: \"" + s + "\"");
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}

