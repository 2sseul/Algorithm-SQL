import java.io.*;
import java.util.*;

public class Main {
	static int N, max, min;
	static int arr[];
	static int operations[];
	static int operation[];
	static boolean visited[];
	static int tmp[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		tmp = new int[N-1];
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		operations = new int[4];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			operations[i] = Integer.parseInt(st.nextToken());
		}
		
		int c = 0;
		operation = new int[N-1];
		visited = new boolean[N-1];
		for(int i=0; i<4; i++) {
			if(operations[i] != 0) {
				for(int j=0; j<operations[i]; j++) {
					operation[c] = i;
					c++;
				}
			}
		}
		
		Comb(0, 0);
		
		System.out.println(max);
		System.out.println(min);
	}
	public static void Comb(int start, int cnt) {
		if(cnt == N-1) {
			int num = arr[0];
			for(int i=0; i<N-1; i++) {
				if(tmp[i] == 0) {
					num += arr[i+1];
				}else if(tmp[i] == 1) {
					num -= arr[i+1];
				}else if(tmp[i] == 2) {
					num *= arr[i+1];
				}else if(tmp[i] == 3) {
					if(num < 0) {
						num *= -1;
						num /= arr[i+1];
						num *= -1;
					}else {
						num /= arr[i+1];
					}
				}
			}
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}
		
		for(int i=0; i<N-1; i++) {
			if(!visited[i]) {
				tmp[cnt] = operation[i];
				visited[i] = true;
				Comb(i, cnt+1);
				visited[i] = false;
			}
		}
	}
}
