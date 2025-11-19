package org.Task2

/**
 ** Extracts the value associated with a given key from a configuration string.
 *
 * This function parses a multi-line configuration string where key-value pairs are separated by semicolons (`;`)
 * and keys and values are separated by colons (`:`). It handles inconsistent spacing,
 * multi-line entries, and case-insensitive key matching.
 *
 * @param config The full configuration string containing key-value pairs.
 * @param key The key whose associated value should be extracted.
 * @return The value corresponding to the specified key, or `null` if the key is not found.
 *
 ** Features:
 *  - Trims leading/trailing spaces around keys and values.
 *  - Case-insensitive comparison for keys.
 *  - Supports keys and values on the same line or across multiple lines separated by `;`.
 *  - Safely handles values that contain colons by splitting with `limit = 2`.
 */
fun extractValue(config: String, key: String): String? {

    val splitConfig = config.trim().split(";")

    // using Chaining Functional Programming.
    val filteredConfig = splitConfig
        .filter { it.isNotBlank() }
        .filter { it.contains(":") }
        .map { it.trim().split(":", limit = 2) }

    for (pair in filteredConfig){
        if (pair[0].trim().lowercase() == key.trim().lowercase()){
            return pair[1].trim()
        }
    }
    return null
}

fun main() {

    val config = """
        userId: user-123;   role :  admin; authToken: token-xyz-789 ;
        environment: production;  
        expiry: 1672531199
    """.trimIndent()   // I use it to escape from INDENTATION in the start of line.

    // -------- TEST CASES --------

    println("---- TEST CASES ----")

    // 1) Test role
    println("Test 1 - role: ${extractValue(config, "role")}")

    // 2) Test authToken
    println("Test 2 - authToken: ${extractValue(config, "authToken")}")

    // 3) Test userId
    println("Test 3 - userId: ${extractValue(config, "userId")}")

    // 4) Test expiry
    println("Test 4 - expiry: ${extractValue(config, "expiry")}")

    // 5) Test key that does NOT exist
    println("Test 5 - hostname: ${extractValue(config, "hostname")}")

    // 6) Test case-insensitive
    println("Test 6 - ROLE: ${extractValue(config, "ROLE")}")

    // 7) Test different spacing
    println("Test 7 - ' authToken ': ${extractValue(config, " authToken ")}")
}