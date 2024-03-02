package DigitalArtifact;

public class TestingClass {


    public static double getRandomDouble_Between(int min, int max) {
        double truncated;
        double generate = ((Math.random() * (max - min)) + min);
        if (generate >= 0) {
            truncated = Math.floor(generate * 100) / 100;
        } else {
            truncated = Math.ceil(generate * 100) / 100;
        }
        return truncated;

    }
        public static int getRandomInt_Between(int min, int max) {
            double generate = ((Math.random() * (max - min)) + min);
            return (int)generate;
    }

    public static void main(String[] args) {

        System.out.println(TestingClass.getRandomDouble_Between(50,120));
        System.out.println(TestingClass.getRandomInt_Between(50,120));
        }



}
