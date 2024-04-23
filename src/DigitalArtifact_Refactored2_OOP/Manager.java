package DigitalArtifact_Refactored2_OOP;

// Required packages to be present to run functions in this class.

import java.util.InputMismatchException;
import java.util.Scanner;

public class Manager {
    Scanner scanner = new Scanner(System.in);

    public void processManager() {
        // Collect basic details
        initialMenu();

        // Offer interaction with polymorphic options B/S/G

        // ******* Need Array idea ********

        // ******* Testing scenarios required *******

        // End Process
        scanner.close();
        terminateProgramme();
    }

    public void initialMenu() {
        while (true) {

            Product product = new Product();
            System.out.println("""
                    Hello and welcome to the programme.
                    Navigate using the following character options:
                    Option (O): Open a new policy
                    Option (V): View an existing policy
                    Option (N): Exit
                    """);
            String option = scanner.nextLine().toLowerCase();

            if (option.equals("o")) {
                Customer customer = new Customer();
                customer.createPolicyRecord();

            } else if (option.equals("v")) {
                System.out.println("Please enter the policy number to review:");

                try {
                    int policyNumber = scanner.nextInt();
                    scanner.nextLine();

                    product.checkPolicyNumber(policyNumber);

                    Customer foundCustomer = ReadFile.accessPolicyData(policyNumber);

                    if (foundCustomer == null)
                        throw new InvalidPolicyNumberException("Account was not found", policyNumber);

                    foundCustomer.customerInformation();
                } catch (InputMismatchException e) {
                    System.err.println("Please enter a valid integer for the policy number.");
                    scanner.nextLine();
                } catch (InvalidPolicyNumberException e) {
                    System.err.println(e.getMessage());
                }
            } else if (option.equals("n")) {
                terminateProgramme();
            }

            System.out.println("\nWould you like to make another interaction? (Y/N)");
            String input = scanner.nextLine().toLowerCase();

            if (input.equals("n")) break;
        }
    }

    // Repeatable class to terminate the programme when required.
    private void terminateProgramme() {
        System.out.println("Thank you for interacting with SAG Bank Insurance Services Limited.");
        // End Programme immediately.
        System.exit(1);
    }
}

