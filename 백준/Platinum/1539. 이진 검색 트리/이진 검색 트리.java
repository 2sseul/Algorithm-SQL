import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		TreeSet<Integer> set = new TreeSet<>();
		
		long answer = 0;
		for(int i=0; i<N; i++) {
			int now = Integer.parseInt(br.readLine());
			if(set.higher(now) == null) {
				if(set.lower (now) == null) {
					arr[now] = 1;
				}else {
					arr[now] = arr[set.lower (now)]+1;
				}
			}else {
				if(set.lower(now) == null) {
					arr[now] = arr[set.higher(now)]+1;
				}else {
					arr[now] = Math.max(arr[set.higher(now)], arr[set.lower(now)])+1;
				}
			}
			set.add(now);
			answer += arr[now];
		}
		
		System.out.println(answer);
	}
}
