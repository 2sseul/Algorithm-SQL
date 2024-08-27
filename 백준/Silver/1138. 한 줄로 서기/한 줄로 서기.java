import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		boolean visited[] = new boolean[N];
		
		//나보다 큰 사람이 설 수 있는 공간을 마련해 둬야 한다. >> 이게 키포인트!
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			int cnt = 0;
			for(int j=0; j<N; j++) {
				if(!visited[j]) {
					if(cnt == num) {
						visited[j] = true;
						arr[j] = i+1;
						break;
					}else {
						cnt++;
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			sb.append(arr[i]).append(" ");
		}
		bw.write(sb.toString());
		bw.close();
	}
}
