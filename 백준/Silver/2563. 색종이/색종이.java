import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int num1, num2;
	static int cnt = 0;
	static int map[][] = new int[101][101];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			num1 = Integer.parseInt(st.nextToken());
			num2 = Integer.parseInt(st.nextToken());
			
			for(int j=num2; j<num2+10; j++) {
				for(int k=99-num1-9; k<99-num1+1; k++) {
					map[j][k] = 1;
				}
			}
		}
		
		count();
		
		System.out.println(sb.toString());
	}
	
	static void count() {
		for(int i=0; i<101; i++) {
			for(int j=0; j<101; j++) {
				if(map[i][j]==1) {
					cnt++;
				}
			}
		}
		sb.append(cnt);
	}
}
