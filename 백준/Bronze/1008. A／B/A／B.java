import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
        
		double A = Double.parseDouble(st.nextToken());
        double B = Double.parseDouble(st.nextToken());
        double ans = A/B;
        
        sb.append(ans);
        bw.write(sb.toString());
        bw.close();
	}
}