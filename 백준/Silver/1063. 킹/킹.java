import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int map[][];
	static int movingX[] = {0,0,1,-1,-1,-1,1,1};
	static int movingY[] = {1,-1,0,0,1,-1,1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		map = new int[8][8];
		
		st = new StringTokenizer(br.readLine());
		
		String king = st.nextToken();
		char king1 = king.charAt(0);
		char king2 = king.charAt(1);
		int kingX = Math.abs(((int)king2)-56);
		int kingY = ((int)king1)-65;
		map[kingX][kingY] = 1;
		
		String stone = st.nextToken();
		char stone1 = stone.charAt(0);
		char stone2 = stone.charAt(1);
		int stoneX = Math.abs(((int)stone2)-56);
		int stoneY =((int)stone1)-65;
		map[stoneX][stoneY] = 2;
		
		int move = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<move;i++) {
			String where = br.readLine();
			int num = move(where);
			int newKingX = kingX + movingX[num];
			int newKingY = kingY + movingY[num];
			//king이 범위 내에 존재하면, 
			if(isValid(newKingX, newKingY)) {
				//만약 이동했는데 돌이 있으면,
				if(isStone(newKingX,newKingY)) {
					int newStoneX = stoneX + movingX[num];
					int newStoneY = stoneY + movingY[num];
					//돌이 이동했는데 범위 내에 존재하면,
					if(isValid(newStoneX,newStoneY)) {
						map[stoneX][stoneY]=0;
						map[kingX][kingY]=0;
						kingX = newKingX;
						kingY = newKingY;
						stoneX = newStoneX;
						stoneY = newStoneY;
						map[newKingX][newKingY]=1;
						map[newStoneX][newStoneY]=2;
					//돌이 이동했는데 범위 밖이라면,
					}else {
						continue;
					}
				//만약 이동했는데 돌이 없으면,
				}else {
					map[kingX][kingY]=0;
					kingX = newKingX;
					kingY = newKingY;
					map[newKingX][newKingY]=1;
				}
			//king이 범위 내에 존재하지 않으면,
			}else {
				continue;
			}
		}
		
		String alpK = translate(kingY);
		int ansK = Math.abs(kingX-7)+1;
		String alpS = translate(stoneY);
		int ansS = Math.abs(stoneX-7)+1;
		System.out.println(alpK+ansK);
		System.out.println(alpS+ansS);
	}
	
	private static String translate(int num) {
		if(num == 0) {
			return "A";
		}else if(num == 1) {
			return "B";
		}else if(num == 2) {
			return "C";
		}else if(num == 3) {
			return "D";
		}else if(num == 4) {
			return "E";
		}else if(num == 5) {
			return "F";
		}else if(num == 6) {
			return "G";
		}else if(num == 7) {
			return "H";
		}
		return null;
	}

	private static boolean isStone(int newKingX, int newKingY) {
		if(map[newKingX][newKingY]==2) {
			return true;
		}
		return false;
	}

	private static boolean isValid(int newKingX, int newKingY) {
		if(newKingX<0 || newKingX>=8 || newKingY<0 || newKingY>=8) {
			return false;
		}
		return true;
	}
	
	private static int move(String where) {
		if(where.equals("R")) {
			return 0;
		}else if(where.equals("L")) {
			return 1;
		}else if(where.equals("B")) {
			return 2;
		}else if(where.equals("T")) {
			return 3;
		}else if(where.equals("RT")) {
			return 4;
		}else if(where.equals("LT")) {
			return 5;
		}else if(where.equals("RB")) {
			return 6;
		}else if(where.equals("LB")) {
			return 7;
		}
		return 0;	
	}
}
