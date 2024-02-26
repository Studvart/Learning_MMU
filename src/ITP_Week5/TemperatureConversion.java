package ITP_Week5;

import java.util.Scanner;

public class TemperatureConversion {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int option;
        double inputF;
        double inputC;
        double myvalue;
        String optionContinue;

        do {
            do { //Adding Do While loop to accept valid actions only
                System.out.println("""
                        This tool will allow you to convert a temperature from F to C, or C to F
                        Option 1: Convert F to C
                        Option 2: Convert C to F
                        Option 3: Exit Programme
                        Enter a number from those on screen to continue.""");

                option = scanner.nextInt();
                if (!(option > 0 && option < 4)) {
                    System.out.printf("%d is not a valid input.\n", option);
                }
            } while (!(option > 0 && option < 4));

            switch (option) {
                case 1:
                    System.out.println("What Fahrenheit temperature do you want to convert to Centigrade");
                    inputF = scanner.nextDouble();
                    myvalue = FToC(inputF);
                    System.out.println(myvalue);
                    break;
                case 2:
                    System.out.println("What Centigrade temperature do you want to convert to Fahrenheit");
                    inputC = scanner.nextDouble();
                    myvalue = CToF(inputC);
                    System.out.println(myvalue);
                    break;
                case 3:
                    break;
            }
            System.out.println("Do you want to continue? (Yes/No)");
            optionContinue = scanner.next();
            // Validates user input is acceptable value
            if (!(optionContinue.equals("Yes") || optionContinue.equals("No"))) {
                //Where invalid - offer opportunity to enter valid input
                System.out.printf("%s is not a valid input.\n", optionContinue);
                System.out.println("Do you want to continue? (Yes/No)");
                optionContinue = scanner.next();
            }
        } while (!(optionContinue.equals("No"))); //Break loop on Acceptable answer "No"
        System.out.println("The programme will now exit, Goodbye");
    }


    public static double FToC(double inputF) {

        double valueToReturnF = (inputF - 32) * (5.0 / 9.0);
        return valueToReturnF;
    }

    public static double CToF(double inputC) {

        double valueToReturnC = (inputC * (9.0 / 5.0)) + 32;
        return valueToReturnC;

    }
}
