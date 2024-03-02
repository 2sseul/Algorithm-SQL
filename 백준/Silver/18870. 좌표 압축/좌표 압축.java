import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		TreeMap<Integer, Integer> map = new TreeMap<>();
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N];
		int check[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int tc=0; tc<N; tc++) {
			arr[tc] = Integer.parseInt(st.nextToken());
			check[tc] = arr[tc];
 		}
		
		Arrays.sort(arr);
		
		int cnt = 0;
		for(int i=0; i<N; i++) {
			if(map.containsKey(arr[i])) {
				continue;
			}else {
				map.put(arr[i], cnt);
				cnt++;
			}
		}
		
		for(int i=0; i<N; i++) {
			sb.append(map.get(check[i])).append(" ");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}	
}
