package loops;
import java.util.Scanner;
// PROBLEM: Each employee makes £15 an hour. Write a programme to calculate pay for employees
// but constrain to not allow overtime.
public class GrossPayInputValidator {

    public static void main(String[] args){

        // Initialise known variables
        int payRate = 15;
        int maxHours = 40;

        // Get input for unknown variables
        System.out.println("How many hours has employee worked?");
        Scanner scanner = new Scanner(System.in); // Asking for input from user
        double hoursWorked = scanner.nextDouble(); // Creating variable to store input value

        // Validate that maxHours not exceeded.
        // Validated here to ensure loop is not exit-ed ahead of a valid value being captured
        while(hoursWorked > maxHours){
            System.out.println("Invalid entry, your hours mus be between 1-40. Try again.");
            hoursWorked = scanner.nextDouble(); // Updating value from user with newly requested input value.
            // This new value us submitted against the while condition again to determine remaining in the loop.

        }

        scanner.close();

        // Calculate Gross
        Double gross = payRate * hoursWorked;
        System.out.println("Gross pay is £" + gross);


    }

}
