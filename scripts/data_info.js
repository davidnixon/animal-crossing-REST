import art from "../art.json" with {type: "json"}
import hourly from "../hourly.json" with {type: "json"}
import fossils from "../json/fossils.json" with {type: "json"}
import bugs from "../bugs.json" with {type: "json"}
import fish from "../fish.json" with {type: "json"}
import sea from "../sea.json" with {type: "json"}
import songs from "../songs.json" with {type: "json"}
import villagers from "../villagers.json" with {type: "json"}

const longest = {}
function setLongest(key, value) {
    if (typeof value !== "string") return
    const current = longest[key] ?? 0
    if (current < value.length) {
        longest[key] = value.length
    }
}

for (const data of [art, hourly, fossils, bugs, fish, sea, songs, villagers])
    for (const value of Object.values(data)) {
        for (const key of Object.keys(value)) {
            setLongest(key, value[key])
        }
    }

console.log("longest string values", JSON.stringify(longest, null, 2))
