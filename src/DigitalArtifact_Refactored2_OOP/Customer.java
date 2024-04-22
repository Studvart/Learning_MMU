package DigitalArtifact_Refactored2_OOP;

import java.util.Scanner;


public class Customer {

    private final Scanner scanner = new Scanner(System.in);
    private final int policyNumberMax = 999999999;
    private final int policyNumberMin = 100000000;
    private int policyNumber;
    private String firstName;
    private String surname;
    private String tier;


    // Default Run - Create a non-existent customer
    public Customer() {


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

    public void createPolicyRecord() {
        System.out.println("Before we start, lets collect some data about you.");
        System.out.println("What is your first name?");
        firstName = scanner.next();
        System.out.println("What is your surname?");
        surname = scanner.next();
        System.out.println("What Tier of cover do you want?");
        /*
        Tier tierSelect = new Tier();
        tierSelect.benefits();
        System.out.println(Tier_Gold.benefits());*/
        tier = scanner.next();

        //Force policy number between parameter defined numbers
        policyNumber = (int) ((Math.random() * (policyNumberMax - policyNumberMin)) + policyNumberMin);

        System.out.printf("""
                Policy has been created successfully.
                Associated to customer: %s %s.
                Your reference number is %d.
                You have selected tier: %s
                """, firstName, surname, policyNumber, tier);

        WriteFile.writeCustomerFile(this);
    }

    public void customerInformation() {
        System.out.println("Policy Number: " + policyNumber);
        System.out.println("First Name: " + firstName);
        System.out.println("Surname: " + surname);
        System.out.println("Tier: " + tier);
    }

    // Retrieve existing customer
    public Customer(int polNum, String firstNam, String lastNam, String TSelect) {
        policyNumber = polNum;
        firstName = firstNam;
        surname = lastNam;
        tier = TSelect;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }
}
