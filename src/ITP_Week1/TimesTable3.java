package ITP_Week1;

public class TimesTable3 {
    public static void main(String[] args) {
        String divider = "+-------------+";
        int factor = 1;
        for (int i = 1; i < 13; i++) {
            System.out.println(divider);

            for (int j = 1; j < 13; j++) {
                //System.out.println(j + " x " + i + " = " + (j * i));
                //System.out.printf("| %-2d | %-1s | %2d | %3d |%n", j, "x", i  , j * i);
                // d = digits
                // s = string
                // n = new line
                // - left align ELSE right aligned
                // the integer passed is the number of chars to accept of particular data type.
                // %04d - in cases where no alignment required in a 4 digit space, add a 0 infront and a 0 is forced to the front
                System.out.printf("| %-7s | %-3d |%n", j + " x " + i, j * i);
            }
            System.out.println(divider);
        }

    }
}
