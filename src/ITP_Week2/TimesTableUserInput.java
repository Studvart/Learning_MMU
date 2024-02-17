package ITP_Week2;

import java.util.Scanner;

public class TimesTableUserInput
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What times table would you like to see?");
        int timesTable = scanner.nextInt();

        for (int i = 1; i < 13; i++)
        {
            System.out.println(i + " x " + timesTable + " = " + i * timesTable);

        }
        scanner.close();
    }
}
