package DigitalArtifact_Refactored2_OOP;

public class Product {
    private final int policyNumberMax = 999999999;
    private final int policyNumberMin = 100000000;

    public int getPolicyNumberMax() {
        return policyNumberMax;
    }

    public int getPolicyNumberMin() {
        return policyNumberMin;
    }

    public void checkPolicyNumber(int _inputPolicyNumber) throws InvalidPolicyNumberException {
        if (_inputPolicyNumber < getPolicyNumberMin())
            throw new InvalidPolicyNumberException("Policy number is invalid, minimum = 100,000,000", _inputPolicyNumber);
        else if (_inputPolicyNumber > getPolicyNumberMax())
            throw new InvalidPolicyNumberException("Policy number is invalid, maximum = 999,999,999", _inputPolicyNumber);
    }

}
