package DigitalArtifact_Refactored2_OOP;

public class Tier_Silver extends Tier_Bronze {
    @Override
    protected void accessRewards() {
        super.accessRewards();

        System.out.println("""
                Option (3): Make a Legal claim
                """);

        switch (benefitOption) {
            case 3:
                System.out.println("""
                        Our Legal team will be in touch within 1 working day.
                        We will assign your case to a relevantly skilled team.
                        Please have as much documentation to hand to support the discussion.
                        """);
                break;
        }
    }
}
