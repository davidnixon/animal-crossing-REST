import wallMounted from "../wallmounted.json" with {type: "json"}
import housewares from "../houseware.json" with {type: "json"}
import misc from "../misc.json" with {type: "json"}

/**
 * Performs a deep equality comparison between two values
 * @param {*} value1 First value to compare
 * @param {*} value2 Second value to compare
 * @returns {boolean} True if values are deeply equal, false otherwise
 */
function isDeepEqual(value1, value2) {
    // Handle primitive types and null/undefined
    if (value1 === value2) {
        return true;
    }

    // If one is null/undefined but not both (since we checked === above)
    if (value1 == null || value2 == null) {
        return false;
    }

    // Handle Dates
    if (value1 instanceof Date && value2 instanceof Date) {
        return value1.getTime() === value2.getTime();
    }

    // Handle RegExp
    if (value1 instanceof RegExp && value2 instanceof RegExp) {
        return value1.toString() === value2.toString();
    }

    // Handle different types
    if (typeof value1 !== typeof value2) {
        return false;
    }

    // Handle Arrays
    if (Array.isArray(value1) && Array.isArray(value2)) {
        if (value1.length !== value2.length) {
            return false;
        }

        return value1.every((item, index) => isDeepEqual(item, value2[index]));
    }

    // If one is an array but not both (since we checked above)
    if (Array.isArray(value1) || Array.isArray(value2)) {
        return false;
    }

    // Handle sets
    if (value1 instanceof Set && value2 instanceof Set) {
        return value1.symmetricDifference(value2).size === 0;
    }

    // If one is a Set but not the other
    if (value1 instanceof Set || value2 instanceof Set) {
        return false
    }

    // Handle objects
    if (typeof value1 === 'object') {
        const keys1 = Object.keys(value1);
        const keys2 = Object.keys(value2);

        if (keys1.length !== keys2.length) {
            return false;
        }

        return keys1.every(key => {
            return (
                Object.prototype.hasOwnProperty.call(value2, key) &&
                isDeepEqual(value1[key], value2[key])
            );
        });
    }

    return false;
}
function pick(obj, keys) {
    if (obj == null) {
        return {};
    }

    return Object.fromEntries(
        keys
            .filter(key => key in obj)
            .map(key => [key, obj[key]])
    );
}

const longest = {}
function setLongest(key, value) {
    if (typeof value !== "string") return
    const current = longest[key] ?? 0
    if (current < value.length) {
        longest[key] = value.length
    }
}

const common = new Set()
const unique = new Set()
common.add("kind")
common.add("id")
common.add("variants")
for (const data of [wallMounted, housewares, misc])
    for (const key of Object.keys(data)) {
    setLongest("kind", key)
    const list = data[key]
    const reference = list[0]
    for (let i = 1; i < list.length; i++) {
        const item = list[i]
        Object.keys(item).forEach(key => {
            setLongest(key, item[key])
            if (!unique.has(key) && isDeepEqual(item[key], reference[key])) {
                common.add(key)
            } else {
                common.delete(key)
                unique.add(key)
            }
        })
    }
}
console.log("common fields", common)
console.log("variant fields", unique)

const exampleKey = Object.keys(wallMounted)[2]
const v1 = pick(wallMounted[exampleKey][0], Array.from(unique))
const v2 = pick(wallMounted[exampleKey][1], Array.from(unique))
const v3 = pick(wallMounted[exampleKey][2], Array.from(unique))
const example = { ...wallMounted[exampleKey][0], id: 1, kind: exampleKey, variants: [v1, v2, v3] }
console.log("example object", JSON.stringify(pick(example, Array.from(common)), null, 2))

console.log("longest string values", JSON.stringify(longest, null, 2))
