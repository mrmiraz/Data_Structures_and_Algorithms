/*
Problem: 
We are given two arrays num[]and rem[] with length n, every pair is coprime.
We need to find minimum positive number x such that x%num[1ton] = rem[1ton];

Algorithm(Chinese Remainder Theorem)
This theorem say there will be a number which will fulfil the above condition always
Step 1: run a loop until it find the number x;
Step 2: in every run check the condition for every pair of value
Step 3: if x satisfied for all pair of value then return the x

Time Complexity  : O(M), M is the product of all elements of num[] array.

Auxiliary Space : O(1)

*/

public class ChineseReminderTheorem {
    public static int findMinX(int num[], int rem[]){
        int length = num.length;
        int x = 1;
        while(true){
            int j = 0;
            for(; j < length; j++){
                if(x%num[j] != rem[j])break;
            }
            
            // if all reminders satisfied the condition, we found the x
            if(j == length)return x;
            else x++;
        }
    }
    
    public static void main(String[] args){
        int num[] = {3, 4, 5};
        int rem[] = {2, 3, 1};
        System.out.println(findMinX(num, rem));
    }
}
