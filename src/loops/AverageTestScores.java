package loops;

import java.awt.desktop.SystemEventListener;
import java.util.Scanner;

/*
 * NESTED LOOPS:
 * Find the average of each student's test scores
 */
public class AverageTestScores {

    public static void main(String[] args){

        //Initialize what we know
        int numberOfStudents = 24;
        int numberOfTests = 4;

        Scanner scanner = new Scanner(System.in);
        for(int i=0; i<numberOfStudents; i++){
            double total = 0;

            // Process a students test scores
            for(int j=0; j<numberOfTests; j++){
                System.out.println("Enter the test score for test #" + (j+1)); // Increment j by an extra 1 to be aligned.
                double score = scanner.nextDouble(); // Create a variable to capture the input score
                total = total + score;
            }
            double average = total/numberOfTests;
            System.out.println("The average score for student #" + (i+1) + " is " + average);
        }
        scanner.close();
    }
}