package DigitalArtifact;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
/*
What is the purpose of your use case? -- Home Insurance Price Journey Simulator
How is your use case personalised to you? -- Facilitates thinking of all the smaller parts of our full journey to appreciate moving parts.
What information does your use case need to collect from the user? -- Personal, property and cover related details.
What methods will you provide on the collected data? -- Methods to confirm:
 - validation
 - collect data // re-run as required
 - menu selection
 - play back data to user
 - pricing based on collected factors
*/

public class RemovingRepetition {

    public static Scanner scanner = new Scanner(System.in);
    public static String firstName = "";
    public static String surname = "";
    public static String addressFirstLine = "";
    public static String addressPostCode = "";
    public static int yearsAtAddress = 0;
    public static int menuOption = 0;
    public static int buildingsLimit = 0;
    public static int buildingsInd = 0;
    public static int homeValue = 0;
    public static int contentsLimit = 0;
    public static int contentsInd = 0;
    public static int claimsIndicator = 0;
    public static int claimsVolume = 0;
    public static int subsidenceIndicator = 0;
    public static int smokersIndicator = 0;
    public static int combinedInd = 0;
    public static double anchorRiskDouble = 0.00;
    public static double anchorMinContentsOnlyPremium = 50.00; //Business Rule
    public static double anchorMinBuildingsOnlyPremium = 100.00; //Business Rule
    public static double anchorMinCombinedPremium = 120.00; //Business Rule - 0.8 modifier for combined
    public static double anchorMaxPremium = 1200.00; //Business Rule
    public static double customerPrice = 0.00;
    public static boolean personalDetailsCycleOnce = false;
    public static boolean propertyDetailsCycleOnce = false;


    public static void main(String[] args) throws InterruptedException {
        System.out.println("""
                Hello and welcome to the programme. Before we start, lets collect some data about you.
                """);

        // Collection methods. Reusable if details incorrect.
        RemovingRepetition.personalDetailsCaptureFirstName();
        RemovingRepetition.personalDetailsCaptureSurname();
        RemovingRepetition.personalDetailsCaptureFirstLine();
        RemovingRepetition.personalDetailsCapturePostCode();
        RemovingRepetition.personalDetailsCaptureYearsAtAddress();

        //Menu Selection via switch statement
        RemovingRepetition.personalDetailsCaptureSummary();
        personalDetailsCycleOnce = true;
        TimeUnit.SECONDS.sleep(3);
        do {
            RemovingRepetition.customerDetailsEditMenu();
            TimeUnit.SECONDS.sleep(2);
            RemovingRepetition.customerDetailsEditSelector();
            TimeUnit.SECONDS.sleep(1);
            RemovingRepetition.personalDetailsCaptureSummary();
        } while (menuOption != 7);
        RemovingRepetition.scannerFlush();

        //Transitional Message
        System.out.printf("""
                Great, thanks %s. In order to give you a quote for your home insurance, we need some more information.
                We need to know about the cover you would like to take to cover %s, %s.
                """, firstName, addressFirstLine, addressPostCode);

        // Collection methods. Reusable if details incorrect.
        RemovingRepetition.propertyDetailsCaptureHomeValue();
        RemovingRepetition.propertyDetailsCaptureBuildingsLimit();
        RemovingRepetition.propertyDetailsCaptureContentsLimit();
        RemovingRepetition.propertyDetailsCaptureSubsidenceIndicator();
        RemovingRepetition.propertyDetailsCaptureClaimsIndicator();
        RemovingRepetition.propertyDetailsCaptureSmokersIndicator();

        //Menu Selection via switch statement
        RemovingRepetition.propertyDetailsCaptureSummary();
        propertyDetailsCycleOnce = true;
        TimeUnit.SECONDS.sleep(3);
        do {
            RemovingRepetition.propertyDetailsEditMenu();
            TimeUnit.SECONDS.sleep(1);
            RemovingRepetition.propertyDetailsEditSelector();
            TimeUnit.SECONDS.sleep(3);
            RemovingRepetition.propertyDetailsCaptureSummary();
        } while (menuOption != 7);
        RemovingRepetition.scannerFlush();

        //Quote or Decline based on user inputs
        //Decline and End check. "Business Rules" validation step.
        RemovingRepetition.preKickOutDoubleCheck();
        RemovingRepetition.setCombinedInd();
        RemovingRepetition.validateCombinedInd();

        //Continue to Quote
        RemovingRepetition.pricingAlgo();
        System.out.printf("The price we can offer is %f", customerPrice);
        // 3rd menu for accept, change property, change personal, exit, save???

        //End of Journey
        System.out.println("The programme will exit now. Goodbye!");
        scanner.close();
    }

