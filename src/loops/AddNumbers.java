package loops;
import java.util.Scanner;

/*
Create a programme that will add 2 numbers together.
The user should be able to repeat this action until they indicate they are done.
 */

public class AddNumbers {

    public static void main(String[] args){


        // Initialise known variables
        int runAgain = 0;
        Scanner scanner = new Scanner(System.in);

        // Get input for unknown variables
        do{
            System.out.println("Input your first number");
            double number1 = scanner.nextDouble();
            System.out.println("Input your second number");
            double number2 = scanner.nextDouble();

            double sum = number1 + number2;
            System.out.println("The total number is " + sum);


            System.out.println("Would you like to start again? 1 for yes and 2 for no.");
            runAgain = scanner.nextInt();
        }while (runAgain == 1);
    }
}
