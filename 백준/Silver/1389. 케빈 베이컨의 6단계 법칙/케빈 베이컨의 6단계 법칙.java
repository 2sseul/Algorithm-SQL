import java.io.*;
import java.util.*;

public class Main {
	static int N, M, min;
	static int friendship[][];
	static int people[];
	static int tmp[];
	static boolean ok[];
	static int ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		friendship = new int[N][N];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			friendship[num1-1][num2-1] = 1;
			friendship[num2-1][num1-1] = 1;
		}
		
		people = new int[N];
		min = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			tmp = new int[N];
			ok = new boolean[N];
			Check(i);
		}
		
		ans = 0;
		Small();
		sb.append(ans+1);
		
		bw.write(sb.toString()); bw.close();
	}
	static void Small() {
		for(int i=0; i<N; i++) {
			min = Math.min(min, people[i]);
		}
		
		for(int i=0; i<N; i++) {
			if(people[i] == min) {
				ans = i;
				break;
			}
		}
	}
	static void Check(int x) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(x);
		ok[x] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int i=0; i<N; i++) {
				if(friendship[i][now] == 1 && friendship[now][i] == 1 && !ok[i]) {
					tmp[i] = tmp[now] + 1;
					q.offer(i);
					ok[i] = true;
				}else {
					continue;
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			people[x] += tmp[i];
		}
	}
}
