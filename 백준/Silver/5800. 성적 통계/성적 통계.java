import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int students = Integer.parseInt(st.nextToken());
			int classroom[] = new int[students];
			for(int j=0; j<students; j++) {
				classroom[j] = Integer.parseInt(st.nextToken());
			}
			sb.append("Class ").append(i).append('\n');
			Arrays.sort(classroom);
			sb.append("Max ").append(classroom[classroom.length-1]).append(", ");
			sb.append("Min ").append(classroom[0]).append(", ");
			int ans = 0;
			for(int j=1; j<classroom.length; j++) {
				int min = classroom[j] - classroom[j-1];
				ans = Math.max(ans, min);
			}
			sb.append("Largest gap ").append(ans);
			if(i != N) {
				sb.append('\n');
			}
		}
		
		bw.append(sb.toString());
		bw.close();
	}
}
