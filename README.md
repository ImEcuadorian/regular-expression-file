# Regular Expression File Processor

A Java application that demonstrates the use of regular expressions to process and validate text patterns in files.

## Description

This application allows users to write text to a file and then search for specific patterns within that text using regular expressions. It can identify and extract:

- Web URLs
- Credit card numbers
- Words in CamelCase format
- Email addresses

The application provides a simple command-line interface for interacting with these features.

## Features

- Write text to a file
- Read text from a file
- Validate and extract web URLs
- Validate and extract credit card numbers
- Validate and extract words in CamelCase format
- Validate and extract email addresses
- User-friendly menu-driven interface

## Requirements

- Java 21 or higher
- Gradle (for building the project)

## Installation

1. Clone the repository:
   ```
   git clone https://github.com/imecuadorian/regular-expression-file.git
   ```

2. Navigate to the project directory:
   ```
   cd regular-expression-file
   ```

3. Build the project using Gradle:
   ```
   ./gradlew build
   ```

## Usage

Run the application using Gradle:
```
./gradlew run
```

Or run the compiled JAR file:
```
java -jar build/libs/regular-expression-file-1.0-SNAPSHOT.jar
```

### Main Menu Options

1. **Write in the file (information.txt)** - Allows you to input text that will be written to the file.
2. **Read the file (information.txt)** - Reads the file and provides a submenu to search for specific patterns.
3. **Leave the application** - Exits the application.

### Submenu Options (when reading the file)

1. **Web URL** - Finds and displays all web URLs in the file.
2. **Credit Card Number** - Finds and displays all credit card numbers in the file.
3. **Words in Camel Case** - Finds and displays all words in CamelCase format in the file.
4. **Email** - Finds and displays all email addresses in the file.
5. **Back to main menu** - Returns to the main menu.

## Regular Expressions Used

- **Web URL**: `^https?:\/\/(www\.)?[a-zA-Z0-9\-]+\.[a-zA-Z]{2,}(\S*)?$`
- **Email**: `^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$`
- **Credit Card**: `^(?:\d{4}[- ]?){3}\d{4}$`
- **CamelCase**: `^\b([A-Z][a-z0-9]+)+\b$`

## Dependencies

- generic-library-1.0.0.jar - A custom library for file operations and regular expression validation
- JetBrains Annotations - For code annotations
- JUnit - For testing

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Author

[ImEcuadorian](https://github.com/imecuadorian)