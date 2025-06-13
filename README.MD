# Animal Crossing: New Horizons REST API

A Spring Boot implementation of a REST API for Animal Crossing: New Horizons data.

## About

This project is a recreation of the [ACNHAPI](https://github.com/alexislours/ACNHAPI) by Alexis Lours, rebuilt using Spring Boot. It provides a read-only REST API for accessing game data including artwork, bugs, fish, fossils, sea creatures, songs, villagers, and more.

## Implementation Details

This API was built using:
- Spring Boot
- Spring Data JDBC
- Spring Doc - openapi
- HSQLDB Database

All static content (images, music) is served directly from the application.

## Development Process

This project was created as an experiment to evaluate JetBrains AI in a real-world Java workflow. JetBrains AI was used to:

- Generate SQL schema from JSON data
- Create Java models with appropriate annotations
- Build repository interfaces and controllers
- Transform original JSON data into SQL insert statements

The AI assistance significantly accelerated the development process, providing about 85% correct code that required minimal tweaking and cleanup.

## Key Insights from Using JetBrains AI

- Having AI assistance directly in the IDE streamlines the development workflow
- The ability to create files with a single click instead of copy/pasting is a significant improvement
- Using context tags like "#thisFile" makes prompting more precise
- The diff/merge interface for applying code changes is very helpful

## Docker

This project includes a Dockerfile for containerization. To build and run the application using Docker:

```bash
# Build the Docker image
docker build -t animal-crossing-api .

# Run the container
docker run -p 8080:8080 animal-crossing-api
```

The API will be available at http://localhost:8080

## Credits

- Original ACNHAPI by [Alexis Lours](https://github.com/alexislours/ACNHAPI)
- All game content and artwork is property of Nintendo
