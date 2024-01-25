import java.io.*;
import java.util.*;

public class Main {
	static int computers, networks, cnt;
	static int map[][];
	static boolean check[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		computers = Integer.parseInt(br.readLine());
		
		networks = Integer.parseInt(br.readLine());
		
		map = new int[computers][computers];
		check = new boolean[computers];
		cnt = 0;
		
		for(int i=0; i<networks; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			map[num1-1][num2-1] = 1;
			map[num2-1][num1-1] = 1;
		}
		
		DFS(0);
		
		//System.out.println(Arrays.toString(check));
		System.out.println(cnt);
		
	}
	static void DFS(int i) {
		check[i] = true;
		
		
		for(int j=0; j<computers; j++) {
			if(map[i][j] == 1 && !check[j]) {
				DFS(j);
				cnt++;
			}
		}
	}
}
