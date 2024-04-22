package DigitalArtifact_Refactored2_OOP;

import java.util.Scanner;


public class Customer {

    private final Scanner scanner = new Scanner(System.in);
    private final int policyNumberMax = 999999999;
    private final int policyNumberMin = 100000000;
    private int policyNumber;
    private String firstName;
    private String surname;
    private Tier tier;
    private String tierSelected;


    // Default Run - Create a non-existent customer
    public Customer() {
    }


    // Retrieve existing customer
    public Customer(int polNum, String firstNam, String lastNam, String TSelect) {
        policyNumber = polNum;
        firstName = firstNam;
        surname = lastNam;
        tierSelected = TSelect;
    }

    public int getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(int policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTierSelected() {
        return tierSelected;
    }

    public void setTierSelected(String tierSel) {
        this.tierSelected = tierSel;
    }

    public void createPolicyRecord() {
        System.out.println("Before we start, lets collect some data about you.");
        System.out.println("What is your first name?");
        firstName = scanner.next();
        System.out.println("What is your surname?");
        surname = scanner.next();
        System.out.println("What Tier of cover do you require?");
        System.out.println("""
                All policies cover:
                Buildings for: fire, flood and storm damage
                Contents for : the same as buildings + theft and freezer food losses.
                """);
        System.out.println("""
                Bronze provides:                | Silver provides:              | Gold provides:
                Buildings Adds: Drain damage.   | Bronze and                    | Bronze, Silver and
                Contents Adds: Valuable items.  | Legal Expenses up to £50k.    | Home Emergencies up to £1k per claim.
                """);

        int _option;
        do { //Adding Do While loop to accepts valid actions only
            System.out.println("""
                    Which tier would you like?
                    1. Bronze, 2. Silver, 3. Gold
                    Input the corresponding integer.
                    """);
            _option = scanner.nextInt();
            if (!(_option > 0 && _option < 4)) {
                System.out.printf("""
                        %d is not a valid input.
                        Please select a valid integer from on screen.
                        """, _option);
            }
        } while (!(_option > 0 && _option < 4));

        switch (_option) {
            case 1:
                tier = new Tier_Bronze();
                tierSelected = "Bronze";
                break;
            case 2:
                tier = new Tier_Silver();
                tierSelected = "Silver";
                break;
            case 3:
                tier = new Tier_Gold();
                tierSelected = "Gold";
                break;
        }

        //Force policy number between parameter defined numbers
        policyNumber = (int) ((Math.random() * (policyNumberMax - policyNumberMin)) + policyNumberMin);

        System.out.printf("""
                Policy has been created successfully.
                Associated to customer: %s %s.
                Your reference number is %d.
                You have selected tier: %s
                """, firstName, surname, policyNumber, tierSelected);

        WriteFile.writeCustomerFile(this);
    }

    public void customerInformation() {
        System.out.println("Policy Number: " + policyNumber);
        System.out.println("First Name: " + firstName);
        System.out.println("Surname: " + surname);
        System.out.println("Tier: " + tierSelected);
    }
}
