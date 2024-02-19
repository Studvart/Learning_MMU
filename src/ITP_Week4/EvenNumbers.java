package ITP_Week4;

public class EvenNumbers {
    public static void main(String[] args) {
        int total = 0;
        for (int i = 2; i <= 20; i++) {
            // Find out if the number above is even or odd
            if (i % 2 == 0) {
                System.out.println(i + " is even.");
                total = total + i;
            }
        }
        System.out.printf("Program Start\n" +
                "Create a variable called total with the value 0\n" +
                "for i, where i starts at 2 and is always an even number:\n" +
                "add i to total and store in the variable total\n" +
                "print total %d\n" +
                "Program End", total);
    }
}
