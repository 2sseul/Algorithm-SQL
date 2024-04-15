import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		double grade[] = {1.0f, 1.5f, 2.0f, 2.5f, 3.0f, 3.5f, 4.0f, 4.5f};
		
		String arr[][] = new String[20][3];
		for(int i=0; i<20; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = st.nextToken();
			arr[i][1] = st.nextToken();
			arr[i][2] = st.nextToken();
		}
		
		double sum = 0;
		double cnt = 0;
		for(int i=0; i<20; i++) {
			if(!arr[i][2].equals("P")) {
				sum += Double.valueOf(arr[i][1]);
				if(arr[i][2].equals("A+")) {
					cnt += (Double.valueOf(arr[i][1])*grade[7]);
				}else if(arr[i][2].equals("A0")) {
					cnt += (Double.valueOf(arr[i][1])*grade[6]);
				}else if(arr[i][2].equals("B+")) {
					cnt += (Double.valueOf(arr[i][1])*grade[5]);
				}else if(arr[i][2].equals("B0")) {
					cnt += (Double.valueOf(arr[i][1])*grade[4]);
				}else if(arr[i][2].equals("C+")) {
					cnt += (Double.valueOf(arr[i][1])*grade[3]);
				}else if(arr[i][2].equals("C0")) {
					cnt += (Double.valueOf(arr[i][1])*grade[2]);
				}else if(arr[i][2].equals("D+")) {
					cnt += (Double.valueOf(arr[i][1])*grade[1]);
				}else if(arr[i][2].equals("D0")) {
					cnt += (Double.valueOf(arr[i][1])*grade[0]);
				}
			}
		}
		
		double ans = cnt/sum;
		if(sum == 0) {
			ans = 0;
		}
		
		sb.append(ans);
		bw.write(sb.toString());
		bw.close();
	}
}
