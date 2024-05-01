package Debugs.Arrays.MajorityElement;

import java.util.HashMap;

public class majorityElement_Debugging {
    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        majorityElementInArray(arr);
    }

    private static void majorityElementInArray(int[] arr) {
        int N = arr.length / 2;
        System.out.println("Threshold of (N) = " + N);

        int element = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        System.out.println("initializing HashMap named : map");

        for (int i = 0; i < arr.length; i++) {
            System.out.println();
            System.out.println("Loop iteration : "+(i+1));
            System.out.println("\tProcessing element: " + arr[i]);

            if (map.containsKey(arr[i])) {
                System.out.println("\tif (map.containsKey("+arr[i]+")) -> true, means");
                int value = map.get(arr[i]);
                System.out.println("\tElement " + arr[i] + " already exists in the map with count: " + value);

                if (value + 1 > N) {
                    System.out.println("\tIncrement count for element " + arr[i] + " : " + (value + 1));
                    System.out.println("\n\t\tif(value > N) -> true, means value = "+(value+1)+" is greater then N = "+N+"");
                    element = arr[i];
                    System.out.println("\t\tElement " + arr[i] + " occurs more than N/2 times. Majority element found: " + element);
                    break;
                }

                map.put(arr[i], value + 1);
                System.out.println("\tIncrement count for element " + arr[i] + " : " + (value + 1));
            } else {
                System.out.println("\tif (map.containsKey("+arr[i]+")) -> false, means");
                System.out.println("\tElement " + arr[i] + " does not exists in the map");
                map.put(arr[i], 1);
                System.out.println("\tSo, Added element " + arr[i] + " to the map with count: 1");

                if (arr.length == 1) {
                    element = arr[i];
                    System.out.println("\tOnly one element in the array. Majority element found: " + element);
                    break;
                }
            }
        }

        System.out.println("\nFinal majority element = " + element);
    }
}
