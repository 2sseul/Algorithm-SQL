import java.io.*;
import java.util.*;

public class Main {
	static int N, M, left, right;
	static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		left = 0; right = -1;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			right = Math.max(right, arr[i]);
		}
		
		M = Integer.parseInt(br.readLine());
		
		Check();
		
		sb.append(right);
		bw.write(sb.toString());
		bw.close();
	}
	public static void Check() {
		while(left <= right) {
			//상한 예산
			int mid = (left + right)/2;
			long budget = 0;
			
			for(int i=0; i<N; i++) {
				if(arr[i] < mid) {
					budget += arr[i];
				}else {
					budget += mid;
				}
			}
			
			if(budget <= M) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
	}
}
