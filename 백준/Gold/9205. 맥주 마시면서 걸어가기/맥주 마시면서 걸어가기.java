import java.io.*;
import java.util.*;

public class Main {
	static class Move{
		int x;
		int y;
		Move(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static int house[], convenience[][], festival[], isOk, c;
	static boolean visited[];
	static int now[] = new int[2];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			c = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			house = new int[2];
			house[0] = Integer.parseInt(st.nextToken());
			house[1] = Integer.parseInt(st.nextToken());
			
			convenience = new int[c][2];
			visited = new boolean[c];
			for(int j=0; j<c; j++) {
				st = new StringTokenizer(br.readLine());
				convenience[j][0] = Integer.parseInt(st.nextToken());
				convenience[j][1] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			festival = new int[2];
			festival[0] = Integer.parseInt(st.nextToken());
			festival[1] = Integer.parseInt(st.nextToken());
			
			String isOk = "";
			if(Math.abs(house[0]-festival[0])+Math.abs(house[1]-festival[1]) <= 1000){
				isOk = "happy";
			}else {
				isOk = BFS();
			}
			
			System.out.println(isOk);
		}
	}
	static String BFS() {
		Queue<Move> q = new LinkedList<>();
		q.offer(new Move(house[0], house[1]));
		
		while(!q.isEmpty()) {
			Move m = q.poll();
			
			if(Math.abs(festival[0]-m.x)+Math.abs(festival[1]-m.y) <= 1000) {
				return "happy";
			}
			
			for(int i=0; i<c; i++) {
				if(!visited[i] && Math.abs(convenience[i][0]-m.x)+Math.abs(convenience[i][1]-m.y) <= 1000) {
					visited[i] = true;
					q.offer(new Move(convenience[i][0], convenience[i][1]));
				}
			}
		}
		
		return "sad";
	}
}
