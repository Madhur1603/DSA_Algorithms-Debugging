package Debugs.Arrays.LongestCommonPrefix;

import java.util.Arrays;

public class longestCommonPrefix_Debugging {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        findLowestCommonPrefix(strs);
    }

    private static void findLowestCommonPrefix(String[] strs) {
        // Sort the array
        System.out.println("Step 1 : Sort the array");
        Arrays.sort(strs);
        System.out.println("Sorted string array: " + Arrays.toString(strs));

        // Get the first and last strings from the sorted array
        System.out.println();
        System.out.println("Step 2 : Get the first and last strings from the sorted array");
        String str1 = strs[0];
        String str2 = strs[strs.length - 1];
        System.out.println("First string, str1 = strs[0] = " + str1);
        System.out.println("Last string, str2 = strs["+(strs.length - 1)+"] " + str2);

        // Find the lowest common prefix between the first and last strings
        System.out.println();
        System.out.println("Step 3 : Find the lowest common prefix between the first and last strings");
        String finalWord = "";
        for (int i = 0; i < str1.length(); i++) {
            System.out.println();
            System.out.println("Loop iteration : "+(i+1));
            if (str1.charAt(i) == str2.charAt(i)) {
                System.out.println("\tif (str1.charAt("+i+") == str2.charAt("+i+")) -> true, means str1.charAt("+i+") = '"+str1.charAt(i)+"' is equal to str2.charAt("+i+") = '"+str2.charAt(i)+"'");
                System.out.println("\tNow we append this letter = '"+str1.charAt(i)+"' to the final word string");
                finalWord += str1.charAt(i);
                System.out.println("\tSo updated common prefix = '"+finalWord+"'");
            } else {
                System.out.println("\tif (str1.charAt("+i+") == str2.charAt("+i+")) -> false, means str1.charAt("+i+") = '"+str1.charAt(i)+"' is not equal to str2.charAt("+i+") = '"+str2.charAt(i)+"'");
                System.out.println("\tHence we get out of loop");
                break;
            }
        }

        System.out.println();
        System.out.println("Lowest common prefix: " + finalWord);
    }
}
