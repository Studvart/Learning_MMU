package Challenge;

import java.util.Scanner;

public class NumberAnalysis {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
        • The number of digits in the number
        • The sum of all digits
        • The product of all digits
        • Each digit translated to it’s word form (i.e. 1 → one, 2 → two, 3 → three, etc.
        • The length of the word representation of the number
         */
        System.out.println("Input a number to learn information about it.");
        int myInteger = scanner.nextInt(); // Accept user input
        String myString = myInteger + ""; // Force integer to String
        int myTotal = 0; // Initialised variable to store total iteration value
        int digitTotal; // Initialised variable to store total calculation outside upcoming for loop
        int myProduct = 1; // Initialised variable to store product iteration value
        int digitProd; // Initialised variable to store product calculation outside upcoming for loop

        int myNumberLength = myString.length(); // Calculate integer length

        for (int i = 0; i < myNumberLength; i++) {
            digitTotal = Integer.parseInt(myString.charAt(i) + "");
            myTotal = myTotal + digitTotal;
        } // Calculate the total of all individual integers in the user supplied value

        for (int i = 0; i < myNumberLength; i++) {
            digitProd = Integer.parseInt(myString.charAt(i) + "");
            myProduct = myProduct * digitProd;
        } // Calculate the product of all individual integers in the user supplied value

        String myNumberAsString = convertToWords(myInteger); // Utilise subsequent created method to pass each individual int as string zero to nine
        String myNumberLengthAsString = myNumberAsString.length() + ""; // Pass full string length from function to calculate string length

        //
        System.out.printf("""
                There are %d digits in this number.
                The total of all digits is: %d.
                The product of all digits is: %d.
                This number in words is: %s.
                The number is %s characters long.
                """, myNumberLength, myTotal, myProduct, myNumberAsString, myNumberLengthAsString);
        // Text block mitigates need for seperate print lines or \n.
        // printf enables wildcard population to save on concatination.
    }

    private static String convertToWords(int number) {
        String[] digitWords = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        String result = "";
        int digit;
        int remainder = number;

        // Extract each digit and convert it the word representation
        while (remainder > 0) {
            digit = remainder % 10;
            result = digitWords[digit] + " " + result; // Prepend the word to the result
            remainder /= 10;
        }

        return result.trim(); // Trim to remove any leading/trailing spaces
    }
}
