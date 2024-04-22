package DigitalArtifact;

import java.util.Scanner;

public class GreetingPage {
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

        scanner.close();

    }
}
