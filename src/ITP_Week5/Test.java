package ITP_Week5;

public class Test {
    public static void main(String[] args) {
        char ch = 'l';
        String string = "Hello World";
        int testing = StringUtils.timesCharOccurs(ch, string);
        System.out.println(testing);

        String string2 = "abcdefghijklmnopqrstuvwxyz";
        String testing2 = StringUtils.frequencyReport(string);
        System.out.println(testing2);

    }
}
