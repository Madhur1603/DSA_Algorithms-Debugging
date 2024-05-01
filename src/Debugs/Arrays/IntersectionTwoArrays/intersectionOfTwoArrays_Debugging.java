package Debugs.Arrays.IntersectionTwoArrays;

import java.util.HashSet;

public class intersectionOfTwoArrays_Debugging {
    public static void main(String[] args) {
        int[] arr1 = {7, 7, 7, 7, 7};
        int[] arr2 = {7, 7, 7, 7};
        intersectionCount(arr1, arr2);
    }

    private static void intersectionCount(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        System.out.println("Initialising Hashset named: set");
        int count = 0;

        System.out.println();
        System.out.println("Adding elements of arr1 to HashSet:");
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        System.out.println("Hashset after adding all the elements of arr1, set = "+set);

        System.out.println("\nChecking intersection with arr2 elements:");
        for (int j = 0; j < arr2.length; j++) {
            System.out.println();
            System.out.println("Loop iteration : "+(j+1));
            if (set.contains(arr2[j])) {
                System.out.println("Intersection found: " + arr2[j]+", both array have the same element");

                count++;
                System.out.println("Incrementing count = " + count);

                if(set.remove(arr2[j])) {
                    System.out.println("Now we remove the element = " + arr2[j] + " from the set to remove duplicacy.");
                    System.out.println("Hence our set = "+set);
                }
            }
            else{
                System.out.println("intersection = "+arr2[j]+", not found");
            }
        }

        System.out.println("\nCount of intersecting elements = " + count);
    }
}
