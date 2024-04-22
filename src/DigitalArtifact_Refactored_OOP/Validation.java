package DigitalArtifact_Refactored_OOP;

public class Validation {


    public static int validatedOutputToIndicator(String inputString) {
        // Validation -- Forces valid input and Converts Y/N to 1/0
        char inputChar;
        int generatedIndicator;

        inputString = inputString.toLowerCase();// Error handles for mismatched case
        // Validates user input is acceptable value
        while (!(inputString.equals("y") || inputString.equals("n") || inputString.equals("no") || inputString.equals("yes"))) {
            System.out.printf("""
                    "%s" is not a valid input.
                    Acceptable values are Y or N.
                    """, inputString);
            inputString = scanner.nextLine();
            inputString = inputString.toLowerCase();
        }
        inputChar = inputString.charAt(0);
        if (inputChar == 'y') {
            generatedIndicator = 1;
        } else {
            generatedIndicator = 0;
        }
        return generatedIndicator;
    }

    public static void scannerFlush(){
        while (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
}