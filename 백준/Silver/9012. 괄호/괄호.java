import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		Stack<Character> stack = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int i=0; i<tc; i++) {
			stack.clear();
			
			String tmp = br.readLine();
			//System.out.println(tmp);
			String answer = "YES";
			
			for(int j=0; j<tmp.length(); j++) {
				if(stack.isEmpty()) {
					stack.push(tmp.charAt(j));
				}else {
					char check = stack.peek();
					if(check == '(') {
						if(tmp.charAt(j)==')') {
							stack.pop();
						}else {
							stack.push(tmp.charAt(j));
						}
					}else {
						stack.push(tmp.charAt(j));
					}
				}
			}
			
			if(!stack.isEmpty()) {
				answer = "NO";
			}
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb.toString());
		
	}
}
