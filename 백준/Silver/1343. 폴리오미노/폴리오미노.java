import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String tmp = br.readLine();
		
		tmp = tmp.replaceAll("XXXX", "AAAA");
		tmp = tmp.replaceAll("XX", "BB");
		
		if(tmp.contains("X")) {
			sb.append(-1);
		}else {
			sb.append(tmp);
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
