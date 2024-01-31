import java.io.*;
import java.util.*;

public class Main {
	static int N, K;
	static String arr[];
	static String tmp = "";
	static boolean visited[];
	static HashMap<String, Integer> map = new HashMap<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		arr = new String[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = br.readLine();
		}
		
		for(int i=0; i<N; i++) {
			visited = new boolean[N];
			GO(1, arr[i], i);
		}
		
		System.out.println(map.size());
		
	}
	
	static void GO(int count, String numbers, int j) {
		if(count == K) {
			map.put(numbers, 0);
			return;
		}
		for(int i=0; i<N; i++) {
			if(i != j && !visited[i]) {
				visited[j] = true;
				GO(count+1, numbers+arr[i], i);
				visited[i] = false;
			}
		}
	}
}
