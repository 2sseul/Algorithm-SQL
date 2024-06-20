import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int arr[][];
	static boolean visited[][];
	static List<Integer> list = new ArrayList<>();
	static List<Integer> list2 = new ArrayList<>();
	static List<Integer> ans = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][2];
		for(int i=0; i<N; i++) {
			arr[i][0] = i+1;
			arr[i][1] = Integer.parseInt(br.readLine());
		}
		
		for(int i=0; i<N; i++) {
			list.clear();
			list2.clear();
			visited = new boolean[N][2];
			Check(i);
		}
		
		Collections.sort(ans);
		sb.append(ans.size()).append('\n');
		for(int i=0; i<ans.size(); i++) {
			sb.append(ans.get(i)).append('\n');
		}
		
		bw.write(sb.toString());
		bw.close();
	}
	public static void Check(int now) {
		if(visited[now][0]) {
			int cnt = 0;
			Collections.sort(list);
			Collections.sort(list2);
			for(int i=0; i<list.size(); i++) {
				if(list.get(i) == list2.get(i)) {
					cnt++;
				}
			}
			if(cnt == list.size()) {
				for(int i=0; i<list.size(); i++) {
					if(!ans.contains(list.get(i))) {
						ans.add(list.get(i));
					}
				}
			}
			return;
		}else {
			visited[now][0] = true;
			visited[now][1] = true;
			list.add(arr[now][0]);
			list2.add(arr[now][1]);
			Check(arr[now][1]-1);
		}		
	}
}
