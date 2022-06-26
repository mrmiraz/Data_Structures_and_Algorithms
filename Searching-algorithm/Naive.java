/*
Problem:
Given a text txt[0..n-1] and a pattern pat[0..m-1], 
write a function search(char pat[], char txt[]) 
that prints all occurrences of pat[] in txt[]. 
You may assume that n > m. 

Time Complexity: O(m*n)

Sample input:
txt = "ABABDABACDABABCABAB";
pat = "ABABCABAB";
Sample output:
10
*/
public class Naive {
    
    public static void searchPattern(String txt, String pat){
        char[] text = txt.toCharArray();
        char[] pattern = pat.toCharArray();
        int l1 = text.length, l2 = pattern.length;
        for(int i = 0; i < l1; i++){
            int j = 0, k = i;
            for(; j < l2 && i+j < l1; j++){
                if(text[k++] != pattern[j]){
                    break;
                }
            }
            if(j == l2){
                System.out.println("pattern found at :" + i);
            }
        }
    }
    
    public static void main(String[] args) {
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        searchPattern(txt, pat);
    }
}
