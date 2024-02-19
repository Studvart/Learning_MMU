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
        int myInteger = scanner.nextInt();
        String myString = myInteger + "";
        int digit;
        int myNumberLength = myString.length();
        int myTotal = 0;

        for(int i = 0; i < myNumberLength; i++){
            digit = Integer.parseInt(myString.charAt(i) + "");
            myTotal = myTotal + digit;
        }

        int myProduct = 0;
        String myNumberAsString = myInteger + "";
        String myNumberLengthAsString = myInteger + "";

        System.out.printf("""
                            There are %d digits in this number.
                            The total of all digits is: %d.
                            The product of all digits is: %d.
                            This number in words is: %s.
                            The number is %s characters long.
                            """, myNumberLength, myTotal, myProduct, myNumberAsString, myNumberLengthAsString);

    }
}
