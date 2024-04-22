package DigitalArtifact_Refactored_OOP;

import java.util.Scanner;

public class PersonalDetails {

    private Scanner _scanner = new Scanner(System.in);
    private String _firstName = "";
    private String _surname = "";
    private String _addressFirstLine = "";
    private String _addressPostCode = "";
    private int _yearsAtAddress = 0;
    private int _menuOption = 0;

    // Customer Detail Capture \\
    public  void personalDetailsCaptureFirstName() {
        System.out.println("What is your first name?");
        _firstName = _scanner.nextLine();
        System.out.println();
    }

    public  void personalDetailsCaptureSurname() {
        System.out.println("What is your surname?");
        _surname = _scanner.nextLine();
        System.out.println();
    }

    public  void personalDetailsCaptureFirstLine() {
        System.out.println("What is the first line of your address?");
        _addressFirstLine = _scanner.nextLine();
        System.out.println();
    }

    public  void personalDetailsCapturePostCode() {
        System.out.println("What is the postcode of your address?");
        _addressPostCode = _scanner.nextLine();
        System.out.println();
    }

    public  void personalDetailsCaptureYearsAtAddress() {
        System.out.printf("""
                How many years have you lived at %s, %s?
                """, _addressFirstLine, _addressPostCode);
        _yearsAtAddress = _scanner.nextInt();
        //RemovingRepetition._scannerFlush();
        System.out.println();
    }

    // Customer Recap, Menu and Edit \\
    public  void personalDetailsCaptureSummary() throws InterruptedException {
        System.out.printf("""
                We have captured the following details:
                Your name is %s %s.
                You live at %s, %s
                You have been there for %d years.
                                
                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
                """, _firstName, _surname, _addressFirstLine, _addressPostCode, _yearsAtAddress);
        //TimeUnit.SECONDS.sleep(3);
    }

    public  void customerDetailsEditMenu() {
        // Considered individual options for first and _surnames and address fields.
        // Made menu too long for user. Could consider inner loop to offer updating one, both, neither.
        System.out.println("""
                Review the above details. If any are incorrect you can amend via the following options:
                Option 1: Amend your first name
                Option 2: Amend your _surname
                Option 3: Amend your address - first line
                Option 4: Amend your address - postcode
                Option 5: Amend how many years you have lived at your home
                Option 6: Hear some personalised words of encouragement
                Option 7: Enter the quote process
                """);
    }

    public  void customerDetailsEditSelector() {

        do {
            //Adding Do While loop to accept valid actions only
            System.out.println("Enter a number from those on screen to continue.");
            _menuOption = _scanner.nextInt();
            Main._scannerFlush();
            System.out.println();
            if (!(_menuOption > 0 && _menuOption < 8)) {
                System.out.printf("%d is not a valid input.\n", _menuOption);
            }
        } while (!(_menuOption > 0 && _menuOption < 8));
        //Menu Selection
        switch (_menuOption) {
            case 1:
                Main._scannerFlush();
                Main.personalDetailsCaptureFirstName();
                break;
            case 2:
                Main._scannerFlush();
                Main.personalDetailsCaptureSurname();
                break;
            case 3:
                Main._scannerFlush();
                Main.personalDetailsCaptureFirstLine();
                break;
            case 4:
                Main._scannerFlush();
                Main.personalDetailsCapturePostCode();
                break;
            case 5:
                Main._scannerFlush();
                Main.personalDetailsCaptureYearsAtAddress();
                break;
            case 6:
                System.out.printf("""
                        %s, you can sleep when you are dead, which isn't yet.
                        """, _firstName);
                break;
            case 7:
                Main._scannerFlush();
                break;
        }
    }
}