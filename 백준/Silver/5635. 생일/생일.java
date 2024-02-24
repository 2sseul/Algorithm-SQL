import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TreeMap<Integer, String> map = new TreeMap<>();
		List<Integer> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int day = Integer.parseInt(st.nextToken());
			int month = Integer.parseInt(st.nextToken())*100;
			int year  = Integer.parseInt(st.nextToken())*1000;

			map.put(year+month+day, name);
		}
		
		list.addAll(map.keySet());
		sb.append(map.get(list.get(list.size()-1))).append('\n');
		sb.append(map.get(list.get(0)));	
		System.out.println(sb.toString());
	}
}
