import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static boolean visited[];
	static int arr[];
	static int count;
	static String number;
	static List<String> list = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		count = 1;
		number = "";
		
		for(int i=0; i<N; i++) {
			visited = new boolean[N];
			visited[i] = true;
			number = (i+1)+" ";
			DFS(i, count, number);
		}
		
		Collections.sort(list);
		
		for(int i=0; i<list.size(); i++) {
			String tmp = list.get(i);
			tmp = tmp.substring(0, tmp.length()-1);
			sb.append(tmp).append('\n');
		}
		
		System.out.println(sb.toString());
	}
	static void DFS(int i, int count, String number) {
		if(count == M) {
			list.add(number);
		}
		
		for(int j=0; j<N; j++) {
			if(i != j && !visited[j]) {
				visited[j] = true;
				DFS(j, count+1, number+(j+1)+" ");
				visited[j] = false;
			}
		}
	}
}
