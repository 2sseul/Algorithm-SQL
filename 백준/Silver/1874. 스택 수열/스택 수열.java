import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		List<Integer> list = new ArrayList<>();
		
		Stack<Integer> stack = new Stack<>();
		
		int N = Integer.parseInt(br.readLine());
		int num = N;
		
		int start = 1;
		
		int cnt = 0;
		int[] arr = new int[N];
		
		while(N-- > 0) {
			int value = Integer.parseInt(br.readLine());
			arr[cnt++] = value;
			
			if(value > start) {
				for(int i=start; i<=value;i++) {
					if(i==value) {
						stack.add(start);
						sb.append("+"+'\n');
						list.add(stack.pop());
						sb.append("-"+'\n');
					}else {		
						stack.add(start);
						sb.append("+"+'\n');
					}
					start++;
				}
			}else if(value == start) {
				stack.add(start);
				sb.append("+"+'\n');
				list.add(stack.pop());
				sb.append("-"+'\n');
				start++;
			}else {
				list.add(stack.pop());
				sb.append("-"+'\n');
			}
			
		}
		
		int count = 0;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i) == arr[i]) {
				count++;
			}
		}
		
		if(count == num) {
			System.out.println(sb.toString());
		}else {
			System.out.println("NO");
		}
	}
}
