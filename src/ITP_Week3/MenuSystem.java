package ITP_Week3;

import java.util.Scanner;

public class MenuSystem {
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

        //Menu Addition
        System.out.println("In this programme you have 4 choices:\n" +
                "Option 1: See your full name \n" +
                "Option 2: Remember where you work\n" +
                "Option 3: See how many years you have left until retirement\n" +
                "Option 4: Hear some personalised words of encouragement");

        int option = scanner.nextInt();
        switch (option){
            case 1 : System.out.printf("Great job, you have selected the first option.\n" +
                    "Your name is %s %s." , firstName, surname);
                break;
            case 2 : System.out.printf("Great job %s, you have selected the second option.\n" +
                    "You work at %s." ,firstName, companyName);
                break;
            case 3 : System.out.printf("Great job %s, you have selected the third option.\n" +
                    "Most people work for 35 years, so you have %d to go." ,firstName, (35 - yearsAtCompany));
                break;
            case 4 : System.out.printf("Great job %s, you have selected the third option.\n" +
                    "You can sleep when you are dead, which isn't yet." ,firstName);
                break;
        }
        System.out.println("The programme will exit now. Goodbye!");


        scanner.close();

    }
}
