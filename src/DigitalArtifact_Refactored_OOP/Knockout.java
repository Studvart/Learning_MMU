package DigitalArtifact_Refactored_OOP;

public class Knockout {

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
            if (Main.validatedOutputToIndicator(preValidate) == 1) {
                combinedInd = -1;
                Main.kickOutAction();
            } else {
                System.out.println("""
                        Ok, we will re-ask both questions to collect the correct data.
                        """);
                Main.propertyDetailsCaptureBuildingsLimit();
                Main.propertyDetailsCaptureContentsLimit();
                Main.setCombinedInd();
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
                if (Main.validatedOutputToIndicator(preValidate) == 1) {
                    Main.kickOutAction();
                }
            } else if (subsidenceIndicator == 0 && claimsVolume >= 3) {
                System.out.println("""
                        Please can we confirm that:
                        - You have previously made 3 or more home insurance claims
                        Confirm (Y/N)
                        """);
                String preValidate = scanner.nextLine();
                if (Main.validatedOutputToIndicator(preValidate) == 1) {
                    Main.kickOutAction();
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
                if (Main.validatedOutputToIndicator(preValidate) == 1) {
                    Main.kickOutAction();
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
}
