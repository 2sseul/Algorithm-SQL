import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long K = Long.parseLong(br.readLine());
		if(K<0) {
			K*=-1;
		}
		
		if(K%2 == 0) {
			if(K==0) {
				System.out.println("0");
			}else {
				System.out.println("-1");
			}
		}else {
			int start = 0;
			int jump = 1;
			int cnt = 0;
			
			while(true) {
				cnt++;
				start += jump;
				jump*=2;
				if(start>=K) {
					break;
				}
			}
			System.out.println(cnt);
		}
	}
}
