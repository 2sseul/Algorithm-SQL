import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int arr[];
	static boolean visited[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		arr = new int[N];
		visited = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int left = 0;
		int right = N-1;
		int cnt = 0;
		while(left < right) {
			int sum = arr[left] + arr[right];
			if(sum < M) {
				left++;
			}else if(sum > M) {
				right--;
			}else {
				left++;
				right--;
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
