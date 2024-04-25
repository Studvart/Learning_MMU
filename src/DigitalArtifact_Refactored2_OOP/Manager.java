package DigitalArtifact_Refactored2_OOP;

// Required packages to be present to run functions in this class.

import java.util.InputMismatchException;
import java.util.Scanner;

public class Manager {
    Scanner scanner = new Scanner(System.in);
    Product product = new Product();
    //Tier _appliedTier;

    public void processManager() {
        Customer customer = new Customer();
        Tier tier = new Tier();
        // Collect basic details
        customerRetrieveMenu();

        // Offer interaction with polymorphic options B/S/G
        tier = tier.returnTier();
        tier.accessRewards();

        // ******* Need Array idea ********
        // Customer satisfaction survey

        // ******* Testing scenarios required *******

        // End Process
        scanner.close();
        terminateProgramme();
    }

    public void customerRetrieveMenu() {
        while (true) {
            System.out.println("""
                    Hello and welcome to the programme.
                    Navigate using the following character options:
                    Option (O): Open a new policy
                    Option (V): View an existing policy
                    Option (E): Exit the programme
                    """);
            String option = scanner.nextLine().toLowerCase();

            if (option.equals("o")) {
                createNewCustomer();
            } else if (option.equals("v")) {
                retreiveExistingCustomer();
            } else if (option.equals("e")) {
                terminateProgramme();
            }

            System.out.println("""
                    Would you like to:
                    Navigate using the following character options:
                    Option (P): Proceed to the benefits of this policy
                    Option (C): Change the policy you are reviewing
                    Option (E): Exit the programme
                    """);
            String input = scanner.nextLine().toLowerCase();

            if (input.equals("e")) {
                terminateProgramme();
            } else if (input.equals("p")) {
                break;
            }
        }
    }

    // Repeatable class to terminate the programme when required.
    private void terminateProgramme() {
        System.out.println("Thank you for interacting with SAG Bank Insurance Services Limited.");
        // End Programme immediately.
        System.exit(1);
    }

    private void createNewCustomer() {
        Customer customer = new Customer();
        customer.createPolicyRecord();
    }

    private void retreiveExistingCustomer() {

        System.out.println("Please enter the policy number to review:");

        try {
            int policyNumber = scanner.nextInt();
            scanner.nextLine();

            product.checkPolicyNumber(policyNumber);

            Customer foundCustomer = ReadFile.accessPolicyData(policyNumber);
            foundCustomer.getTierSelected();

            if (foundCustomer == null) throw new InvalidPolicyNumberException("Account was not found", policyNumber);

            foundCustomer.customerInformation();
        } catch (InputMismatchException e) {
            System.err.println("Please enter a valid integer for the policy number.");
            scanner.nextLine();
        } catch (InvalidPolicyNumberException e) {
            System.err.println(e.getMessage());
        }
    }
}

