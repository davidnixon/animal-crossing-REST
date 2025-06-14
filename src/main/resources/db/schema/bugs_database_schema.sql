-- Drop tables if they exist
DROP TABLE IF EXISTS BUG_NAMES;
DROP TABLE IF EXISTS BUGS;

CREATE TABLE BUGS
(
    ID                   INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    FILE_NAME            VARCHAR(64) NOT NULL UNIQUE,
    PRICE                INTEGER,
    PRICE_FLICK          INTEGER,
    CATCH_PHRASE         VARCHAR(128),
    MUSEUM_PHRASE        VARCHAR(1024),
    IMAGE_URI            VARCHAR(128),
    ICON_URI             VARCHAR(128),

    -- Availability fields
    MONTH_NORTHERN       VARCHAR(32),
    MONTH_SOUTHERN       VARCHAR(32),
    TIME                 VARCHAR(64),
    IS_ALL_DAY           BOOLEAN,
    IS_ALL_YEAR          BOOLEAN,
    LOCATION             VARCHAR(128),
    RARITY               VARCHAR(64),
    MONTH_ARRAY_NORTHERN VARCHAR(64), -- CSV string
    MONTH_ARRAY_SOUTHERN VARCHAR(64), -- CSV string
    TIME_ARRAY           VARCHAR(64)  -- CSV string
);

-- Localized names
CREATE TABLE BUG_NAMES
(
    ID     INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    BUG_ID INTEGER      NOT NULL,
    LOCALE VARCHAR(32)  NOT NULL,
    NAME   VARCHAR(128) NOT NULL,
    FOREIGN KEY (BUG_ID) REFERENCES BUGS (ID) ON DELETE CASCADE
);
