import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static int M = 8;
	static int map[][] = new int[M][M];
	//LT T RT L R LB B RB
	static int xR[] = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int yL[] = {-1, 0, 1, -1, 1, -1, 0, 1};
	static int N; 
	static class Node{
		int kx;
		int ky;
		int sx;
		int sy;
		Node(int kx, int ky, int sx, int sy){
			this.kx = kx;
			this.ky = ky;
			this.sx = sx;
			this.sy = sy;
		}
	}
	public static void main(String[] args) throws Exception{
		StringTokenizer st = new StringTokenizer(br.readLine());
		String king_tmp = st.nextToken();
		String stone_tmp = st.nextToken();
		N = Integer.parseInt(st.nextToken());
		
		int king_start[] = {Integer.valueOf(king_tmp.charAt(0)-'A'), 7-(king_tmp.charAt(1)-49)};
		int stone_start[] = {Integer.valueOf(stone_tmp.charAt(0)-'A'), 7-(stone_tmp.charAt(1)-49)};
		
		int move[] = new int[N];
		Stamp(move);
		
		Move(king_start, stone_start, move);
		
		bw.write(sb.toString());
		bw.close();
	}
	static void Move(int[] king_start, int[] stone_start, int[] move) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(king_start[1], king_start[0], stone_start[1], stone_start[0]));
		
		while(true) {
			for(int i=0; i<=N; i++) {
				Node n = q.poll();
				if(i == N) {
					sb.append(Character.valueOf((char) (n.ky+65))).append(8-n.kx).append('\n');
					sb.append(Character.valueOf((char) (n.sy+65))).append(8-n.sx);
					return;
				}
				int new_kx = n.kx + xR[move[i]];
				int new_ky = n.ky + yL[move[i]];
				int new_sx = n.sx;
				int new_sy = n.sy;
				if(new_kx == new_sx && new_ky == new_sy) {
					new_sx += xR[move[i]];
					new_sy += yL[move[i]];
					
					if(new_sx < 0 || new_sx >= 8 || new_sy < 0 || new_sy >= 8) {
						q.offer(new Node(n.kx, n.ky, n.sx, n.sy));
						continue;
					}
				}
				
				if(new_kx < 0 || new_kx >= 8 || new_ky < 0 || new_ky >= 8) {
					q.offer(new Node(n.kx, n.ky, n.sx, n.sy));
					continue;
				}
				
				q.offer(new Node(new_kx, new_ky, new_sx, new_sy));
			}
		}
	}
	
	static void Stamp(int[] move) throws Exception {
		for(int i=0; i<N; i++) {
			String tmp = br.readLine();
			if(tmp.equals("LT")) {
				move[i] = 0;
			}else if(tmp.equals("T")) {
				move[i] = 1;
			}else if(tmp.equals("RT")) {
				move[i] = 2;
			}else if(tmp.equals("L")) {
				move[i] = 3;
			}else if(tmp.equals("R")) {
				move[i] = 4;
			}else if(tmp.equals("LB")) {
				move[i] = 5;
			}else if(tmp.equals("B")) {
				move[i] = 6;
			}else if(tmp.equals("RB")) {
				move[i] = 7;
			}
		}
	}
}
