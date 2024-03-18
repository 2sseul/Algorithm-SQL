import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static Deque<Integer> queue = new LinkedList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<N; tc++) {
			String tmp = br.readLine();
			String arr[] = tmp.split(" ");
			
			if(arr[0].equals("push")) {
				Push(Integer.parseInt(arr[1]));
			}else if(arr[0].equals("front")) {
				Front();
			}else if(arr[0].equals("back")) {
				Back();
			}else if(arr[0].equals("size")) {
				Size();
			}else if(arr[0].equals("pop")) {
				Pop();
			}else if(arr[0].equals("empty")) {
				Empty();
			}
		}
		
		bw.write(sb.toString());bw.flush();bw.close();
	}
	static void Empty() {
		if(!queue.isEmpty()) {
			sb.append(0).append('\n');
		}else {
			sb.append(1).append('\n');
		}
	}
	static void Pop() {
		if(!queue.isEmpty()) {
			int num = queue.poll();
			sb.append(num).append('\n');
		}else {
			sb.append(-1).append('\n');
		}
	}
	static void Size() {
		sb.append(queue.size()).append('\n');
	}
	static void Back() {
		if(!queue.isEmpty()) {
			sb.append(queue.getLast()).append('\n');
		}else {
			sb.append(-1).append('\n');
		}
	}
	static void Front() {
		if(!queue.isEmpty()) {
			sb.append(queue.getFirst()).append('\n');
		}else {
			sb.append(-1).append('\n');
		}
	}
	static void Push(int x) {
		queue.add(x);
	}
}
