package org.Task2

// This function to extract value.
fun extractValue(config: String, key: String): String? {

    val splittedConfig = splitConfig(config)

    val filteredConfig = filterAndSplitPairs(splittedConfig)

    return findValue(filteredConfig, key)
}

// This function to split Config.
fun splitConfig(config: String): List<String>{
    val splittedConfig = config.trim().split(";")
    return splittedConfig
}

// This function to filter and split pairs.
fun filterAndSplitPairs(items: List<String>): List<List<String>>{
    return items
        .filter { it.isNotBlank() }
        .map { it.trim().split(":", limit = 2) }
}

// This function to FIND VALUE.
fun findValue(pairs: List<List<String>>, key: String): String?{
     pairs.forEach { pair ->
        if (pair[0].trim().lowercase() == key.trim().lowercase()) {
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
    """

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