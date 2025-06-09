import data from "../json/villagers.json" with { type: "json" };
import { encodeSqlString, normalizeUri } from "./sqlUtils.js";

const values = []
const nameValues = []
const catchphraseValues = []

function villagerToSql(villager) {
    const id = villager.id;
    const fileName = encodeSqlString(villager["file-name"]);
    const personality = encodeSqlString(villager.personality);
    const birthday = encodeSqlString(villager.birthday);
    const birthdayString = encodeSqlString(villager["birthday-string"]);
    const species = encodeSqlString(villager.species);
    const gender = encodeSqlString(villager.gender);
    const subtype = encodeSqlString(villager.subtype);
    const hobby = encodeSqlString(villager.hobby);
    const catchPhrase = encodeSqlString(villager["catch-phrase"]);
    const iconUri = normalizeUri(villager.icon_uri, fileName);
    const imageUri = normalizeUri(villager.image_uri, fileName);
    const bubbleColor = encodeSqlString(villager["bubble-color"]);
    const textColor = encodeSqlString(villager["text-color"]);
    const saying = encodeSqlString(villager.saying);

    values.push(`(
        ${id}, ${fileName}, ${personality}, ${birthday}, ${birthdayString}, ${species},
        ${gender}, ${subtype}, ${hobby}, ${catchPhrase}, ${iconUri}, ${imageUri},
        ${bubbleColor}, ${textColor}, ${saying}
    )`.replace(/\s+/gm," "));

    // Generate name translations
    nameValues.push(`-- Localized name for ${fileName}`)
    const nameInserts = Object.entries(villager.name || {}).map(([locale, value]) => {
        const name = encodeSqlString(value);
        nameValues.push(`(${id}, '${locale}', ${name})`);
    });

    // Generate catchphrase translations
    catchphraseValues.push(`-- Localized catchphrase for ${fileName}`)
    const catchTranslations = Object.entries(villager["catch-translations"] || {}).map(([locale, value]) => {
        const phrase = encodeSqlString(value);
        catchphraseValues.push(`(${id}, '${locale}', ${phrase})`);
    });
}

Object.values(data).forEach(villagerToSql);

console.log(`INSERT INTO VILLAGERS (ID, FILE_NAME, PERSONALITY, BIRTHDAY, BIRTHDAY_STRING, SPECIES, GENDER, SUBTYPE, HOBBY, CATCH_PHRASE, ICON_URI, IMAGE_URI, BUBBLE_COLOR, TEXT_COLOR, SAYING) VALUES`);
console.log(values.join(",\n") + ";")

console.log(`\nINSERT INTO VILLAGER_NAMES (VILLAGER_ID, LOCALE, NAME) VALUES`);
console.log(nameValues.join(",\n").replace(/(^--.*),/gm,"\n$1") + ";")

console.log('\nINSERT INTO VILLAGER_CATCH_TRANSLATIONS (VILLAGER_ID, LOCALE, PHRASE) VALUES ');
console.log(catchphraseValues.join(",\n").replace(/(^--.*),/gm,"\n$1") + ";")
