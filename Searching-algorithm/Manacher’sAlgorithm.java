/*
Problem:
Given a string s, return the longest palindromic substring in s.

Algorithms:
Step 1: Go through all index
Step 2: Check left and right value untill it meet the palindrome condition
Step 3: Store length of current palindrome length
Step 4: return the maximum palindrome length of string 

Time Complexity: O(n^2)

Sample input:
s = "babad"

Sample output:
"bab"
*/
public class ManacherAlgorithm {

    public static String longestPalindrome(String s) {
        int n = s.length();
        int start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            int len1 = checkMatching(s, i, i);
            int len2 = checkMatching(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start+1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int checkMatching(String s, int left, int right) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
    
    public static void main(String[] args) {
       String s = "babad";
        System.out.println(longestPalindrome(s));
    }
}
