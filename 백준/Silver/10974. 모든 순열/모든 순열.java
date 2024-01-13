import java.util.*;

public class Main {
	static int arr[];
	static boolean visited[];
	static int N;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		arr = new int[N];
		visited = new boolean[N+1];
		
		check(0);
		
		System.out.println(sb.toString());
	}
	static void check(int cnt) {
		if(cnt == N) {
			for(int i=0; i<N; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append('\n');
			return;
		}
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[cnt] = i;
				check(cnt+1);
				visited[i] = false;
 			}
		}
	}
}
