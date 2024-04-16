import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		HashMap<String, Integer> map = new HashMap<>();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<N; tc++) {
			map.clear();
			int max = Integer.MIN_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			for(int i=0; i<T; i++) {
				String num = st.nextToken();
				if(!map.containsKey(num)) {
					map.put(num, 1);
					max = Math.max(max, 1);
				}else {
					map.put(num, map.get(num)+1);
					max = Math.max(max, map.get(num));
				}
			}
			
			if(max <= T/2) {
				sb.append("SYJKGW").append('\n');
			}else {
				List<String> list = new ArrayList<>(map.keySet());
				for(int i=0; i<list.size(); i++) {
					if(map.get(list.get(i)) == max) {
						sb.append(list.get(i)).append('\n');
						break;
					}else {
						continue;
					}
				}
			}
		}
		
		bw.write(sb.toString());
		bw.close();
		
	}
}
