import java.io.*;
import java.util.*;

public class Main {
	static int N, M, left, right;
	static int arr[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		left = 0; right = -1;
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			//현재 가지고 있는 나무의 최대 높이
			right = Math.max(right, arr[i]);
		}
		
		Check();
		
		sb.append(right);
		bw.write(sb.toString());
		bw.close();
	}
	public static void Check() {
		while(left <= right) {
			//내가 가져갈 수 있는 상한선 높이
			int mid = (left+right)/2;
			//내가 총 가져갈 수 있는 나무의 길이
			long tree = 0;
			
			for(int i=0; i<N; i++) {
				if(arr[i] > mid) {
					tree += (arr[i]-mid);
				}else {
					continue;
				}
			}
			
			//아직 부족하면, 높이를 더 낮춰야 함.
			if(tree < M) {
				right = mid -1;
			//이미 충분하면, 높이를 더 높여야 함.
			}else if(tree >= M) {
				left = mid +1 ;
			}
		}
	}
}
