import data from "../sea.json" with {type: "json"};
import {encodeBoolean, encodeSqlString, normalizeUri} from "./sqlUtils.js";

const values = [];
const nameValues = [];

function seaCreatureToSql(seaCreature) {
    const id = seaCreature.id;
    const fileName = encodeSqlString(seaCreature["file-name"]);
    const speed = encodeSqlString(seaCreature.speed);
    const shadow = encodeSqlString(seaCreature.shadow);
    const price = seaCreature.price;
    const catchPhrase = encodeSqlString(seaCreature["catch-phrase"]);
    const imageUri = normalizeUri(seaCreature.image_uri, fileName);
    const iconUri = normalizeUri(seaCreature.icon_uri, fileName);
    const museumPhrase = encodeSqlString(seaCreature["museum-phrase"]);

    // Availability data
    const availability = seaCreature.availability;
    const monthNorthern = encodeSqlString(availability["month-northern"]);
    const monthSouthern = encodeSqlString(availability["month-southern"]);
    const time = encodeSqlString(availability.time);
    const isAllDay = encodeBoolean(availability.isAllDay);
    const isAllYear = encodeBoolean(availability.isAllYear);
    const monthArrayNorthern = availability["month-array-northern"].join(",");
    const monthArraySouthern = availability["month-array-southern"].join(",");
    const timeArray = availability["time-array"].join(",");

    values.push(`(
        ${id}, ${fileName}, ${speed}, ${shadow}, ${price}, ${catchPhrase},
        ${imageUri}, ${iconUri}, ${museumPhrase},
        ${monthNorthern}, ${monthSouthern}, ${time}, ${isAllDay}, ${isAllYear},
        ${monthArrayNorthern}, ${monthArraySouthern}, ${timeArray}
    )`.replace(/\s+/gm, " "));

    // Generate name translations
    nameValues.push(`-- Localized name for ${fileName}`);
    Object.entries(seaCreature.name || {}).map(([locale, value]) => {
        const name = encodeSqlString(value);
        nameValues.push(`(${id}, '${locale}', ${name})`);
    });
}

Object.values(data).forEach(seaCreatureToSql);

console.log(`INSERT INTO SEA_CREATURES (ID, FILE_NAME, SPEED, SHADOW, PRICE, CATCH_PHRASE, IMAGE_URI, ICON_URI,
                                        MUSEUM_PHRASE,
                                        MONTH_NORTHERN, MONTH_SOUTHERN, TIME, IS_ALL_DAY, IS_ALL_YEAR,
                                        MONTH_ARRAY_NORTHERN, MONTH_ARRAY_SOUTHERN, TIME_ARRAY)
             VALUES`
    .replace(/\s+/g," "));
console.log(values.join(",\n") + ";");

console.log(`\nINSERT INTO SEA_CREATURE_NAMES (SEA_CREATURE_ID, LOCALE, NAME) VALUES`);
console.log(nameValues.join(",\n").replace(/(^--.*),/gm, "\n$1") + ";");