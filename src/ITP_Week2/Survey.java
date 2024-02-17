package ITP_Week2;

import java.util.Scanner;

public class Survey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = scanner.next();
        System.out.println("How old are you?");
        int age = scanner.nextInt();
        System.out.println("When is your Date of Birth?");
        String dob = scanner.next();
        System.out.println("What is your height in meters?");
        double height = scanner.nextDouble();
        System.out.println("What country where you born in?");
        String country = scanner.next();
        System.out.println("What is your favourite colour?");
        String colour = scanner.next();
        System.out.println("How many pets do you have?");
        int pets = scanner.nextInt();
        scanner.close();


        System.out.println("Your name is: " + name + ". You are " + age + "years old. You were born on:" + dob + ". You are " + height + "meters tall. You were born in: " + country + ". Your favourite colour is: " + colour + ". You have: " + pets + " pet(s).");
    }
}
