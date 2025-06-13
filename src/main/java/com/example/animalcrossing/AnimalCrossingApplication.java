package com.example.animalcrossing;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication
@EnableJdbcRepositories
@OpenAPIDefinition(
        info = @Info(
                title = "Animal Crossing: New Horizons REST API",
                version = "2.1"
        )
)
public class AnimalCrossingApplication extends AbstractJdbcConfiguration {

    public static void main(String[] args) {
        SpringApplication.run(AnimalCrossingApplication.class, args);
    }
}