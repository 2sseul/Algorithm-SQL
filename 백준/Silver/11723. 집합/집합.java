import java.io.*;
import java.util.*;

public class Main {
	static boolean[] number;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		number = new boolean[21];
		
		for(int tc=0; tc<N; tc++) {
			String tmp[] = br.readLine().split(" ");
			String command = tmp[0];
			int num = 0;
			if(tmp.length == 2) {
				num = Integer.valueOf(tmp[1]);
			}
			
			switch (command) {
			case "add": {
				Add(num);
				break;
			}case "remove": {
				Remove(num);
				break;
			}case "check":{
				Check(num);
				break;
			}case "toggle":{
				Toggle(num);
				break;
			}case "all":{
				All();
				break;
			}
			default:
				Empty();
				break;
			}
		}
		
		System.out.println(sb.toString());
		
	}
	static void Empty() {
		Arrays.fill(number, false);
	}
	static void All() {
		Arrays.fill(number, true);
	}
	static void Toggle(int n) {
		if(number[n]) {
			number[n] = false;
		}else {
			number[n] = true;
		}
	}
	static void Check(int n) {
		if(number[n]) {
			sb.append("1").append('\n');
		}else {
			sb.append("0").append('\n');
		}
	}
	static void Remove(int n) {
		if(number[n]) {
			number[n] = false;
		}else {
			return;
		}
	}
	static void Add(int n) {
		if(!number[n]) {
			number[n] = true;
		}else {
			return;
		}
	}
}
