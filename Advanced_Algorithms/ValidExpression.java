/*
Problem:

*/


import java.util.*;
import java.lang.*;
import java.io.*;
public class ValidParenthesis {

    static char[] stack;
    public static int maxSize,topIndex;
    public static final char ERROR = '0';

    public static void initStack(int len){
        stack = new char[len];
        maxSize = len;
        topIndex = -1;
    }

    public static void push(char c){
        if(topIndex == maxSize-1)return;
        topIndex++;
        stack[topIndex] = c;
    }

    public static char pop(){
        if(topIndex == -1)return ERROR;
        return stack[topIndex--];
    }

    public static boolean isStackEmpty(){
        if(topIndex == -1)return true;
        return false;
    }

    public static boolean isMatch(char h, char c){
        if((h =='(' && c == ')') || (h == '{' && c == '}') || (h == '[' && c == ']'))return true;
        return false;
    }

    public static boolean checkValidity(char[] arr){
        for (char c: arr){
            if(c =='(' || c == '{' || c == '['){
                push(c);
            }
            else if(c == ')' || c == '}' || c == ']'){
                if(isStackEmpty())return false; //opening not found
                char popValue = pop();
                if(!isMatch(popValue, c))return false; //opening and closing not match
            }
        }

        if(!isStackEmpty())return false; //closing not found
        return true;
    }

    public static void main(String[] args) {
//        String testString = "5+(5*6)+{5+7}+[(5+2)]";
        Scanner sc = new Scanner(System.in);
        String testString = sc.nextLine();
        int len = 0;
        char arr[] = testString.toCharArray();
        for(int c : arr){
            if(c =='(' || c == '{' || c == '['){
                len++;
            }
        }

        initStack(len);
        if(checkValidity(arr)){
            System.out.println("The expression is valid!");
        }
        else{
            System.out.println("The expression is not valid!");
        }
    }
}


