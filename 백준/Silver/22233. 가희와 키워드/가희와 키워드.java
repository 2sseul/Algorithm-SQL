import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		HashMap<String, Integer> map = new HashMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			map.put(br.readLine(), 0);
		}
		
		
		for(int i=0; i<M; i++) {
			String tmp = br.readLine();
			String arr[] = tmp.split(",");
			for(int j=0; j<arr.length; j++) {
				if(map.containsKey(arr[j])) {
					map.remove(arr[j]);
				}else {
					continue;
				}
			}
			sb.append(map.size()).append('\n');
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
