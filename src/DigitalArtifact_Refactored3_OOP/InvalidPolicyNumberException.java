package DigitalArtifact_Refactored3_OOP;

// Extends from typical extension class and adds additional functionality specific to this programme.
public class InvalidPolicyNumberException extends Exception {
    // New method which takes 2 arguments from external class to add functionality.
    public InvalidPolicyNumberException(String message, int value) {
        //
        super("InvalidAccountNumberException: " + message + " : Input value: " + value);
    }
}