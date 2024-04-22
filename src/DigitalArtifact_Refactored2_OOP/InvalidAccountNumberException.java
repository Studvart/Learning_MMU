package DigitalArtifact_Refactored2_OOP;

// Extends from typical extension class and adds additional functionality specific to this programme.
public class InvalidAccountNumberException extends Exception {
    // New method which takes 2 arguments from external class to add functionality.
    public InvalidAccountNumberException(String message, int value) {
        //
        super("InvalidAccountNumberException: " + message + " : Error value: " + value);
    }
}