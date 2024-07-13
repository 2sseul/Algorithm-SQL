import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		HashMap<String, Integer> map = new HashMap<>();
		
		PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<>(){
			public int compare(String o1, String o2) {
				if(map.get(o1) > map.get(o2)) {
					return -1;
				}else if(map.get(o1) < map.get(o2)) {
					return 1;
				}else {
					return o1.compareTo(o2);
				}
			}
		});
		
		
		int N = Integer.parseInt(br.readLine());
		
		String students[] = new String[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			String p = st.nextToken();
			students[i] = p;
			map.put(p, 0);
		}
		
		for(int i=0; i<N; i++) {
			String[] tmp = br.readLine().split(" ");
			for(int j=0; j<tmp.length; j++) {
				map.put(tmp[j], map.get(tmp[j])+1);
			}
		}
		
		for(int i=0; i<N; i++) {
			pq.offer(students[i]);
		}
		
		while(!pq.isEmpty()) {
			String name = pq.poll();
			sb.append(name).append(" ").append(map.get(name)).append('\n');
		}
		
		bw.write(sb.toString());
		bw.close();
		
	}
}
