# 📌 Extract Value from Config String – Kotlin Implementation

This project provides a clean, modular Kotlin solution for extracting values from a configuration string formatted as:


The code follows the **Single Responsibility Principle**, making each function handle one specific task for clarity and maintainability.

---

## 🚀 Features

- Extract values from semi-colon separated config strings.
- Handles extra spaces, case-insensitive keys, and missing keys gracefully.
- Uses functional programming style (`map`, `filter`, etc.).
- Modular structure with four small, focused functions.

---

## 🧩 How It Works

The `extractValue()` function is the main entry point. The extraction flow:

1. Split the config string into entries using `splitConfig()`.
2. Filter and parse each entry into key/value pairs using `filterAndSplitPairs()`.
3. Search for the given key using `findValue()`.
4. Returns the value or `null` if not found.

---
