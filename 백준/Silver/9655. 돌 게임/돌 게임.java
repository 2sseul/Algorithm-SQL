import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		if(N%2 == 0) {
			sb.append("CY");
		}else {
			sb.append("SK");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
