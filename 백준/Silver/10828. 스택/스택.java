import java.io.*;
import java.util.*;

public class Main {
	static Stack<Integer> stack = new Stack<>();
	static 	StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{ 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			String what = br.readLine();
			if(what.contains("push")) {
				int num = Integer.parseInt(what.substring(5, what.length()));
				Push(num);
			}else if(what.equals("pop")) {
				Pop();
			}else if(what.equals("size")) {
				Size();
			}else if(what.equals("empty")) {
				Empty();
			}else if(what.equals("top")) {
				Top();
			}
		}
		System.out.println(sb.toString());
	}

	private static void Push(int num) {
		stack.push(num);
		
	}

	private static void Pop() {
		if(!stack.isEmpty()) {
			int tmp = stack.pop();
			sb.append(tmp).append('\n');
		}else {
			sb.append("-1").append('\n');
		}
	}

	private static void Size() {
		sb.append(stack.size()).append('\n');
		
	}
	
	private static void Empty() {
		if(!stack.isEmpty()) {
			sb.append("0").append('\n');
		}else {
			sb.append("1").append('\n');
		}
	}
	
	private static void Top() {
		if(stack.isEmpty()) {
			sb.append("-1").append('\n');
		}else {
			sb.append(stack.peek()).append('\n');
		}
	}
}