    // Customer Detail Capture \\
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
        System.out.printf("""
                How many years have you lived at %s, %s?
                """, addressFirstLine, addressPostCode);
        yearsAtAddress = scanner.nextInt();
        //RemovingRepetition.scannerFlush();
        System.out.println();
    }

    // Customer Recap, Menu and Edit \\
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

        do {
            //Adding Do While loop to accept valid actions only
            System.out.println("Enter a number from those on screen to continue.");
            menuOption = scanner.nextInt();
            RemovingRepetition.scannerFlush();
            System.out.println();
            if (!(menuOption > 0 && menuOption < 8)) {
                System.out.printf("%d is not a valid input.\n", menuOption);
            }
        } while (!(menuOption > 0 && menuOption < 8));
        //Menu Selection
        switch (menuOption) {
            case 1:
                RemovingRepetition.scannerFlush();
                RemovingRepetition.personalDetailsCaptureFirstName();
                break;
            case 2:
                RemovingRepetition.scannerFlush();
                RemovingRepetition.personalDetailsCaptureSurname();
                break;
            case 3:
                RemovingRepetition.scannerFlush();
                RemovingRepetition.personalDetailsCaptureFirstLine();
                break;
            case 4:
                RemovingRepetition.scannerFlush();
                RemovingRepetition.personalDetailsCapturePostCode();
                break;
            case 5:
                RemovingRepetition.scannerFlush();
                RemovingRepetition.personalDetailsCaptureYearsAtAddress();
                break;
            case 6:
                System.out.printf("""
                        %s, you can sleep when you are dead, which isn't yet.
                        """, firstName);
                break;
            case 7:
                RemovingRepetition.scannerFlush();
                break;
        }
    }

    // Property Detail Capture \\
    public static void propertyDetailsCaptureHomeValue() {
        int inRangeInd = 0;
        while (homeValue < 50000 || homeValue > 2000000) {
            System.out.println(""" 
                    We only insure homes with a value between 50 thousand and 2 million.
                    Is your property valued in this range?
                    (Y/N)
                    """);
            RemovingRepetition.scannerFlush();
            String valuePreConversion = scanner.nextLine();
            inRangeInd = RemovingRepetition.validatedOutputToIndicator(valuePreConversion);
            if (inRangeInd == 1) {
                RemovingRepetition.kickOutAction();
                System.out.println("""
                        What is the current value of your home?
                        We only insure homes with a value between 50 thousand and 2 million.
                        """);
                homeValue = scanner.nextInt();
                RemovingRepetition.scannerFlush();
            }

        }
        System.out.println();
    }

    public static void propertyDetailsCaptureBuildingsLimit() {
        System.out.println("""
                Do you need to insure your building?
                (Y/N)
                """);
        RemovingRepetition.scannerFlush();
        String buildingsPreConversion = scanner.nextLine();
        buildingsInd = RemovingRepetition.validatedOutputToIndicator(buildingsPreConversion);
        if (buildingsInd == 1) {
            System.out.println("How much would you like to insure your home for, including rebuild costs?");
            buildingsLimit = scanner.nextInt();
            //Iteration: added if statement and new variable to ensure this step is run 1st time as its required, on subsequent runs - not needed
            RemovingRepetition.scannerFlush();
            System.out.println();
        } else {
            System.out.println();
        }
    }

    public static void propertyDetailsCaptureContentsLimit() {
        System.out.println("""
                Do you need to insure your contents?
                (Y/N)
                """);
        RemovingRepetition.scannerFlush();
        String contentsPreConversion = scanner.nextLine();
        contentsInd = RemovingRepetition.validatedOutputToIndicator(contentsPreConversion);
        if (contentsInd == 1) {
            System.out.println("""
                    How much would you like to insure the contents in your home for?
                    """);
            contentsLimit = scanner.nextInt();
            RemovingRepetition.scannerFlush();
            System.out.println();
        } else {
            System.out.println();
        }
    }

    public static void propertyDetailsCaptureClaimsIndicator() {
        System.out.println("""
                Have you made any home insurance claims in the last 5 years?
                Confirm (Y/N)""");
        String claimsPreConversion = scanner.nextLine();
        claimsIndicator = RemovingRepetition.validatedOutputToIndicator(claimsPreConversion);
        if (claimsIndicator != 0) {
            //Only run the capture of number of claims when claims have been made in the last 5 years. "Business Rule" not consider older.
            RemovingRepetition.propertyDetailsCaptureClaimsVolume();
        } else {
            claimsVolume = 0;
        }
        System.out.println();
    }

    public static void propertyDetailsCaptureClaimsVolume() {
        System.out.println("How many home insurance claims have you made in the last 5 years?");
        //
        //if (propertyDetailsCycleOnce == false) {

        //}
        claimsVolume = scanner.nextInt();
        RemovingRepetition.scannerFlush();
        System.out.println();
    }

    public static void propertyDetailsCaptureSubsidenceIndicator() {
        System.out.printf("""
                Have you ever made a claim for subsidence whilst living at %s, %s?
                Confirm (Y/N)
                """, addressFirstLine, addressPostCode);
        // Iteration: added if statement and new variable to ensure this step is run 1st time as its required, on subsequent runs - not needed
        //if (propertyDetailsCycleOnce == false) {

        //}
        String subsidencePreConversion = scanner.nextLine();
        RemovingRepetition.scannerFlush();
        subsidenceIndicator = RemovingRepetition.validatedOutputToIndicator(subsidencePreConversion);
        System.out.println();
    }

    public static void propertyDetailsCaptureSmokersIndicator() {
        System.out.printf("""
                Is %s a smoker?
                Confirm (Y/N)
                """, firstName);
        String smokerPreConversion = scanner.nextLine();
        smokersIndicator = RemovingRepetition.validatedOutputToIndicator(smokerPreConversion);
        System.out.println();
    }

    // Property Recap, Menu and Edit \\
    public static void propertyDetailsCaptureSummary() throws InterruptedException {
        //Property Recap, Menu and Edit
        String buildingsTemp;
        if (buildingsInd == 0) {
            buildingsTemp = "You do not need to insure your building.";
        } else {
            buildingsTemp = "You need to insure your building up to " + buildingsLimit + ".";
        }
        String contentsTemp;
        if (contentsInd == 0) {
            contentsTemp = "You do not need to insure your building.";
        } else {
            contentsTemp = "You need to insure your building up to " + contentsLimit + ".";
        }
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
            claimsTemp = "You have made " + claimsVolume + " claims in the last 5 years.";
        }
        String smokersTemp;
        if (smokersIndicator == 0) {
            smokersTemp = "You are not a smoker.";
        } else {
            smokersTemp = "You are a smoker.";
        }
        System.out.printf("""
                We have captured the following details:
                Your home is worth %d.
                %s
                %s
                %s
                %s
                %s
                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
                """, homeValue, buildingsTemp, contentsTemp, subsidenceTemp, claimsTemp, smokersTemp);
        TimeUnit.SECONDS.sleep(3);
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
        do {
            //Adding Do While loop to accept valid actions only
            System.out.println("Enter a number from those on screen to continue.");
            menuOption = scanner.nextInt();
            RemovingRepetition.scannerFlush();
            System.out.println();
            if (!(menuOption > 0 && menuOption < 8)) {
                System.out.printf("""
                        %d is not a valid input.
                        """, menuOption);
            }
        } while (!(menuOption > 0 && menuOption < 8));
        //Menu Selection
        switch (menuOption) {
            //Run a specific Method dependent on what the user selection
            case 1:
                RemovingRepetition.scannerFlush();
                RemovingRepetition.propertyDetailsCaptureHomeValue();
                break;
            case 2:
                RemovingRepetition.scannerFlush();
                RemovingRepetition.propertyDetailsCaptureBuildingsLimit();
                break;
            case 3:
                RemovingRepetition.scannerFlush();
                RemovingRepetition.propertyDetailsCaptureContentsLimit();
                break;
            case 4:
                RemovingRepetition.scannerFlush();
                RemovingRepetition.propertyDetailsCaptureSubsidenceIndicator();
                break;
            case 5:
                RemovingRepetition.scannerFlush();
                RemovingRepetition.propertyDetailsCaptureClaimsIndicator();
                break;
            case 6:
                RemovingRepetition.scannerFlush();
                RemovingRepetition.propertyDetailsCaptureSmokersIndicator();
                break;
            case 7:
                break;
        }
    }

    // Pricing generation \\
    public static void generateRiskDouble() {
        //Create permanent value to represent "core risk premium". Modifiers will update this value.
        // AKA getRandomDouble_Between
        double max = anchorMaxPremium;
        double min;
        double generate = 0.00;
        double truncated;

        if (anchorRiskDouble != 0.00) {
            if (combinedInd == 2) {
                min = anchorMinCombinedPremium;
            } else if (buildingsInd == 1) {
                //Removed extra step, computation not required. (buildingsInd == 1 && contentsInd == 0)
                min = anchorMinBuildingsOnlyPremium;
            } else if (contentsInd == 1) {
                //Removed extra step, computation not required. (contentsInd == 1 && buildingsInd == 0)
                min = anchorMinContentsOnlyPremium;
            } else {
                min = anchorMinContentsOnlyPremium; //Business Rule for Min Min premium
            }

            generate = ((Math.random() * (max - min)) + min);
            if (generate >= 0) { //multiplication by 100 maintains 2 decimal place numbers. Subsequent division restores it as a double.
                truncated = Math.floor(generate * 100) / 100; //Rounds down to whole integer closer to 0
            } else {
                truncated = Math.ceil(generate * 100) / 100; //Rounds up to whole integer closer to 0
            }
            anchorRiskDouble = truncated; //Step stores the 1st value determined for re-use. In case of detail updates which change modifiers. Otherwise price will go all over the place.
        }


    }

    // INCOMPLETE *********************************************************************
    public static void pricingAlgo() {
        //Modify core risk premium that is fixed for customer quote.About which the selection modifiers adjust final price.
        RemovingRepetition.generateRiskDouble();
        double buildLimitMod = 0.00;
        double contLimitMod = 0.00;
        double homeValueMod = 0.00;
        double claimsVolumeMod = 0.00;
        double smokersIndMod = 0.00;

        if (buildingsLimit > 0 && buildingsLimit < 250000) {
            buildLimitMod = 0.0;
        } else if (buildingsLimit >= 250000 && buildingsLimit < 750000) {
            buildLimitMod = 0.2;
        } else if (buildingsLimit >= 750000 && buildingsLimit < 1250000) {
            buildLimitMod = 0.8;
        }

        if (contentsLimit > 0 && contentsLimit < 30000) {
            contLimitMod = 0.0;
        } else if (contentsLimit >= 30000 && contentsLimit < 55000) {
            contLimitMod = 0.2;
        } else if (contentsLimit >= 55000 && contentsLimit < 100000) {
            contLimitMod = 1.4;
        }

        if (homeValue > 0 && homeValue < 300000) {
            homeValueMod = 1;
        } else if (homeValue >= 300000 && homeValue < 650000) {
            homeValueMod = 1.1;
        } else if (homeValue >= 650000 && homeValue < 1250000) {
            homeValueMod = 1.3;
        }

        if (claimsIndicator == 0) {
            claimsVolumeMod = 0.0;
        } else if (claimsVolume == 1) {
            claimsVolumeMod = 0.4;
        } else if (claimsVolume >= 2 && claimsVolume >= 2) {
            claimsVolumeMod = 2.0;
        }

        if (smokersIndicator == 0) {
            smokersIndMod = 0.0;
        } else if (smokersIndicator > 0) {
            smokersIndMod = 0.6;
        }

        double buildLimitPrice = ((anchorRiskDouble * buildLimitMod) - anchorRiskDouble);
        double contLimitPrice = ((anchorRiskDouble * contLimitMod) - anchorRiskDouble);
        double homeValuePrice = ((anchorRiskDouble * homeValueMod) - anchorRiskDouble);
        double claimsVolumePrice = ((anchorRiskDouble * claimsVolumeMod) - anchorRiskDouble);
        double smokersIndPrice = ((anchorRiskDouble * smokersIndMod) - anchorRiskDouble);


        customerPrice = anchorRiskDouble + buildLimitPrice + contLimitPrice + homeValuePrice + claimsVolumePrice + smokersIndPrice;
    }

    // Validations \\
    public static void setCombinedInd() {
        combinedInd = buildingsInd + contentsInd;
    }

    public static void validateCombinedInd() {
        //Price
        while (combinedInd == 0) {
            System.out.println("""
                    You have told us that you:
                    DO NOT need cover for either of your buildings or contents.
                    Is that correct?
                    Confirm (Y/N).
                    """);
            String preValidate = scanner.nextLine();
            if (RemovingRepetition.validatedOutputToIndicator(preValidate) == 1) {
                combinedInd = -1;
                RemovingRepetition.kickOutAction();
            } else {
                System.out.println("""
                        Ok, we will re-ask both questions to collect the correct data.
                        """);
                RemovingRepetition.propertyDetailsCaptureBuildingsLimit();
                RemovingRepetition.propertyDetailsCaptureContentsLimit();
                RemovingRepetition.setCombinedInd();
            }
        }
    }

    //Business Rules \\
    public static void preKickOutDoubleCheck() {
        //Decline and End
        if (subsidenceIndicator == 1 || claimsVolume >= 3) {
            //Individual message presented dependent on factors captured from user.
            if (subsidenceIndicator == 1 && claimsVolume < 3) {
                System.out.printf("""
                        Please can we confirm that:
                        - You have previously suffered subsidence whilst living at:
                        %s, %s
                        Confirm (Y/N)
                        """, addressFirstLine, addressPostCode);
                String preValidate = scanner.nextLine();
                if (RemovingRepetition.validatedOutputToIndicator(preValidate) == 1) {
                    RemovingRepetition.kickOutAction();
                }
            } else if (subsidenceIndicator == 0 && claimsVolume >= 3) {
                System.out.println("""
                        Please can we confirm that:
                        - You have previously made 3 or more home insurance claims
                        Confirm (Y/N)
                        """);
                String preValidate = scanner.nextLine();
                if (RemovingRepetition.validatedOutputToIndicator(preValidate) == 1) {
                    RemovingRepetition.kickOutAction();
                }
            } else {
                System.out.printf("""
                        Please can we confirm that:
                        - You have previously made 3 or more home insurance claims
                        - You have previously suffered subsidence whilst living at:
                        %s, %s
                        Confirm (Y/N)
                        """, addressFirstLine, addressPostCode);
                String preValidate = scanner.nextLine();
                if (RemovingRepetition.validatedOutputToIndicator(preValidate) == 1) {
                    RemovingRepetition.kickOutAction();
                }
            }
        }
    }

    public static void kickOutAction() {
        //Used to end the programme. Usually due to being outside simulated "business" rules.
        System.out.printf("""
                We are really sorry %s, we are unable to provide you a quote at this time.
                We hope you find alternative arrangements for %s, %s.
                Please consider us again in the future.
                """, firstName, addressFirstLine, addressPostCode);
        System.exit(0); //End Programme
    }


    /*public static int generateRiskInt(int min, int max) {
        // AKA getRandomInt_Between
        double generate = ((Math.random() * (max - min)) + min);
        return (int) generate;
    }*/

    public static int validatedOutputToIndicator(String inputString) {
        // Validation -- Forces valid input and Converts Y/N to 1/0
        char inputChar;
        int generatedIndicator;

        inputString = inputString.toLowerCase();// Error handles for mismatched case
        // Validates user input is acceptable value
        while (!(inputString.equals("y") || inputString.equals("n") || inputString.equals("no") || inputString.equals("yes"))) {
            System.out.printf("""
                    "%s" is not a valid input.
                    Acceptable values are Y or N.
                    """, inputString);
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

    public static void scannerFlush(){
        while (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
}
