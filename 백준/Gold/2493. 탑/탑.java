import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> index = new Stack<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			int now = Integer.parseInt(st.nextToken());
			while(!stack.isEmpty()) {
				if(stack.peek() >= now) {
					System.out.print(index.peek()+" ");
					break;
				}
				stack.pop();
				index.pop();
			}
			if(stack.isEmpty()) {
				System.out.print("0 ");
			}
			stack.push(now);
			index.push(i);
		}
	}
}
