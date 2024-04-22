package DigitalArtifact_Refactored2_OOP;

// Required packages to be present to run functions in this class.

import java.util.InputMismatchException;
import java.util.Scanner;

public class Manager {
    Scanner scanner = new Scanner(System.in);

    public void processManager() {
        // Collect basic details
        while (true) {
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
            }else if (option.equals("n")) {
                terminateProgramme();
            }

            System.out.println("\nWould you like to make another interaction? (Y/N)");
            String input = scanner.nextLine().toLowerCase();

            if (input.equals("n")) break;
        }


        // Offer interaction with polymorphic options B/S/G

        // ******* Need Array idea ********

        // End Process
        scanner.close();
        terminateProgramme();
    }

    // Repeatable class to terminate the programme when required.
    private void terminateProgramme(){
        System.out.println("Thank you for insuring with us.");
        // End Programme immediately.
        System.exit(1);
    }
}

