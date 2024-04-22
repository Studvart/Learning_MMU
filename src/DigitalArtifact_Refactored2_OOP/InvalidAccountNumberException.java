package DigitalArtifact_Refactored2_OOP;

public class InvalidAccountNumberException extends Exception
{
    public InvalidAccountNumberException(String message, int value)
    {
        super("InvalidAccountNumberException: " + message + " : Error value: " + value);
    }
}