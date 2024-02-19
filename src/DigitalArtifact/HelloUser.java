package DigitalArtifact;

import java.util.Scanner;

public class HelloUser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = scanner.next();

        System.out.println("Hello " + name);
        System.out.println(name + ", It’s great to meet you.");
        System.out.println("Good day " + name + ". How are you today?");

    }
}
