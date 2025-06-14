-- Drop tables if they exist
DROP TABLE IF EXISTS SEA_CREATURE_NAMES;
DROP TABLE IF EXISTS SEA_CREATURES;

CREATE TABLE SEA_CREATURES
(
    ID                   INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    FILE_NAME            VARCHAR(64) NOT NULL UNIQUE,
    SPEED                VARCHAR(32),
    SHADOW               VARCHAR(32),
    PRICE                INTEGER,
    CATCH_PHRASE         VARCHAR(128),
    IMAGE_URI            VARCHAR(128),
    ICON_URI             VARCHAR(128),
    MUSEUM_PHRASE        VARCHAR(1024),

    -- Availability fields
    MONTH_NORTHERN       VARCHAR(32),
    MONTH_SOUTHERN       VARCHAR(32),
    TIME                 VARCHAR(32),
    IS_ALL_DAY           BOOLEAN,
    IS_ALL_YEAR          BOOLEAN,
    MONTH_ARRAY_NORTHERN VARCHAR(64), -- CSV string of months
    MONTH_ARRAY_SOUTHERN VARCHAR(64), -- CSV string of months
    TIME_ARRAY           VARCHAR(128) -- CSV string of hours
);

-- Localized names
CREATE TABLE SEA_CREATURE_NAMES
(
    ID              INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    SEA_CREATURE_ID INTEGER      NOT NULL,
    LOCALE          VARCHAR(32)  NOT NULL,
    NAME            VARCHAR(128) NOT NULL,
    FOREIGN KEY (SEA_CREATURE_ID) REFERENCES SEA_CREATURES (ID) ON DELETE CASCADE
);
