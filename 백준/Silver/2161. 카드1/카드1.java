import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<>();
		
		int N = sc.nextInt();
		
		for(int i=1; i<=N; i++) {
			queue.add(i);
		}
		
		while(!queue.isEmpty()) {
			sb.append(queue.peek()+" ");
			queue.remove();
			
			if(!queue.isEmpty()) {
				int num = queue.peek();
				queue.remove();
				queue.add(num);
			}
		}
		
		System.out.println(sb.toString());
	}
}
