package Debugs.Queue.FirstNonRepeatingCharacter;
import java.util.*;

public class firstNonRepeatingCharacter_Debugging {
    private LinkedHashMap<Character, Integer> charCount = new LinkedHashMap<>();
    private int[] count = new int[26]; // array to keep count of each character
    private Queue<Character> queue = new LinkedList<>(); // queue to maintain order of characters

    public firstNonRepeatingCharacter_Debugging() {
        Arrays.fill(count, 0); // initialize count array
    }

    public void add(char c) {
        int index = c - 'a';
        System.out.println("\n\tAdding character, char = " + c);
        System.out.println("\tindex = char - 'a' = ('"+c+"' - 'a') = " + index);
        count[index]++;
        System.out.println("\tcount[index]++, increase count of char = '" + c + "': " + count[index]);

        // If character appears first time, add to LinkedHashMap and queue
        if (count[index] == 1) {
            System.out.println("\t\tif(count[index] == 1) -> true, means count["+index+"] = "+count[index]+" is equal to 1");
            System.out.println("\t\tCharacter '" + c + "' appears for the first time. Adding to charCount and queue.");
            System.out.println("\t\tcharCount.put('"+c+"', 1)");
            charCount.put(c, 1);
            System.out.println("\t\tqueue.add("+c+")");
            queue.add(c);
        } else {
            // Otherwise, remove from LinkedHashMap if it's still there
            System.out.println("\t\tif(count[index] == 1) -> false, means count["+index+"] = "+count[index]+" is not equal to 1");
            System.out.println("\t\tCharacter '" + c + "' appears more than once. Checking if it's in charCount.");
            if (charCount.containsKey(c)) {
                System.out.println("\t\t\tif(charCount.containsKey("+c+")) -> true, means the charCount contains a key = "+c);
                System.out.println("\t\t\tCharacter '" + c + "' is in charCount. Removing it.");
                System.out.println("\t\t\tcharCount.remove("+c+")");
                charCount.remove(c);
            }
        }
        System.out.println("\tCurrent charCount: " + charCount);
        System.out.println("\tCurrent queue: " + queue);
    }

    public char firstNonRepeating() {
        System.out.println("\n\tFinding first non-repeating character");
        // Check queue for first non-repeating character
        System.out.println("\twhile(!queue.isEmpty()) -> true, means the loop will iterate until queue gets empty");
        while (!queue.isEmpty()) {
            char firstChar = queue.peek();
            System.out.println("\t\tfirstChar = queue.peek(), checking character at front of queue: " + firstChar);
            if (charCount.containsKey(firstChar) && charCount.get(firstChar) == 1) {
                System.out.println("\t\t\tif(charCount.containsKey(firstChar) && charCount.get(firstChar) == 1) -> true, means charCount contains a key = "+firstChar+" and it holds the value = 1");
                System.out.println("\t\t\tCharacter '" + firstChar + "' is the first non-repeating character.");
                return firstChar;
            } else {
                System.out.println("\t\t\tif(charCount.containsKey(firstChar) && charCount.get(firstChar) == 1) -> false, means charCount does not contains a key = "+firstChar+" or does not holds the value = 1");
                System.out.println("\t\t\tqueue.remove(), character '" + firstChar + "' is repeating, so removing it from queue.");
                queue.remove();
            }
        }
        System.out.println("\tNo non-repeating characters found. Returning '#'.");
        return '#';
    }

    public static void main(String[] args) {
        System.out.println("Initialize : ");
        System.out.println("LinkedHashMap<Character, Integer> charCount = new LinkedHashMap<>(), means this is a linked hashmap that will store character as key and integer as its value");
        System.out.println("int[] count = new int[26], this is an integer array");
        System.out.println("Queue<Character> queue = new LinkedList<>(), this is a simple queue");
        firstNonRepeatingCharacter_Debugging finder = new firstNonRepeatingCharacter_Debugging();
        String stream = "aaabbc"; //   aaaa
        StringBuilder result = new StringBuilder();

        for (char c : stream.toCharArray()) {
            System.out.println("\nProcessing character from stream = " + c);
            finder.add(c);

            char firstNonRepeating = finder.firstNonRepeating();
            System.out.println("\nFirst non-repeating character after adding '" + c + "' = " + firstNonRepeating);

            result.append(firstNonRepeating);
            System.out.println("Current result: " + result.toString());
            System.out.println("-----------------------------------------------------------------------------");
        }

        System.out.println("\nOutput: " + result.toString());
    }
}
