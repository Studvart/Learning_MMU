package ITP_Week1;

public class Arithmetic_Operator_Precedence {
    public static void main(String[] args)
    {

        int a = 10;
        int b = 6;
        int c = 2;

        System.out.println(a + b * c);
        System.out.println(39 / a + b);
        System.out.println((a + b) * c);
        System.out.println(3 * (5 + b) / c);
        System.out.println(a - 11 * c / b);
        System.out.println(a * b + b / c - 1);
        System.out.println(27 % 3 + c);
        System.out.println(2 * a % -3);
    }
}
