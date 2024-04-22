package DigitalArtifact_Refactored2_OOP;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile
{
    public static void writeCustomerFile(Customer customer)
    {
        String filePath = customer.getPolicyNumber() + ".txt";
        File file = new File(Directory.DIRECTORY_POLICY_DETAILS, filePath);

        file.getParentFile().mkdir();
        try
        {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(customer.getPolicyNumber() + "\n");
            bufferedWriter.write(customer.getFirstName() + "\n");
            bufferedWriter.write(customer.getSurname() + "\n");
            bufferedWriter.write(customer.getTier() + "\n");

            bufferedWriter.close();
        }
        catch (IOException e)
        {
            System.err.println(e.getMessage());
        }
    }

}
