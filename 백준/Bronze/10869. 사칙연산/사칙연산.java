import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
        
		int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int ans0 = A+B;
        int ans1 = A-B;
        int ans2 = A*B;
        int ans3 = A/B;
        int ans4 = A%B;
        
        sb.append(ans0).append('\n');
        sb.append(ans1).append('\n');
        sb.append(ans2).append('\n');
        sb.append(ans3).append('\n');
        sb.append(ans4).append('\n');
        bw.write(sb.toString());
        bw.close();
	}
}