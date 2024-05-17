import java.io.*;
import java.util.*;

public class Main {
	static int num;
	static List<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		//최대 공약수 찾기
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int gcd = 0;
		for(int i=1; i<N; i++) {
			gcd = GCD(arr[i]-arr[i-1], gcd);
		}
		
		int ans = (arr[N-1]-arr[0])/gcd - N + 1;
		
		sb.append(ans);
		bw.write(sb.toString());
		bw.close();
	}
	static int GCD(int x, int y) {

		if(y == 0) {
			return x;
		}
		else {
			return GCD(y, x % y);
		}
	}
}
