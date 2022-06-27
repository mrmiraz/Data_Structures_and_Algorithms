/*
Problem:
Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function search(char pat[], char txt[]) that prints all occurrences of pat[] in txt[]. You may assume that n > m.

Algorithm:
Step 1: Create hash for the pattern
Step 2: Create hash for each length of pattern from text
Step 3: If TextHash = patternHash then match each character of hash window of text with pattern
Step 4: If all the character are match then return true;

Time Complexity: O(n+M)

Sample input:
txt = "miraz hossain raz";
pat = "raz";
Sample output:
2 10

*/
public class RobinKarp {

    static final int prime = 3;
    static final int MOD = 1000000007;

    public static void searchPattern(String txt, String pat) {
        int n = txt.length(), m = pat.length();
        char[] text = txt.toCharArray(), pattern = pat.toCharArray();
        int patHash = getHash(pat, m);
        int txtHash = getHash(txt.substring(0, m), m);
        for (int i = m; i <= n;i++) {
            if (txtHash == patHash && isMatch(text, pattern, i)) {
                System.out.println("pattern found at: " + (i-m));
            }
            if (i == n) {
                break;
            }
            int x = (txtHash - text[i - m]);
            x = x / prime;
            txtHash = x + text[i] * (int) Math.pow(prime, m - 1);
        }
    }

    public static boolean isMatch(char[] text, char[] pat, int i) {

        int j = 0, m = pat.length;
        for (; j < m; j++) {
            if (pat[j] != text[i - m + j]) {
                break;
            }
        }
        if (j == m) {
            return true;
        }
        return false;
    }

    public static int getHash(String s, int n) {
        char[] pat = s.toCharArray();
        int hash = pat[0];
        for (int i = 1; i < n; i++) {
            hash += pat[i] * (int)Math.pow(prime, i);
        }
        return hash;
    }

    public static void main(String[] args) {
        String txt = "miraz hossain raz";
        String pat = "raz";
        searchPattern(txt, pat);
    }
}
