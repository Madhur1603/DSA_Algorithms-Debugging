package Debugs.Arrays.LongestCommonPrefix;

import java.util.Arrays;

public class longestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        findLowestCommonPrefix(strs);
    }

    private static void findLowestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String str1 = strs[0];
        String str2 = strs[strs.length-1];

        String finalWord = "";

        for(int i=0; i<str1.length(); i++){
            if(str1.charAt(i) == str2.charAt(i)){
                finalWord += str1.charAt(i);
            }
            else{
                break;
            }
        }
        System.out.println(finalWord);
    }
}
