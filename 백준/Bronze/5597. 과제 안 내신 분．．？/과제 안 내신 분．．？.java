import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		boolean students[] = new boolean[30];
		for(int i=0; i<28; i++) {
			int num = Integer.parseInt(br.readLine());
			students[num-1] = true;
		}
		
		for(int i=0; i<30; i++) {
			if(!students[i]) {
				sb.append(i+1).append('\n');
			}
		}
		
		System.out.println(sb.toString());
	}
}
