package Debugs.Arrays.FindDuplicatesInArray;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class findDuplicatesInArray_Debugging {
    public static void main(String[] args) {
//        int[] arr = {4,3,2,7,8,3,2,1};
        int[] arr = {5,5,6,6,7,7,8,8,9};
        duplicatesInArray(arr);
    }

    private static void duplicatesInArray(int[] arr) {
        List<Integer> result = new ArrayList<>();
        System.out.println("An ArrayList is initialized named: result");
        HashSet<Integer> set = new HashSet<>();
        System.out.println("A HashSet is initialized named: set");
        int i = 0;
        for (int x : arr) {
            System.out.println();
            System.out.println("Loop iteration: " + (i + 1)); // Fixing the print statement for loop iteration
            if (!set.add(x)) {
                System.out.println("if(!set.add("+x+")) -> true, this means that "+x+" is already in the set and we cannot add it into the set");
                System.out.println("So our set remains same, set = "+set);
                result.add(x);
                System.out.println("So "+x+" is duplicate, hence we add it into our result arraylist : "+result);
            }
            else{
                System.out.println("if(!set.add("+x+")) -> false, this means that "+x+" is not present in the set so we add it into the set");
                System.out.println("So our set becomes, set = "+set);
                System.out.println("Hence "+x+" is not duplicate, means we don't add it into our result arraylist and it remains same.");
                System.out.println("result = "+result);
            }
            i++;
        }

        System.out.println();
        System.out.println("Duplicates found in the array, result = " + result); // Adding a descriptive message
    }
}

