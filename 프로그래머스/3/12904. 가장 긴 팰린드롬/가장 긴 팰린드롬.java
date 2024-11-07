import java.io.*;
import java.util.*;

class Solution
{
    static char word[];
    static int max = 0;
    public int solution(String s)
    {
        int answer = 0;
        
        word = s.toCharArray();

        for(int i=0; i<s.length(); i++){
            checkPalindrome(i, i+2);
            checkPalindrome(i, i+1);
        }
        return max;
    }
    static void checkPalindrome(int left, int right){
        while(left >=0 && right < word.length && word[left] == word[right]){
            left--;
            right++;
        }
        
        if(max < right-left-1){
            max = right-left-1;
        }
    }
}