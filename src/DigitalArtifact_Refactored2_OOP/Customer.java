package DigitalArtifact_Refactored2_OOP;

import java.util.Scanner;


public class Customer {

    private final Scanner scanner = new Scanner(System.in);
    Product product = new Product();
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

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getTierSelected() {
        return tierSelected;
    }

    public void createPolicyRecord() {
        System.out.println("Before we start, lets collect some data about you.");
        System.out.println("What is your first name?");
        firstName = scanner.next();
        System.out.println("What is your surname?");
        surname = scanner.next();

        assignPolicyNumber();

        System.out.printf("""
                Policy has been created successfully.
                Associated to customer: %s %s.
                Your reference number is %d.
                """, firstName, surname, policyNumber);

        WriteFile.writeCustomerFile(this);
    }

    public void customerInformation() {
        System.out.println("Policy Number: " + policyNumber);
        System.out.println("First Name: " + firstName);
        System.out.println("Surname: " + surname);
    }

    public void assignPolicyNumber() {
        //Force policy number between parameter defined numbers
        while (!(policyNumber > product.getPolicyNumberMin() && policyNumber < product.getPolicyNumberMax())) {
            policyNumber = (int) ((Math.random() * (product.getPolicyNumberMax() - product.getPolicyNumberMin())) + product.getPolicyNumberMin());
        }
    }

}