import data from "../wallmounted.json" with {type: "json"};
import housewares from "../houseware.json" with {type: "json"}
import misc from "../misc.json" with {type: "json"}
import {encodeBoolean, encodeSqlString, normalizeUri} from "./sqlUtils.js";

const mainValues = [];
const variantValues = [];
const nameValues = [];
let id = 1;

function processDecor(itemName, variants, category) {
    // Get data from the first variant as base item data
    const baseVariant = variants[0];

    const kind = encodeSqlString(itemName);
    const bodyTitle = encodeSqlString(baseVariant["body-title"]);
    const patternTitle = encodeSqlString(baseVariant["pattern-title"]);
    const isDIY = encodeBoolean(baseVariant.isDIY);
    const canCustomizeBody = baseVariant.canCustomizeBody;
    const canCustomizePattern = baseVariant.canCustomizePattern;
    const kitCost = baseVariant["kit-cost"];
    const size = encodeSqlString(baseVariant.size);
    const source = encodeSqlString(baseVariant.source);
    const sourceDetail = encodeSqlString(baseVariant["source-detail"]);
    const version = encodeSqlString(baseVariant.version);
    const hha1 = encodeSqlString(baseVariant["hha-concept-1"]);
    const hha2 = encodeSqlString(baseVariant["hha-concept-2"]);
    const hhaSeries = encodeSqlString(baseVariant["hha-series"]);
    const hhaSet = encodeSqlString(baseVariant["hha-set"]);
    const isInteractive = encodeBoolean(baseVariant.isInteractive);
    const tag = encodeSqlString(baseVariant.tag);
    const isOutdoor = encodeBoolean(baseVariant.isOutdoor);
    const lightingType = encodeSqlString(baseVariant["lighting-type"]);
    const isDoorDeco = encodeBoolean(baseVariant.isDoorDeco);
    const isCatalog = encodeBoolean(baseVariant.isCatalog);
    const internalId = baseVariant["internal-id"];
    const buyPrice = baseVariant["buy-price"];
    const sellPrice = baseVariant["sell-price"];
    const speakerType = encodeSqlString(baseVariant["speaker-type"]);
    const name = baseVariant["name"];

    mainValues.push(`(
        ${id}, '${category}', ${kind}, ${bodyTitle}, ${patternTitle}, ${isDIY}, ${canCustomizeBody},
        ${canCustomizePattern}, ${kitCost}, ${size}, ${source}, ${sourceDetail}, ${speakerType},
        ${version}, ${hha1}, ${hha2}, ${hhaSeries}, ${hhaSet}, ${isInteractive},
        ${tag}, ${isOutdoor}, ${lightingType}, ${isDoorDeco}, ${isCatalog},
        ${internalId}, ${buyPrice}, ${sellPrice}
    )`.replace(/\s+/gm, " "));

    // Process names
    nameValues.push(`-- Localized names for ${kind}`);
    Object.entries(name).forEach(([locale, name]) => {
        nameValues.push(`(${id}, ${encodeSqlString(locale)}, ${encodeSqlString(name)})`);
    });

    // Process variants
    variants.forEach(variant => {
        variantValues.push(`-- Variant for ${itemName}: ${variant.variant ?? variant["color-1"]}`);
        variantValues.push(`(
            ${id}, ${encodeSqlString(variant.variant)},
            ${encodeSqlString(variant["color-1"])},
            ${encodeSqlString(variant["color-2"])},
            ${encodeSqlString(variant["file-name"])},
            ${encodeSqlString(variant["variant-id"])},
            ${normalizeUri(variant.image_uri, variant["file-name"])},
            ${encodeSqlString(variant.pattern)}
        )`.replace(/\s+/gm, " "));
    });

    id++;
}

// Process all items
mainValues.push('-- wall mounted decor');
Object.entries(data).forEach(([itemName, variants]) => {
    processDecor(itemName, variants, 'wall-mounted');
});
mainValues.push('-- housewares decor');
Object.entries(housewares).forEach(([itemName, variants]) => {
    processDecor(itemName, variants, 'houseware');
});
mainValues.push('-- misc decor');
Object.entries(misc).forEach(([itemName, variants]) => {
    processDecor(itemName, variants, 'misc');
});

// Output SQL statements
console.log(`INSERT INTO DECOR (ID, CATEGORY, KIND, BODY_TITLE, PATTERN_TITLE, IS_DIY, CAN_CUSTOMIZE_BODY,
                                CAN_CUSTOMIZE_PATTERN, KIT_COST, SIZE, SOURCE, SOURCE_DETAIL, SPEAKER_TYPE,
                                VERSION, HHA_CONCEPT_1, HHA_CONCEPT_2, HHA_SERIES, HHA_SET,
                                IS_INTERACTIVE, TAG, IS_OUTDOOR, LIGHTING_TYPE, IS_DOOR_DECO,
                                IS_CATALOG, INTERNAL_ID, BUY_PRICE, SELL_PRICE)
             VALUES`);
console.log(mainValues.join(",\n").replace(/(^--.*),/gm, "\n$1") + ";");

console.log(`\nINSERT INTO DECOR_VARIANTS (
    DECOR_ID, VARIANT, COLOR_1, COLOR_2, FILE_NAME,
    VARIANT_ID, IMAGE_URI, PATTERN
) VALUES`);
console.log(variantValues.join(",\n").replace(/(^--.*),/gm, "\n$1") + ";");

console.log(`\nINSERT INTO DECOR_NAMES (
    DECOR_ID, LOCALE, NAME
) VALUES`);
console.log(nameValues.join(",\n").replace(/(^--.*),/gm, "\n$1") + ";");