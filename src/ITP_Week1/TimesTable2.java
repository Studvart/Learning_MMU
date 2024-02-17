package ITP_Week1;

import java.util.Scanner;

public class TimesTable2 {
    public static void main(String[] args) {
        System.out.println("Key the first number to multiply...");
        Scanner scanner1 = new Scanner(System.in);
        int userInputNumber1 = scanner1.nextInt();
        System.out.println("Key the second number to multiply...");
        Scanner scanner2 = new Scanner(System.in);
        int userInputNumber2 = scanner2.nextInt();

        System.out.println("Your sum is " + userInputNumber1 + " multiplied by " + userInputNumber2 + " which equals " + (userInputNumber1 * userInputNumber2));

    }
}