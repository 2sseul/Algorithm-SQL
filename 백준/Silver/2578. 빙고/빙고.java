import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		int arr[][] = new int[5][5];
		int bingo[][] = new int[12][5];
		
		for(int i=0; i<5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				bingo[i][j] = arr[i][j];
			}
		}
		
		
		for(int i=5; i<10; i++) {
			for(int j=0; j<5; j++) {
					bingo[i][j] = arr[j][i-5];
			}
		}
		
		for(int j=0; j<5; j++) {
			bingo[10][j] = arr[j][j];
			bingo[11][j] = arr[j][4-j];
		}
		
		boolean check[][] = new boolean[12][5];
		
		int total = 0;
		int ans = 0;
		loop1:
		for(int i=0; i<5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			loop2:
			for(int j=0; j<5; j++) {
				int num = Integer.parseInt(st.nextToken());
				ans++;
				
				for(int k=0; k<12; k++) {
					for(int l=0; l<5; l++) {
						if(bingo[k][l] == num) {
							check[k][l] = true;
						}
					}
				}
				
				
				for(int k=0; k<12; k++) {
					int cnt = 0;
					for(int l=0; l<5; l++) {
						if(check[k][l]) {
							cnt++;
							if(cnt == 5) {
								cnt = 0;
								total++;
							}
						}
					}
				}
				
				if(total >= 3) {
					break loop1;
				}
				
				total = 0;
			}
		}
		
		sb.append(ans);
		bw.write(sb.toString());
		bw.close();
	}
}
