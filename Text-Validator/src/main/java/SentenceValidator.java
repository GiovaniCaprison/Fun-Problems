import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * The SentenceValidator class provides a static method to validate sentences according to specific rules.
 * Rules for a valid sentence include:
 * - It must start with a capital letter.
 * - It must end with a period, exclamation mark, or question mark.
 * - It must contain an even number of quotation marks.
 * - Numbers less than 13 must be spelled out.
 */
public class SentenceValidator {

    // Compile a regex pattern for matching numbers, which may be negative.
    private static final Pattern NUMBER_PATTERN = Pattern.compile("\\b-?\\d+\\b");
    private static String output = "";
    /**
     * The main method serves as the entry point for the application.
     * It reads user input from the console and validates it using the isValidSentence method.
     */
    public static void main(String[] args) {
        // Use try-with-resources to ensure the Scanner is closed after use.
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a sentence to validate:");
            String input = scanner.nextLine();

            // Call isValidSentence to determine if the input is a valid sentence.
            isValidSentence(input);

            // Output the result to the console.
            System.out.println(output);
        } catch (Exception e) {
            // Catch and display any exceptions that occur during input reading.
            System.out.println("An error occurred while reading input: " + e.getMessage());
        }
    }

    /**
     * Validates a sentence according to predefined rules.
     *
     * @param sentence The sentence to validate.
     * @return boolean true if the sentence is valid, false otherwise.
     */
    public static boolean isValidSentence(String sentence) {
        // Check for null or empty sentences after trimming whitespace.
        if (sentence == null || sentence.trim().isEmpty()) {
            output = "String cannot be null or empty.";
            return false;
        }

        // The sentence must start with an uppercase letter.
        if (!Character.isUpperCase(sentence.charAt(0))) {
            output = "String must start with an uppercase letter.";
            return false;
        }

        // The sentence must end with a period, exclamation mark, or question mark.
        char lastChar = sentence.charAt(sentence.length() - 1);
        if (lastChar != '.' && lastChar != '?' && lastChar != '!') {
            output = "String must end with a period, exclamation mark, or question mark.";
            return false;
        }

        // Remove the sentence termination character from the string.
        sentence = sentence.substring(0, sentence.length() - 1);

        // The sentence must contain an even number of quotation marks.
        if (!hasEvenQuotes(sentence)) {
            output = "String must contain an even number of quotation marks.";
            return false;
        }

        // The sentence must not contain any periods other than the last character.
        if(sentence.contains(".")) {
            output = "String must not contain any periods other than the last character.";
            return false;
        }

        // The sentence must spell out numbers below 13.
        if (!hasValidNumbers(sentence)) {
            output = "String must spell out numbers below 13.";
            return false;
        }
        else {
            output = "The String is valid";
            return true;
        }
    }

    /**
     * Checks if a sentence contains an even number of quotation marks.
     *
     * @param sentence The sentence to check.
     * @return boolean true if the number of quotes is even, false otherwise.
     */
    private static boolean hasEvenQuotes(String sentence) {
        long quotesCount = sentence.chars().filter(ch -> ch == '\"').count();
        return quotesCount % 2 == 0;
    }

    /**
     * Checks if all numbers in a sentence are valid according to the rule.
     * Numbers must be 13 or higher, as lower numbers should be spelled out.
     *
     * @param sentence The sentence to check.
     * @return boolean true if all numbers are valid, false if any are invalid.
     */
    private static boolean hasValidNumbers(String sentence) {
        Matcher matcher = NUMBER_PATTERN.matcher(sentence);
        while (matcher.find()) {
            String numberStr = matcher.group();
            if (!isNumberAboveTwelve(numberStr)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Determines if a string represents a number that is 13 or higher.
     *
     * @param numberStr The string to check.
     * @return boolean true if the string represents a number 13 or higher, false otherwise.
     */
    private static boolean isNumberAboveTwelve(String numberStr) {
        try {
            int number = Integer.parseInt(numberStr);
            return number >= 13;
        } catch (NumberFormatException e) {
            // If parsing fails, the string is not a valid number representation.
            return false;
        }
    }
}

