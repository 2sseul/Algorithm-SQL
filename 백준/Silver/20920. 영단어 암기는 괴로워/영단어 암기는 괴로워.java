import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		Map<String, Integer> map = new HashMap<>();
		List<String> list = new ArrayList<>();
		PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<>(){
			public int compare(String o1, String o2) {
				if(map.get(o1) > map.get(o2)) {
					return -1;
				}else if(map.get(o1) < map.get(o2)) {
					return 1;
				}else {
					if(o1.length() < o2.length()) {
						return 1;
					}else if(o1.length() > o2.length()) {
						return -1;
					}else {
						return o1.compareTo(o2);
					}
				}
			}
		});
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int tc=0; tc<N; tc++) {
			String tmp = br.readLine();
			
			if(tmp.length() < M) {
				continue;
			}
			
			if(!map.containsKey(tmp)) {
				map.put(tmp, 1);
			}else {
				map.put(tmp, map.get(tmp)+1);
			}
		}
		

		list.addAll(map.keySet());
		
		for(int i=0; i<list.size(); i++) {
			String word = list.get(i);
			pq.offer(word);
		}
		
		while(!pq.isEmpty()) {
			String word = pq.poll();
			sb.append(word).append('\n');
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
