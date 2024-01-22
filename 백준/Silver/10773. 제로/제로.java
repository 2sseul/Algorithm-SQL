import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		Stack<Integer> stack = new Stack<>();
		List<Integer> list = new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		
		for(int i=0; i<K; i++) {
			int N = Integer.parseInt(br.readLine());
			if(N == 0) {
				stack.pop();
				list.remove(list.size()-1);
			}else {
				stack.push(N);
				list.add(N);
			}
		}
		
		long answer = 0;
		for(int i=0; i<list.size(); i++) {
			answer += list.get(i);
		}
		
		System.out.println(answer);
	}
}
