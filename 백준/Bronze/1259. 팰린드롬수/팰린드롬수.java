import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String tmp = br.readLine();
			if(tmp.equals("0")) {
				break;
			}
			StringBuilder sb = new StringBuilder(tmp);
			String compare = sb.reverse().toString();
			
			if(compare.equals(tmp)) {
				System.out.println("yes");
			}else {
				System.out.println("no");
			}
		}
	}
}
