package DigitalArtifact;

import java.util.Scanner;

public class MenuSystemLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello and welcome to the programme. Before we start, lets collect some data about you.");
        System.out.println("What is your first name?");
        String firstName = scanner.next();
        System.out.println("What is your surname?");
        String surname = scanner.next();
        System.out.println("Where do you work?");
        String companyName = scanner.next();
        System.out.println("How many years have you worked for " + companyName + "?");
        int yearsAtCompany = scanner.nextInt();
        System.out.println("Ok, all information has been gathered.");
        System.out.printf("Welcome to the programme %s %s. Congratulations on working\nfor %s for %d years.\nNow, let’s begin…", firstName, surname, companyName, yearsAtCompany);

        //Menu Selection via switch statement
        System.out.println("""
                In this programme you have 4 choices:
                Option 1: See your full name\s
                Option 2: Remember where you work
                Option 3: See how many years you have left until retirement
                Option 4: Hear some personalised words of encouragement""");

        int option;

        String optionContinue;
        do {
            do { //Adding Do While loop to accept valid actions only
                System.out.println("Enter a number from those on screen to continue.");
                option = scanner.nextInt();
                if (!(option > 0 && option < 5)) {
                    System.out.printf("%d is not a valid input.\n", option);
                }
            } while (!(option > 0 && option < 5));

            switch (option) {
                case 1:
                    System.out.printf("""
                            Great job, you have selected the first option.
                            Your name is %s %s.
                            """, firstName, surname);
                    break;
                case 2:
                    System.out.printf("""
                            Great job %s, you have selected the second option.
                            You work at %s.
                            """, firstName, companyName);
                    break;
                case 3:
                    System.out.printf("""
                            Great job %s, you have selected the third option.
                            Most people work for 35 years, so you have %d to go.
                            """, firstName, (35 - yearsAtCompany));
                    break;
                case 4:
                    System.out.printf("""
                            Great job %s, you have selected the third option.
                            You can sleep when you are dead, which isn't yet.
                            """, firstName);
                    break;

            }
            System.out.println("Do you want to continue? (Yes/No)");
            optionContinue = scanner.next();
            // Validates user input is acceptable value
            if (!(optionContinue.equals("Yes") || optionContinue.equals("No"))) {
                //Where invalid - offer opportunity to enter valid input
                System.out.printf("%s is not a valid input.\n", optionContinue);
                System.out.println("Do you want to continue? (Yes/No)");
                optionContinue = scanner.next();
            }
        } while (!(optionContinue.equals("No"))); //Break loop on Acceptable answer "No"

        System.out.println("The programme will exit now. Goodbye!");

        scanner.close();

    }
}
