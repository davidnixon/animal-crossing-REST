import { dirname, join, relative, resolve } from "node:path";
import { readdirSync } from 'node:fs';

// Escape single quotes for SQL
export const encodeSqlString = (str) => {
    if (!str) return null;
   return "'" + str.replace(/'/g, "''") + "'";
}

export const encodeBoolean = (val) => val ? 'TRUE' : 'FALSE'

// Helper to convert arrays to CSV strings
export const toCsv = (arr) => arr && arr.length ? arr.join(',') : '';

// make the images & icons static references instead of API endpoints
export const normalizeUri = (url, filename = null, ext = ".png") => {
    let path = url.replace(/^http.*(v2|v1)\//, "/") + ext;
    const directoryName = dirname(path).replace("hourly", "music");
    const found = findFirstFile(filename + ext, join("..", directoryName));
    if (found)
        path = "/" + relative("..", found)
    else
        path = join(directoryName, filename + ext)
    return "'" + path + "'";
}

// Basic version - finds the first matching file
export const findFirstFile = (searchFile, startPath = '.') => {
    // Normalize the search path
    const currentPath = resolve(startPath);

    try {
        // Read all files/directories in the current path
        const files = readdirSync(currentPath, { withFileTypes: true });

        for (const file of files) {
            const fullPath = join(currentPath, file.name);

            // If the name matches, return the path
            if (file.name === searchFile) {
                return fullPath;
            }

            // If it's a directory, search recursively
            if (file.isDirectory()) {
                const found = findFirstFile(searchFile, fullPath);
                if (found) return found;
            }
        }

        // File is not found in this path
        return null;

    } catch (error) {
        console.error(`Error searching in ${currentPath}:`, error);
        return null;
    }
}

