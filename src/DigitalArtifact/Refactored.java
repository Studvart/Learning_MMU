package DigitalArtifact;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
// What is the purpose of your use case? Home Insurance Price Generator
// How is your use case personalised to you? Aligned to Role


public class Refactored {
    // What information does your use case need to collect from the user?


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

        Refactored.propertyDetailsCaptureHomeValue();
        Refactored.propertyDetailsCaptureBuildingsLimit();
        Refactored.propertyDetailsCaptureContentsLimit();
        Refactored.propertyDetailsCaptureSubsidenceIndicator();
        Refactored.propertyDetailsCaptureClaimsIndicator();
        Refactored.propertyDetailsCaptureSmokersIndicator();

        //Menu Selection via switch statement
        Refactored.propertyDetailsCaptureSummary();
        TimeUnit.SECONDS.sleep(3);
        do {
            Refactored.propertyDetailsEditMenu();
            TimeUnit.SECONDS.sleep(1);
            Refactored.propertyDetailsEditSelector();
            TimeUnit.SECONDS.sleep(3);
            Refactored.propertyDetailsCaptureSummary();
        } while (menuOption != 7);

        System.out.println("The programme will exit now. Goodbye!");

        scanner.close();

    }

    // What methods will you provide on the collected data?
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

    public static void propertyDetailsCaptureHomeValue() {
        System.out.println("What is the current value of your home?");
        homeValue = scanner.nextInt();
        System.out.println();
    }

    public static void propertyDetailsCaptureBuildingsLimit() {
        System.out.println("How much would you like to insure your home for, including rebuild costs?");
        buildingsLimit = scanner.nextInt();
        System.out.println();
    }

    public static void propertyDetailsCaptureContentsLimit() {
        System.out.println("How much would you like to insure the contents in your home for?");
        contentsLimit = scanner.nextInt();
        System.out.println();
    }

    public static void propertyDetailsCaptureClaimsIndicator() {

        System.out.println("Have you made any home insurance claims in the last 5 years? (Y/N)");
        String claimsPreConversion = scanner.nextLine();
        claimsIndicator = Refactored.validatedOutputToIndicator(claimsPreConversion);
        if (claimsIndicator != 0) {
            Refactored.propertyDetailsCaptureClaimsVolume();
        } else {
            claimsVolume = 0;
        }
        System.out.println();
    }

    public static void propertyDetailsCaptureClaimsVolume() {
        System.out.println("How many home insurance claims have you made in the last 5 years?");
        scanner.nextLine();
        claimsVolume = scanner.nextInt();
        System.out.println();
    }

    public static void propertyDetailsCaptureSubsidenceIndicator() {

        System.out.printf("Have you ever made a claim for subsidence whilst living at %s, %s? (Y/N)\n", addressFirstLine, addressPostCode);
        scanner.nextLine();
        String subsidencePreConversion = scanner.nextLine();
        subsidenceIndicator = Refactored.validatedOutputToIndicator(subsidencePreConversion);
        System.out.println();
    }

    public static void propertyDetailsCaptureSmokersIndicator() {

        System.out.printf("Is %s a smoker? (Y/N)\n", firstName);
        String smokerPreConversion = scanner.nextLine();
        smokersIndicator = Refactored.validatedOutputToIndicator(smokerPreConversion);
        System.out.println();
    }

    public static void propertyDetailsCaptureSummary() throws InterruptedException {
        String subsidenceTemp;
        if (subsidenceIndicator == 0) {
            subsidenceTemp = "You have never suffered subsidence.";
        } else {
            subsidenceTemp = "You have previously suffered subsidence.";
        }
        String claimsTemp;
        if (claimsIndicator == 0) {
            claimsTemp = "You have not made any claims in the last 5 years.";
        } else {
            claimsTemp = "You have made claim(s) in the last 5 years.";
        }
        String smokersTemp;
        if (smokersIndicator == 0) {
            smokersTemp = "You are not a smoker.";
        } else {
            smokersTemp = "You are a smoker.";
        }
        System.out.printf("""
                We have captured the following details:
                Your home is worth %d and you would like to be insured up to a rebuild cost of %d.
                Your contents will be insured up to %d.
                %s
                %s
                You have made %d claims.
                %s
                                
                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
                """, homeValue, buildingsLimit, contentsLimit, subsidenceTemp, claimsTemp, claimsVolume, smokersTemp);
        TimeUnit.SECONDS.sleep(3);
    }

    public static int validatedOutputToIndicator(String inputString) {
        char inputChar;
        int generatedIndicator;

        inputString = inputString.toLowerCase();// Error handles for mismatched case
        // Validates user input is acceptable value
        while (!(inputString.equals("yes") || inputString.equals("no") || inputString.equals("n") || inputString.equals("y"))) {
            System.out.printf("%s is not a valid input.\n", inputString);
            System.out.println("Acceptable values are Y or N");
            inputString = scanner.nextLine();
            inputString = inputString.toLowerCase();
        }
        inputChar = inputString.charAt(0);
        if (inputChar == 'y') {
            generatedIndicator = 1;
        } else {
            generatedIndicator = 0;
        }
        return generatedIndicator;
    }

    public static void propertyDetailsEditMenu() {
        // Considered individual options for first and surnames and address fields.
        // Made menu too long for user. Could consider inner loop to offer updating one, both, neither.
        System.out.println("""
                Review the above details. If any are incorrect you can amend via the following options:
                Option 1: Amend the value of your home
                Option 2: Amend the buildings sum insured you require
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
                Refactored.propertyDetailsCaptureHomeValue();
                break;
            case 2:
                scanner.nextLine();
                Refactored.propertyDetailsCaptureBuildingsLimit();
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
