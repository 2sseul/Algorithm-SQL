import java.io.*;
import java.util.*;

public class Main {
	static int[] reverse = {0, 3, 4, 1, 2};
	static int N;
	static int line[][];
	static int go[];
	static int dong[];
	static int ans;
	static int topDown, leftRight, all;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		//1은 북쪽 2는 남쪽 3은 서쪽 4는 동쪽 
		//북 남은 첫번째, 동 서는 두번째 숫자.
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		topDown = Integer.parseInt(st.nextToken()); // 1 3 가로 
		leftRight = Integer.parseInt(st.nextToken()); // 2 4 세로 
		all = topDown*2+leftRight*2;
		
		
		N = Integer.parseInt(br.readLine());
		
		line = new int[N][2];
		go = new int[N+1];
		Arrays.fill(go, Integer.MAX_VALUE);
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<2; j++) {
				line[i][j] = Integer.parseInt(st.nextToken());
				if(line[i][0] == 3 || line[i][0] == 4) {
					line[i][1] = leftRight - line[i][1];
				}
			}
		}
		
		dong = new int[2];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<2; i++) {
			dong[i] = Integer.parseInt(st.nextToken());
			if(dong[0] == 3 || dong[0] == 4) {
				dong[1] = leftRight - dong[1];
			}
		}
		ans = 0;
		
		Cal();
		
		sb.append(ans);
		bw.write(sb.toString());
		bw.close();
	}
	public static void Cal() {
		if(dong[0] == 1) {
			Dir1();
		}else if(dong[0]==3) {
			Dir3();
		}else if(dong[0]==2) {
			Dir2();
		}else {
			Dir4();
		}
	}
	public static void Dir1() {
		for(int i=0; i<N; i++) {
			int num = Integer.MAX_VALUE;
			if(line[i][0] == 1) {
				num = Math.min(num, Math.abs(dong[1] - line[i][1]));
			}else if(line[i][0] == 3) {
				num = Math.min(leftRight+dong[1]-line[i][1], all-(leftRight+dong[1]-line[i][1]));
			}else if(line[i][0] == 2) {
				num = Math.min(leftRight+dong[1]+line[i][1], all-(leftRight+dong[1]+line[i][1]));
			}else {
				num = Math.min(dong[1]+line[i][1]+leftRight+topDown, all-(dong[1]+line[i][1]+leftRight+topDown));
			}
			ans += num;
		}
	}
	public static void Dir3() {
		for(int i=0; i<N; i++) {
			int num = Integer.MAX_VALUE;
			if(line[i][0] == 1) {
				num = Math.min(leftRight-dong[1]+line[i][1], all-(leftRight-dong[1]+line[i][1]));
			}else if(line[i][0] == 3) {
				num = Math.min(num, Math.abs(dong[1] - line[i][1]));
			}else if(line[i][0] == 2) {
				num = Math.min(dong[1]+line[i][1], all-(dong[1]+line[i][1]));
			}else {
				num = Math.min(dong[1]+line[i][1]+topDown, all-(dong[1]+line[i][1]+topDown));
			}
			ans += num;
		}
	}
	public static void Dir2() {
		for(int i=0; i<N; i++) {
			int num = Integer.MAX_VALUE;
			if(line[i][0] == 1) {
				num = Math.min(leftRight+dong[1]+line[i][1], all-(leftRight+dong[1]+line[i][1]));
			}else if(line[i][0] == 3) {
				num = Math.min(dong[1]+line[i][1], all-(dong[1]+line[i][1]));
			}else if(line[i][0] == 2) {
				num = Math.min(num, Math.abs(dong[1] - line[i][1]));
			}else {
				num = Math.min(line[i][1]-dong[1]+topDown, all-(line[i][1]-dong[1]+topDown));
			}
			ans += num;
		}
	}
	public static void Dir4() {
		for(int i=0; i<N; i++) {
			int num = Integer.MAX_VALUE;
			if(line[i][0] == 1) {
				num = Math.min(topDown+leftRight+dong[1]+line[i][1], all-(topDown+leftRight+dong[1]+line[i][1]));
			}else if(line[i][0] == 3) {
				num = Math.min(dong[1]+line[i][1]+topDown, all-(dong[1]+line[i][1]+topDown));
			}else if(line[i][0] == 2) {
				num = Math.min(topDown-line[i][1]+dong[1], all-(topDown-line[i][1]+dong[1]));
			}else {
				num = Math.min(num, Math.abs(dong[1] - line[i][1]));
			}
			ans += num;
		}
	}
}
