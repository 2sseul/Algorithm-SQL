import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		List<Integer> list = new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			list.add(num);
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken());
			list.add(num);
		}
		
		Collections.sort(list);
		
		for(int i=0; i<list.size(); i++) {
			sb.append(list.get(i)).append(" ");
		}
		
		System.out.println(sb.toString());
	}
}
