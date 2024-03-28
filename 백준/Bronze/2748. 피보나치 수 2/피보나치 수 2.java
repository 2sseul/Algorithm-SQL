import java.io.*;
import java.util.*;

public class Main {	
	static long arr[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		arr = new long[91];
		arr[0] = 0;
		arr[1] = 1;
		
		int num = Integer.parseInt(br.readLine());
		Search(num);
		
		bw.write(String.valueOf(arr[num]));
		bw.flush();
		bw.close();
	}
	static void Search(int x) {
		for(int i=2; i<=x; i++) {
			arr[i] = arr[i-2]+arr[i-1];
		}
	}
}
