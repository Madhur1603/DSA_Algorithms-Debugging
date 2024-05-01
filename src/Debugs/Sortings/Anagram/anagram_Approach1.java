package Debugs.Sortings.Anagram;

import java.util.Arrays;

public class anagram_Approach1 {
    public static void main(String[] args) {
        String a = "codingmaxima";
        String b = "maximacoding";
        anagramFind(a,b);
    }

    private static void anagramFind(String a, String b) {
        String ans = "YES";
        int[] count = new int[26];

        if(a.length() == b.length()){
            for(int i=0; i<a.length(); i++){
                count[a.charAt(i) - 'a']++;
                count[b.charAt(i) - 'a']--;
            }
            for(int i=0; i<count.length; i++){
                if(count[i] != 0){
                    ans = "NO";
                    break;
                }
            }
        }
        else{
            ans = "NO";
        }
        System.out.println(ans);
    }
}
