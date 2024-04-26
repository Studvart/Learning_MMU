package DigitalArtifact_Refactored3_OOP;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Tier {
    private final Scanner scanner = new Scanner(System.in);
    private final String _lowestTier = "Bronze";
    private final String _middleTier = "Silver";
    private final String _highestTier = "Gold";
    protected int benefitOption;
    private Tier _tier;
    private String _tierSelected;
    private int optionsAvailable = 0;

    // Default Run - Create a non-existent customer
    public Tier() {
    }

    public Tier get_tier() {
        return _tier;
    }

    protected String tierSelection() {
        System.out.println("Here are our tiered options:");
        printBenefits();

        int _option;
        do { //Adding Do While loop to accepts valid actions only
            System.out.printf("""
                    Which tier would you like?
                    1. %s, 2. %s, 3. %s
                    Input the corresponding integer.
                    """, _lowestTier, _middleTier, _highestTier);
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
                _tier = new Tier_Bronze();
                _tierSelected = _lowestTier;
                return _tierSelected;
            case 2:
                _tier = new Tier_Silver();
                _tierSelected = _middleTier;
                return _tierSelected;
            case 3:
                _tier = new Tier_Gold();
                _tierSelected = _highestTier;
                return _tierSelected;
        }
        return _tierSelected;
    }

    //Product benefits
    protected void tierBenefits() {
        System.out.println("""
                All policies cover:
                Buildings for: fire, flood and storm damage
                Contents for : the same as buildings + theft and freezer food losses.
                ----------------------------------------------------------------------
                """);
    }

    protected void tierBenefitsBronze() {
        System.out.printf("""
                %s provides:
                No additional benefits
                                
                ---------------------------------------
                """, _lowestTier);
    }

    protected void tierBenefitsSilver() {
        System.out.printf("""
                %s provides:
                %s benefits and
                Legal Expenses up to £50k.
                ---------------------------------------
                """, _middleTier, _lowestTier);
    }

    protected void tierBenefitsGold() {
        System.out.printf("""
                %s provides:
                %s + %s benefits and
                Home Emergencies up to £1k per claim.
                ---------------------------------------
                """, _highestTier, _lowestTier, _middleTier);
    }

    protected void printBenefits() {
        tierBenefits();
        tierBenefitsBronze();
        tierBenefitsSilver();
        tierBenefitsGold();
    }

    protected void accessRewards(Customer customer) {
        do {
                System.out.println("""
                        Which benefit would you like to access?
                        Navigate using the following integer options:
                        Option (1): Make a buildings claim
                        Option (2): Make a contents claim
                        """);
                if (customer.getTierSelected().equals(_middleTier) || customer.getTierSelected().equals(_highestTier)) {
                    System.out.println("Option (3): Make a Legal claim");
                }
                if (customer.getTierSelected().equals(_highestTier)) {
                    System.out.println("Option (4): Make a Home Emergency claim");
                }
            try {

                benefitOption = scanner.nextInt();
                scanner.nextLine();
                if (benefitOption > 0 && benefitOption <= availableBenefitOptions(customer)) {
                    break;
                }

                System.out.printf("%d is not a valid option, please select an option from the menu.", benefitOption);

            } catch (InputMismatchException e) {
                System.err.println("Please enter a valid integer for your selection.\n");
                scanner.nextLine();
            }

        } while (!(benefitOption > 0 && benefitOption <= availableBenefitOptions(customer)));

        switch (benefitOption) {
            case 1:
                System.out.println("""
                        We are sorry to hear your property is damaged.
                        We have forwarded a link via email.
                        Please start uploading evidence and adding detail to help us handle your claim.
                        """);
                break;
            case 2:
                System.out.println("""
                        We are sorry to hear your possessions have been lost.
                        We have forwarded a link via email.
                        Please start uploading any evidence or police reports to help us handle your claim.
                        """);
                break;
        }
    }

    private int availableBenefitOptions(Customer customer) {
        if (customer.getTierSelected().equals(_lowestTier)) {
            optionsAvailable = 2;
        } else if (customer.getTierSelected().equals(_middleTier)) {
            optionsAvailable = 3;
        } else if (customer.getTierSelected().equals(_highestTier)) {
            optionsAvailable = 4;
        }
        return optionsAvailable;
    }

    public Tier returnTierFromTierSelected(String _inputTierSelected) {
        switch (_inputTierSelected) {
            case _lowestTier -> {
                _tierSelected = _lowestTier;
                _tier = new Tier_Bronze();
                _tierSelected = _lowestTier;
            }
            case _middleTier -> {
                _tierSelected = _middleTier;
                _tier = new Tier_Silver();
                _tier._tierSelected = _middleTier;
            }
            case _highestTier -> {
                _tierSelected = _highestTier;
                _tier = new Tier_Gold();
                _tier._tierSelected = _highestTier;
            }
        }
        return _tier;
    }
}


