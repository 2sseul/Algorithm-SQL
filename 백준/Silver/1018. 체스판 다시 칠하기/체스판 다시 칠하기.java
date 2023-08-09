
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		char map[][] = new char[r][c];
		char tmp1[][] = new char[r][c];
		char tmp2[][] = new char[r][c];
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(i%2==0 && j%2==0) {
					tmp1[i][j] = 'W';
					tmp2[i][j] = 'B';
				}else if(i%2==0 && j%2!=0) {
					tmp1[i][j] = 'B';
					tmp2[i][j] = 'W';
				}else if(i%2!=0 && j%2==0) {
					tmp1[i][j] = 'B';
					tmp2[i][j] = 'W';
				}else {
					tmp1[i][j] = 'W';
					tmp2[i][j] = 'B';
				}
			}
		}
	
		//System.out.println(Arrays.deepToString(tmp1));
		//System.out.println(Arrays.deepToString(tmp2));
		
		for(int i=0; i<r; i++) {
			String tmp = br.readLine();
			map[i] = tmp.toCharArray();
		}
		
		int cnt1 = 0;
		int cnt2 = 0;
		
		int numX = 0;
		int numY = 0;
		
		int ans = Integer.MAX_VALUE;
		
		while(true) {
			cnt1 = 0;
			cnt2 = 0;
			//System.out.println(numX+" "+numY);
			for(int i=numX; i<numX+8; i++) {
				for(int j=numY; j<numY+8; j++) {
					if(map[i][j]!=tmp1[i][j]) {
						cnt1++;
					}
					if(map[i][j]!=tmp2[i][j]) {
						cnt2++;
					}
				}
			}
			
			int tmp = Math.min(cnt1, cnt2);
			ans = Math.min(ans, tmp);
			
			if(numX+8==r && numY+8==c) {
				break;
			}
			
			if(numY+8==c) {
				numY = 0;
				numX++;
			}else {
				numY++;
			}
			
		}
		
		if(ans == 2147483647) {
			ans = 0;
		}
		System.out.println(ans);
		
	}
}
