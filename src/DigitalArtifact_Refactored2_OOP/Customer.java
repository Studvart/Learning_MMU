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
        tierSelection();

        assignPolicyNumber();

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

    public void assignPolicyNumber() {
        //Force policy number between parameter defined numbers
        while (!(policyNumber > product.getPolicyNumberMin() && policyNumber < product.getPolicyNumberMax())) {
            policyNumber = (int) ((Math.random() * (product.getPolicyNumberMax() - product.getPolicyNumberMin())) + product.getPolicyNumberMin());
        }
    }

    public void tierSelection() {
        System.out.println("Here are our tiered options:");
        product.productBenefits();
        System.out.printf("%s%s%s", product.productBenefitsBronze(),product.productBenefitsSilver(),product.productBenefitsGold());

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
    }
}