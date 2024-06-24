import java.io.*;
import java.util.*;

public class Main {
	static int N, X, left, right, sum, max, cnt;
	static int arr[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		left = 0;
		right = X-1;
		for(int i=0; i<X; i++) {
			max += arr[i];
		}
		
		sum = max;
		cnt = 1;
		Cal();
		
		if(max == 0) {
			sb.append("SAD");
		}else {
			sb.append(max).append('\n');
			sb.append(cnt);
		}
		
		bw.write(sb.toString());
		bw.close();
	}
	public static void Cal() {
		while(left <= right) {
			right++;
			if(right == N) {
				break;
			}
			sum = sum - arr[left] + arr[right];
			if(sum == max) {
				cnt++;
			}else if(sum > max) {
				max = sum;
				cnt = 1;
			}
			left++;
		}
	}
}
