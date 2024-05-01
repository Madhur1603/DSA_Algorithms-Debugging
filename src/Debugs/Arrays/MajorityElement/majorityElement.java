package Debugs.Arrays.MajorityElement;

import java.util.HashMap;

public class majorityElement {
    public static void main(String[] args) {
        int[] arr = {2,2,1,1,1,2,2};
        majorityElementInArray(arr);
    }

    private static void majorityElementInArray(int[] arr) {
        int N = arr.length/2;
        int element = -1;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            if(map.containsKey(arr[i])){
                int value = map.get(arr[i]);
                if(value+1 > N){
                    element = arr[i];
                    break;
                }
                map.put(arr[i], value+1);
            }
            else{
                map.put(arr[i],1);
                if(arr.length == 1){
                    element = arr[i];
                    break;
                }
            }
        }
        System.out.println(element);
    }
}
