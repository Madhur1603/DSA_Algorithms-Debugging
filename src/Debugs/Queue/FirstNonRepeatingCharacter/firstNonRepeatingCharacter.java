package Debugs.Queue.FirstNonRepeatingCharacter;

import java.util.*;

class firstNonRepeatingCharacter {
    private LinkedHashMap<Character, Integer> charCount = new LinkedHashMap<>();
    private int[] count = new int[26]; // array to keep count of each character
    private Queue<Character> queue = new LinkedList<>(); // queue to maintain order of characters

    public firstNonRepeatingCharacter() {
        Arrays.fill(count, 0); // initialize count array
    }

    public void add(char c) {
        // Update count of character
        int index = c - 'a';
        count[index]++;

        // If character appears first time, add to LinkedHashMap and queue
        if (count[index] == 1) {
            charCount.put(c, 1);
            queue.add(c);
        } else {
            // Otherwise, remove from LinkedHashMap if it's still in there
            if (charCount.containsKey(c)) {
                charCount.remove(c);
            }
        }
    }

    public char firstNonRepeating() {
        // Check queue for first non-repeating character
        while (!queue.isEmpty()) {
            char firstChar = queue.peek();
            if (charCount.containsKey(firstChar) && charCount.get(firstChar) == 1) {
                return firstChar;
            } else {
                queue.remove();
            }
        }
        // If queue is empty, return '#'
        return '#';
    }

    public static void main(String[] args) {
        firstNonRepeatingCharacter finder = new firstNonRepeatingCharacter();
        String stream = "aaaa"; //   aaaa
        StringBuilder result = new StringBuilder();

        for (char c : stream.toCharArray()) {
            finder.add(c);
            result.append(finder.firstNonRepeating());
        }

        System.out.println("Output: " + result.toString()); // Output: "aaabac"
    }
}

