package Debugs.Arrays.FirstElementOccurKTimes;

import java.util.HashMap;

public class firstElementKTimes {
    public static void main(String[] args) {
        int[] array = {3,3, 1, 4, 2, 2,2, 1, 5, 3};
        int k = 1;
        elementKTimesOccur(array, k);
    }

    private static void elementKTimesOccur(int[] array, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int element = 0;
        for(int i=0; i<array.length; i++){
            if(map.containsKey(array[i])){
                int value = map.get(array[i]);
                if(value+1 == k){
                    element = array[i];
                    break;
                }
                map.put(array[i],value+1);
            }
            else{
                map.put(array[i], 1);
                if(k == 1){
                    element = array[i];
                    break;
                }
            }
        }

        System.out.println("the element = "+element);
    }
}
