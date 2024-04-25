package DigitalArtifact_Refactored2_OOP;

public class Tier_Gold extends Tier_Silver {
    @Override
    protected void accessRewards(String _inputTierSelected) {
        super.accessRewards(_inputTierSelected);

        switch (benefitOption) {
            case 4:
                System.out.println("""
                        Our Team will be in contact within 1 hour.
                        Essential home care instructions have been emailed to you,
                        to help safeguard your home until we get in touch.
                        """);
                break;
        }
    }

    protected void goldRewards(){
        System.out.println("Option (4): Make a Home Emergency claim");
    }
}
