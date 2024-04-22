package DigitalArtifact_Refactored2_OOP;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile
{
    public static Customer accessPolicyData(int policyNumber)
    {
        String filePath = Directory.DIRECTORY_POLICY_DETAILS + File.separator + policyNumber + ".txt";
        File file = new File(filePath);

        try
        {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            int policyNum = Integer.parseInt(bufferedReader.readLine());
            String firstName = bufferedReader.readLine();
            String surname = bufferedReader.readLine();
            String tier = bufferedReader.readLine();

            bufferedReader.close();
            return new Customer(policyNum, firstName, surname, tier);
        }
        // Runs same code for either exception.
        catch(IOException | NumberFormatException e)
        {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
