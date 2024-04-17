import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<=N; i++) {
			Star(i);
		}
		
		bw.write(sb.toString());
		bw.close();
	}
	static void Star(int x) {
		for(int i=0; i<x; i++) {
			sb.append("*");
		}
		if(sb.length() != 0) {
			sb.append('\n');
		}
	}
}
