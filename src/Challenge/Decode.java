package Challenge;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Arrays;

public class Decode {
    public static void main(String[] args) {
        HashMap<Integer, String> dictionary = new HashMap<Integer, String>();
        Scanner scanner = new Scanner(System.in);
        Integer[] codedValue = {16, 5, 11, 8, 18, 14, 13, 26, 15, 2, 23, 19, 7, 9, 11, 18, 16, 5, 11, 21, 19, 17, 22, 20, 1, 10, 15, 6, 24, 4, 15, 3};

        for (int i = 0; i < codedValue.length; i += 1) {
            dictionary.put(codedValue[i], " ");
        }
        dictionary.replace(11, "e");
        dictionary.replace(23, "j");
        dictionary.replace(8, "l");
        dictionary.replace(14, "z");
        dictionary.replace(21, "q");

        System.out.println("Please see the codex\n" + Arrays.toString(codedValue));
        System.out.println("This dictionary shows the mappings of the codex to the alphabet\n" + dictionary);
        for (Integer key : dictionary.keySet()) {
            if (dictionary.get(key) == " ") {
                System.out.println("Please enter a value for this coded number " + key);
                String userInput = scanner.nextLine();
                dictionary.replace(key, userInput);
            } else
                System.out.println("This key " + key + "already has an assigned value");
        }
        System.out.println("This dictionary shows the updated mappings of the codex to the alphabet\n" + dictionary);
        System.out.println("Based on your selections, your sentence looks like this:" + "");
    }
}
