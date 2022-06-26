/*
Problem:
Given a text txt[0..n-1] and a pattern pat[0..m-1], 
write a function search(char pat[], char txt[]) 
that prints all occurrences of pat[] in txt[]. 
You may assume that n > m. 

Time Complexity: O(m+n)

Sample input:
txt = "ABABDABACDABABCABAB";
pat = "ABABCABAB";
Sample output:
10
*/
public class KMP {

    public static void searchPattern(String txt, String pat) {
        int l1 = txt.length(), l2 = pat.length();
        char[] pattern = pat.toCharArray(), text = txt.toCharArray();
        int[] lps = getLps(pattern, l2);
        int i = 0, j = 0;
        while (i < l1) {
            if (pattern[j] == text[i]) {
                i++;
                j++;
            } else if (j != 0) {
                j = lps[j - 1];
            } else {
                i++;
            }
            if (j == l2) {
                System.out.println("Patter found at:" + (i - l2));
                j = lps[j - 1];
            }
        }
    }

    public static int[] getLps(char[] pattern, int l) {
        int[] lps = new int[l];
        int i = 1, j = 0;
        lps[0] = 0;
        while (i < l) {
            if (pattern[i] == pattern[j]) {
                lps[i] = ++j;
                i++;
            } else if (j != 0) {
                j = lps[j - 1];
            } else {
                lps[i] = j;
                i++;
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        String txt = "ABABDABACDABABCABAB";
        String pat = "acccbaaacccbaac";
        searchPattern(txt, pat);
    }
}
