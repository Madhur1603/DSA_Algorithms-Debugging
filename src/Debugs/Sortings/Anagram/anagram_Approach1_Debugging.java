package Debugs.Sortings.Anagram;

public class anagram_Approach1_Debugging {
    public static void main(String[] args) {
        String a = "codingmaxima";
        String b = "maximacoding";
        anagramFind(a,b);
    }

    private static void anagramFind(String a, String b) {
        String ans = "YES";
        int[] count = new int[26];

        System.out.println("Both given strings are : "+a+" , "+b);

        // Check if the lengths of both strings are equal
        System.out.println("\nStep 1 : Check if the lengths of both strings are equal");
        if (a.length() == b.length()) {
            System.out.println("Length of both strings are equal, hence we continue");
            // Count the occurrences of each character in both strings
            System.out.println("\nStep 2 : Count the occurrences of each character in both strings");
            for (int i = 0; i < a.length(); i++) {
                System.out.println("\nLoop iteration : "+(i+1));
                count[a.charAt(i) - 'a']++;
                System.out.println("\tIncrement count[a.charAt("+i+") - 'a'] = count["+(a.charAt(i) - 'a')+"]++");
                count[b.charAt(i) - 'a']--;
                System.out.println("\tDecrement count[b.charAt("+i+") - 'a'] = count["+(b.charAt(i) - 'a')+"]--");
            }

            // Check if all counts are zero
            System.out.println("\nStep 3 : Check if all count element are zero if not then the strings are not anagram");
            for (int i = 0; i < count.length; i++) {
                if (count[i] != 0) {
                    System.out.println("count["+i+"] = "+count[i]+" is not equal to 0");
                    ans = "NO";
                    break;
                }
            }
        } else {
            System.out.println("Length of both strings are not equal, hence the string can not be anagram");
            ans = "NO";
        }

        System.out.println("\nAre '" + a + "' and '" + b + "' anagrams? " + ans);
    }
}
