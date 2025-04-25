package io.github.imecuadorian.file.expression;

import io.github.imecuadorian.library.*;

import java.io.*;
import java.util.*;

import static io.github.imecuadorian.file.expression.utils.RegEx.*;
import static io.github.imecuadorian.library.Files.validateByRegularExpression;

public class MainFileExpressions {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String FILE_NAME = "information.txt";
    private static final String FILE_PATH = "src/main/resources/%s".formatted(FILE_NAME);
    private static final Files FILES = new Files(FILE_PATH);

    private static final String MENU = """
            Welcome to the application to Manage Files
            
            Choose an option:
            1. Write in the file (information.txt)
            2. Read the file (information.txt)
            3. Leave the application
            
            Option: 
            """;

    private static final String SUBMENU = """
            Choose the information to read:
            1. Web URL
            2. Credit Card Number
            3. Words in Camel Case
            4. Email
            5. Back to main menu
            
            Option: 
            """;

    public static void main(String[] args) {
        String validWEB = validateByRegularExpression("https://www.techworld.com/smartphones", WEB_URL) ?
                "Valid WEB URL" : "Invalid WEB URL";
        System.out.println(validWEB);
        String validCC = validateByRegularExpression("5432 1098 7654 3210", CREDIT_CARD) ?
                "Valid Credit Card" : "Invalid Credit Card";
        System.out.println(validCC);
        String validCC2 = validateByRegularExpression("TechWorld", CAMEL_CASE) ?
                "Valid Camel Case" : "Invalid Camel Case";
        System.out.println(validCC2);
        String validEmail = validateByRegularExpression("support@techworld.com", EMAIL) ?
                "Valid Email" : "Invalid Email";
        System.out.println(validEmail);

        showMenu();
    }

    private static void showMenu() {
        boolean isRunning = true;
        do {
            System.out.print(MENU);
            int option = SCANNER.nextInt();
            switch (option) {
                case 1 -> writeInFile();
                case 2 -> readFromFile();
                case 3 -> {
                    System.out.println("Exiting the application...");
                    isRunning = false;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        } while (isRunning);
    }

    private static void writeInFile() {
        System.out.println("Enter the text to write in the file (information.txt):");
        SCANNER.nextLine(); // Consume the newline character
        String text = SCANNER.nextLine();
        try {
            FILES.writeFile(text, false);
            System.out.println("Text written successfully in the file.");
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }

    private static void readFromFile() {
        String fileContent;
        try {
            fileContent = FILES.readFile();
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return;
        }
        boolean isRunning = true;
        do {
            System.out.println(SUBMENU);
            int option = SCANNER.nextInt();
            switch (option) {
                case 1 -> FILES.findWords(fileContent, WEB_URL).forEach(System.out::println);
                case 2 -> FILES.findWords(fileContent, CREDIT_CARD).forEach(System.out::println);
                case 3 -> FILES.findWords(fileContent, CAMEL_CASE).forEach(System.out::println);
                case 4 -> FILES.findWords(fileContent, EMAIL).forEach(System.out::println);
                case 5 -> {
                    System.out.println("Returning to main menu...");
                    isRunning = false;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        } while (isRunning);

    }
}
