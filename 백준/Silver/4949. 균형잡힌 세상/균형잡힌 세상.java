import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		
		while(true) {
			stack.clear();
			String s = br.readLine();
			if(s.equals(".")) {
				break;
			}
			int length = s.length();
			boolean bigFlag = false;
			boolean smallFlag = false;
			for(int i=0;i<length;i++) {
				char what = s.charAt(i);
				
				if(what == '[') {
					stack.add('[');
				}else if(what == '(') {
					stack.add('(');
				}else if(what == ']'){
					if(stack.isEmpty()) {
						bigFlag = true;
						break;
					}else {
						char pick = stack.peek();
						if(pick == '[') {
							stack.pop();
						}else {
							bigFlag = true;
							break;
						}
					}
				}else if(what == ')') {
					if(stack.isEmpty()) {
						smallFlag = true;
						break;
					}else {	
						char pick = stack.peek();
						if(pick == '(') {
							stack.pop();
						}else {
							smallFlag = true;
							break;
						}
					}
				}

				if(what == '.') {
					break;
				}
			}

			if(!stack.isEmpty() || bigFlag || smallFlag) {
				sb.append("no");
			}else {
				sb.append("yes");
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}
}
