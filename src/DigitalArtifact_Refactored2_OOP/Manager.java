package DigitalArtifact_Refactored2_OOP;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Manager {
    Scanner scanner = new Scanner(System.in);

    public void processManager() {
        // Collect basic details
        // Offer polymorphic options B/S/G
        while (true) {
            System.out.println("""
                    Hello and welcome to the programme.
                    Would you like to open a new policy (O)
                    or view existing policy detail (V)?
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

                    if (policyNumber < 100000000)
                        throw new InvalidAccountNumberException("Policy number is invalid, minimum = 100,000,000", policyNumber);
                    else if (policyNumber > 999999999)
                        throw new InvalidAccountNumberException("Policy number is invalid, maximum = 999,999,999", policyNumber);

                    Customer foundCustomer = ReadFile.accessPolicyData(policyNumber);

                    if (foundCustomer == null)
                        throw new InvalidAccountNumberException("Account was not found", policyNumber);

                    foundCustomer.customerInformation();
                } catch (InputMismatchException e) {
                    System.err.println("Please enter a valid integer for the policy number.");
                    scanner.nextLine();
                } catch (InvalidAccountNumberException e) {
                    System.err.println(e.getMessage());
                }
            }

            System.out.println("\nWould you like to make another interaction? (Y/N)");
            String input = scanner.nextLine().toLowerCase();

            if (input.equals("n")) break;
        }

        // End Process
        System.out.println("Thank you for insuring with us.");
        System.exit(1);

    }
}

