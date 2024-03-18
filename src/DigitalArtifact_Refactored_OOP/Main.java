package DigitalArtifact_Refactored_OOP;

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

public class Main {


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
        Main.personalDetailsCaptureFirstName();
        Main.personalDetailsCaptureSurname();
        Main.personalDetailsCaptureFirstLine();
        Main.personalDetailsCapturePostCode();
        Main.personalDetailsCaptureYearsAtAddress();

        //Menu Selection via switch statement
        Main.personalDetailsCaptureSummary();
        personalDetailsCycleOnce = true;
        //TimeUnit.SECONDS.sleep(3);
        do {
            Main.customerDetailsEditMenu();
            //TimeUnit.SECONDS.sleep(2);
            Main.customerDetailsEditSelector();
            //TimeUnit.SECONDS.sleep(1);
            Main.personalDetailsCaptureSummary();
        } while (menuOption != 7);
        Main.scannerFlush();

        //Transitional Message
        System.out.printf("""
                Great, thanks %s. In order to give you a quote for your home insurance, we need some more information.
                We need to know about the cover you would like to take to cover %s, %s.
                """, firstName, addressFirstLine, addressPostCode);

        // Collection methods. Reusable if details incorrect.
        Main.propertyDetailsCaptureHomeValue();
        Main.propertyDetailsCaptureBuildingsLimit();
        Main.propertyDetailsCaptureContentsLimit();
        Main.propertyDetailsCaptureSubsidenceIndicator();
        Main.propertyDetailsCaptureClaimsIndicator();
        Main.propertyDetailsCaptureSmokersIndicator();

        //Menu Selection via switch statement
        Main.propertyDetailsCaptureSummary();
        propertyDetailsCycleOnce = true;
        //TimeUnit.SECONDS.sleep(3);
        do {
            Main.propertyDetailsEditMenu();
            //TimeUnit.SECONDS.sleep(1);
            Main.propertyDetailsEditSelector();
            //TimeUnit.SECONDS.sleep(3);
            Main.propertyDetailsCaptureSummary();
        } while (menuOption != 7);
        Main.scannerFlush();

        //Quote or Decline based on user inputs
        //Decline and End check. "Business Rules" validation step.
        Main.preKickOutDoubleCheck();
        Main.setCombinedInd();
        Main.validateCombinedInd();

        //Continue to Quote
        Main.pricingAlgo();
        System.out.printf("The price we can offer is %f", customerPrice);
        // 3rd menu for accept, change property, change personal, exit, save???

        //End of Journey
        System.out.println("The programme will exit now. Goodbye!");
        scanner.close();
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
            Main.scannerFlush();
            String valuePreConversion = scanner.nextLine();
            inRangeInd = Main.validatedOutputToIndicator(valuePreConversion);
            if (inRangeInd == 1) {
                Main.kickOutAction();
                System.out.println("""
                        What is the current value of your home?
                        We only insure homes with a value between 50 thousand and 2 million.
                        """);
                homeValue = scanner.nextInt();
                Main.scannerFlush();
            }

        }
        System.out.println();
    }

    public static void propertyDetailsCaptureBuildingsLimit() {
        System.out.println("""
                Do you need to insure your building?
                (Y/N)
                """);
        Main.scannerFlush();
        String buildingsPreConversion = scanner.nextLine();
        buildingsInd = Main.validatedOutputToIndicator(buildingsPreConversion);
        if (buildingsInd == 1) {
            System.out.println("How much would you like to insure your home for, including rebuild costs?");
            buildingsLimit = scanner.nextInt();
            //Iteration: added if statement and new variable to ensure this step is run 1st time as its required, on subsequent runs - not needed
            Main.scannerFlush();
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
        Main.scannerFlush();
        String contentsPreConversion = scanner.nextLine();
        contentsInd = Main.validatedOutputToIndicator(contentsPreConversion);
        if (contentsInd == 1) {
            System.out.println("""
                    How much would you like to insure the contents in your home for?
                    """);
            contentsLimit = scanner.nextInt();
            Main.scannerFlush();
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
        claimsIndicator = Main.validatedOutputToIndicator(claimsPreConversion);
        if (claimsIndicator != 0) {
            //Only run the capture of number of claims when claims have been made in the last 5 years. "Business Rule" not consider older.
            Main.propertyDetailsCaptureClaimsVolume();
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
        Main.scannerFlush();
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
        Main.scannerFlush();
        subsidenceIndicator = Main.validatedOutputToIndicator(subsidencePreConversion);
        System.out.println();
    }

    public static void propertyDetailsCaptureSmokersIndicator() {
        System.out.printf("""
                Is %s a smoker?
                Confirm (Y/N)
                """, firstName);
        String smokerPreConversion = scanner.nextLine();
        smokersIndicator = Main.validatedOutputToIndicator(smokerPreConversion);
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
        //TimeUnit.SECONDS.sleep(3);
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
            Main.scannerFlush();
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
                Main.scannerFlush();
                Main.propertyDetailsCaptureHomeValue();
                break;
            case 2:
                Main.scannerFlush();
                Main.propertyDetailsCaptureBuildingsLimit();
                break;
            case 3:
                Main.scannerFlush();
                Main.propertyDetailsCaptureContentsLimit();
                break;
            case 4:
                Main.scannerFlush();
                Main.propertyDetailsCaptureSubsidenceIndicator();
                break;
            case 5:
                Main.scannerFlush();
                Main.propertyDetailsCaptureClaimsIndicator();
                break;
            case 6:
                Main.scannerFlush();
                Main.propertyDetailsCaptureSmokersIndicator();
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
        Main.generateRiskDouble();
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


    /*public static int generateRiskInt(int min, int max) {
        // AKA getRandomInt_Between
        double generate = ((Math.random() * (max - min)) + min);
        return (int) generate;
    }*/

}
