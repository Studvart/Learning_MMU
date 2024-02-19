package Challenge;

import java.util.HashMap;
import java.util.Scanner;

public class ReplaceArrayValues {

    public static void main(String[] args) {
        // Define the HashMap with integer keys and character values
        HashMap<Integer, Character> map = new HashMap<>();
        // Populate the HashMap with your integer-key and char-value pairs
        Integer[] codedValue = {16, 5, 11, 8, 18, 14, 13, 26, 15, 2, 23, 19, 7, 9, 11, 18, 16, 5, 11, 21, 19, 17, 22, 20, 1, 10, 15, 6, 24, 4, 15, 3};
        for (int i = 0; i < codedValue.length; i += 1) {
            map.put(codedValue[i], '_');
        }
        map.replace(11, 'e');
        map.replace(23, 'j');
        map.replace(8, 'l');
        map.replace(14, 'z');
        map.replace(21, 'q');

        // Allow user to input suggestions for undefined values
        inputSuggestions(map, codedValue);
    }

    private static void inputSuggestions(HashMap<Integer, Character> map, Integer[] codedValue) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter suggestions for undefined values (0 to 9):");
        System.out.println("Enter each suggestion in the format: key value (e.g., 19 u)");
        System.out.println("Type 'done' when finished.");
        System.out.println("Type 'list' to show assigned letters for each integer.");

        while (true) {
            // Print the current arrays
            System.out.println("Coded Value array:");
            printArray(codedValue, map);
            System.out.println("Modified array:");
            printModifiedArray(map, codedValue);

            System.out.print("Enter suggestion: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("done")) {
                break;
            } else if (input.equalsIgnoreCase("list")) {
                printHashMap(map);
                continue;
            }

            String[] parts = input.split("\\s+");
            if (parts.length != 2) {
                System.out.println("Invalid input. Please enter in the correct format.");
                continue;
            }

            try {
                int key = Integer.parseInt(parts[0]);
                char value = parts[1].charAt(0);
                map.put(key, value);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Key must be an integer.");
            }
        }

        scanner.close();
    }

    private static void printArray(Integer[] array, HashMap<Integer, Character> map) {
        for (int value : array) {
            if (map.containsKey(value)) {
                System.out.print(value + " ");
            } else {
                System.out.print("_ ");
            }
        }
        System.out.println();
    }

    private static void printModifiedArray(HashMap<Integer, Character> map, Integer[] codedValue) {
        for (int value : codedValue) {
            if (map.containsKey(value)) {
                System.out.print(map.get(value) + " ");
            } else {
                System.out.print("_ ");
            }
        }
        System.out.println();
    }

    private static void printHashMap(HashMap<Integer, Character> map) {
        System.out.println("Assigned letters for each integer:");
        for (int key : map.keySet()) {
            System.out.println(key + " -> " + map.get(key));
        }
    }
}
