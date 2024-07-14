import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		HashMap<String, Integer> map = new HashMap<>();
		
		PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<>() {
			public int compare(String o1, String o2) {
				return (map.get(o2)-map.get(o1));
			}
		});
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			String tmp = st.nextToken();
			if(!map.containsKey(tmp)) {
				map.put(tmp, 1);
			}else {
				map.put(tmp, map.get(tmp)+1);
			}
		}
		
		for(String key : map.keySet()) {
			pq.offer(key);
		}
		
		sb.append(map.get(pq.poll()));
		bw.write(sb.toString());
		bw.close();
	}
}
