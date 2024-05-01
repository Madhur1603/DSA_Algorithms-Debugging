package Debugs.Arrays.FirstElementOccurKTimes;

import java.util.HashMap;

public class firstElementKTimes_Debugging {
    public static void main(String[] args) {
        System.out.println("!! Brute Force Approach !!");
        System.out.println();
        int[] array = {3,3, 1, 4, 2, 2,2, 1, 5, 3};
        int k = 3;
        elementKTimesOccur(array, k);
    }

    private static void elementKTimesOccur(int[] array, int k) {
        System.out.println("k is the times the element occur, k = "+k);
        HashMap<Integer, Integer> map = new HashMap<>();
        System.out.println("A HashMap is initialized named: map");
        int element = 0;
        for(int i=0; i<array.length; i++){
            System.out.println();
            System.out.println("Loop iteration: " + (i + 1)); // Fixing the print statement for loop iteration
            if(map.containsKey(array[i])){
                System.out.println("if(map.containsKey("+array[i]+")) -> true, means the map already contains a key = "+array[i]+"");
                int value = map.get(array[i]);
                System.out.println("now, value = "+value+", which is the value of key = "+array[i]);
                if(value+1 == k){
                    System.out.println("if(value+1 == k) -> true, means value+1 = "+(value+1)+" is equal to k = "+k+", for the key = "+array[i]);
                    element = array[i];
                    System.out.println("Then element that occur k times, key = "+element);
                    break;
                }
                map.put(array[i],value+1);
                System.out.println("Now we increase the 'value' of that key by 1 so, key = "+array[i]+" with value = "+(value+1));
            }
            else{
                System.out.println("if(map.containsKey("+array[i]+")) -> false, means the map does not contains a key = "+array[i]);
                map.put(array[i], 1);
                System.out.println("Hence we put it into the map,so key = "+array[i]+", which occurred first time so, value = "+1);
                if(k == 1){
                    System.out.println("Here k is equal to 1, then we return the first element of the array.");
                    element = array[i];
                    break;
                }
            }
        }

        System.out.println();
        System.out.println("The element that occurs k times: "+element);
    }
}
