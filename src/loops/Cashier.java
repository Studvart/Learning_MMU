package loops;

/*
 * FOR LOOP: // For loops run a specified number of times.
 * //////////// It is important to know this number when constructing the loop.
 * Write a cashier program that will scan a given number of items and tally the cost.
 */

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

public class Cashier {

    public static void main(String[] args){

        //Get number of items to scan
        System.out.println("Enter the number of items you would you like to scan:");
        Scanner scanner = new Scanner(System.in); // Setup variable to store number of loop repeats.

        int quantity = scanner.nextInt(); // Collect the number of times the loop should run.

        double total = 0;

        //Create loop to iterate through all of the items and accumulate the costs
        for(int i=0; i<quantity; i++){
            // Shorthand "i" is acceptable to indicate increment in Java. Condition to maintain loop. increment by 1.
            System.out.println("Value of Item?");
            double price = scanner.nextDouble(); // Setup variable to store value of item sold.

            total = total + price; // Update/repalce old value of variable containing total,
                                   // summing old total and new item cost.
        }

        scanner.close();
        System.out.println("Your total is £"+ total);

    }
}
