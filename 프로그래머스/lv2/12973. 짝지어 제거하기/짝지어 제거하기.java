import java.util.*;
import java.io.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
		
		for(int i=0;i<s.length();i++) {
			if(stack.isEmpty()) {
				stack.push(s.charAt(i));
			}else {
				if(stack.peek() != s.charAt(i)) {
					stack.push(s.charAt(i));
				}else{
                    stack.pop();
                }
			}
		}
        
        int answer = 0;
        
		if(stack.isEmpty()) {
            answer = 1;
			return answer;
		}else {
			return answer;
		}
    }
}