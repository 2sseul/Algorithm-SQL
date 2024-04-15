import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		String N = br.readLine();
		
		int arr[] = new int[10];
		
		for(int i=0; i<N.length(); i++) {
			int num = Integer.valueOf(N.charAt(i))-48;
			arr[num]++;
		}
		
		int tmp = (arr[6]+arr[9]);
		if(tmp%2!=0) {
			tmp+=1;
		}
		tmp /= 2;
		
		arr[6] = tmp;
		arr[9] = 0;
		
		int num = Integer.MIN_VALUE;
		for(int i=0; i<10; i++) {
			if(num < arr[i]) {
				num = arr[i];
			}
		}
		
		sb.append(num);
		bw.write(sb.toString());
		bw.close();
	}
}
