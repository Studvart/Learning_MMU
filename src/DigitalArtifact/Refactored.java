package DigitalArtifact;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Refactored {
    // What is the purpose of your use case?
    // How is your use case personalised to you?
    // What information does your use case need to collect from the user?
    // What methods will you provide on the collected data?

    public static Scanner scanner = new Scanner(System.in);
    public static String firstName = "";
    public static String surname = "";
    public static String addressFirstLine = "";
    public static String addressPostCode = "";
    public static int yearsAtAddress = 0;
    public static int menuOption = 0;
    public static int buildingsLimit = 0;
    public static int homeValue = 0;
    public static int contentsLimit = 0;
    public static int claimsIndicator = 0;
    public static int claimsVolume = 0;
    public static int subsidenceIndicator = 0;
    public static int smokersIndicator = 0;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("""
                Hello and welcome to the programme. Before we start, lets collect some data about you.
                """);
        // Collection methods. Reusable if details incorrect.
        Refactored.personalDetailsCaptureFirstName();
        Refactored.personalDetailsCaptureSurname();
        Refactored.personalDetailsCaptureFirstLine();
        Refactored.personalDetailsCapturePostCode();
        Refactored.personalDetailsCaptureYearsAtAddress();

        //Menu Selection via switch statement
        Refactored.personalDetailsCaptureSummary();
        TimeUnit.SECONDS.sleep(3);
        do {
            Refactored.customerDetailsEditMenu();
            TimeUnit.SECONDS.sleep(1);
            Refactored.customerDetailsEditSelector();
            TimeUnit.SECONDS.sleep(3);
            Refactored.personalDetailsCaptureSummary();
        } while (menuOption != 7);

        System.out.printf("""
                Great, thanks %s. In order to give you a quote for your home insurance, we need some more information.
                We need to know about the cover you would like to take to cover %s, %s.
                """, firstName, addressFirstLine, addressPostCode);

        System.out.println("The programme will exit now. Goodbye!");

        scanner.close();

    }

    public static void personalDetailsCaptureFirstName() {
        System.out.println("What is your first name?");
        firstName = scanner.nextLine();
        System.out.println();
    }

    public static void personalDetailsCaptureSurname() {
        System.out.println("What is your surname?");
        surname = scanner.nextLine();
        System.out.println();
    }

    public static void personalDetailsCaptureFirstLine() {
        System.out.println("What is the first line of your address?");
        addressFirstLine = scanner.nextLine();
        System.out.println();
    }

    public static void personalDetailsCapturePostCode() {
        System.out.println("What is the postcode of your address?");
        addressPostCode = scanner.nextLine();
        System.out.println();
    }

    public static void personalDetailsCaptureYearsAtAddress() {
        System.out.printf("How many years have you lived at %s, %s?\n", addressFirstLine, addressPostCode);
        yearsAtAddress = scanner.nextInt();
        System.out.println();
    }

    public static void personalDetailsCaptureSummary() throws InterruptedException {
        System.out.printf("""
                We have captured the following details:
                Your name is %s %s.
                You live at %s, %s
                You have been there for %d years.
                                
                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
                """, firstName, surname, addressFirstLine, addressPostCode, yearsAtAddress);
        TimeUnit.SECONDS.sleep(3);
    }

    public static void customerDetailsEditMenu() {
        // Considered individual options for first and surnames and address fields.
        // Made menu too long for user. Could consider inner loop to offer updating one, both, neither.
        System.out.println("""
                Review the above details. If any are incorrect you can amend via the following options:
                                
                Option 1: Amend your first name
                Option 2: Amend your surname
                Option 3: Amend your address - first line
                Option 4: Amend your address - postcode
                Option 5: Amend how many years you have lived at your home
                Option 6: Hear some personalised words of encouragement
                Option 7: Enter the quote process
                """);
    }

    public static void customerDetailsEditSelector() {


        do { //Adding Do While loop to accept valid actions only
            System.out.println("Enter a number from those on screen to continue.");
            menuOption = scanner.nextInt();
            System.out.println();
            if (!(menuOption > 0 && menuOption < 8)) {
                System.out.printf("%d is not a valid input.\n", menuOption);
            }
        } while (!(menuOption > 0 && menuOption < 8));


        switch (menuOption) {
            case 1:
                scanner.nextLine();
                Refactored.personalDetailsCaptureFirstName();
                break;
            case 2:
                scanner.nextLine();
                Refactored.personalDetailsCaptureSurname();
                break;
            case 3:
                scanner.nextLine();
                Refactored.personalDetailsCaptureFirstLine();
                break;
            case 4:
                scanner.nextLine();
                Refactored.personalDetailsCapturePostCode();
                break;
            case 5:
                scanner.nextLine();
                Refactored.personalDetailsCaptureYearsAtAddress();
                break;
            case 6:
                System.out.printf("""
                        %s, you can sleep when you are dead, which isn't yet.
                                  
                        """, firstName);
                break;
            case 7:
                break;

        }

    }

    public static void propertyDetailsCaptureBuildingsLimit() {
        System.out.println("How much would you like to insure your home for, including rebuild costs?");
        buildingsLimit = scanner.nextInt();
        System.out.println();
    }

    public static void propertyDetailsCaptureContentsLimit() {
        System.out.println("How much would you like to insure your home for?");
        contentsLimit = scanner.nextInt();
        System.out.println();
    }

    public static void propertyDetailsCaptureHomeValue() {
        System.out.println("What is the current value of your home?");
        homeValue = scanner.nextInt();
        System.out.println();
    }

    public static void propertyDetailsCaptureClaimsIndicator() {
        System.out.println("Have you ?");
        claimsIndicator = scanner.nextInt();
        System.out.println();
    }

    public static void propertyDetailsCaptureClaimsVolume() {
        System.out.println("What is your surname?");
        claimsVolume = scanner.nextInt();
        System.out.println();
    }

    public static void propertyDetailsCaptureSubsidenceIndicator() {
        System.out.println("What is your surname?");
        subsidenceIndicator = scanner.nextInt();
        System.out.println();
    }

    public static void propertyDetailsCaptureSmokersIndicator() {
        System.out.println("What is your surname?");
        smokersIndicator = scanner.nextInt();
        System.out.println();
    }

    public static void propertyDetailsCaptureSummary() throws InterruptedException {
        System.out.printf("""
                We have captured the following details:
                Your home is worth %d and you would like to be insured up to a rebuild cost of %d.
                Your contents will be insured up to %d
                You have made %d claims.
                                
                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
                """, homeValue, buildingsLimit, contentsLimit, claimsVolume);
        TimeUnit.SECONDS.sleep(3);
    }

    public static void propertyDetailsEditMenu() {
        // Considered individual options for first and surnames and address fields.
        // Made menu too long for user. Could consider inner loop to offer updating one, both, neither.
        System.out.println("""
                Review the above details. If any are incorrect you can amend via the following options:
                                
                Option 1: Amend the buildings sum insured you require
                Option 2: Amend the value of your home
                Option 3: Amend the contents sum insured you require
                Option 4: Amend your historic subsidence status
                Option 5: Amend your claims status and number of claims
                Option 6: Amend your smoker status
                Option 7: Retrieve your price
                """);
    }

    public static void propertyDetailsEditSelector() {


        do { //Adding Do While loop to accept valid actions only
            System.out.println("Enter a number from those on screen to continue.");
            menuOption = scanner.nextInt();
            System.out.println();
            if (!(menuOption > 0 && menuOption < 8)) {
                System.out.printf("%d is not a valid input.\n", menuOption);
            }
        } while (!(menuOption > 0 && menuOption < 8));


        switch (menuOption) {
            case 1:
                scanner.nextLine();
                Refactored.propertyDetailsCaptureBuildingsLimit();
                break;
            case 2:
                scanner.nextLine();
                Refactored.propertyDetailsCaptureHomeValue();
                break;
            case 3:
                scanner.nextLine();
                Refactored.propertyDetailsCaptureContentsLimit();
                break;
            case 4:
                scanner.nextLine();
                Refactored.propertyDetailsCaptureSubsidenceIndicator();
                break;
            case 5:
                scanner.nextLine();
                Refactored.propertyDetailsCaptureClaimsIndicator();
                if (claimsIndicator != 0){

                }
                break;
            case 6:
                scanner.nextLine();
                Refactored.propertyDetailsCaptureSmokersIndicator();
                break;
            case 7:
                break;

        }

    }


}
