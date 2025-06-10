import data from "../json/hourly.json" with { type: "json" };
import { encodeSqlString, normalizeUri } from "./sqlUtils.js";

const values = []

function hourlyToSql(hourly) {
    const id = hourly.id;
    const fileName = encodeSqlString(hourly["file-name"]);
    const hour = hourly.hour;
    const weather = encodeSqlString(hourly.weather);
    const musicUri = normalizeUri(hourly.music_uri, fileName, ".mp3");

    values.push(`(
        ${id}, ${fileName}, ${hour}, ${weather}, ${musicUri}
    )`.replace(/\s+/gm," "));
}

Object.values(data).forEach(hourlyToSql);

console.log(`INSERT INTO HOURLY (ID, FILE_NAME, HOUR, WEATHER, MUSIC_URI) VALUES`);
console.log(values.join(",\n") + ";");