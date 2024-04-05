import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		 
		List<Integer> arr2 = new ArrayList<>();
		
		String tmp1 = br.readLine();
		String tmp2 = br.readLine();
		
		for(int i=0; i<8; i++) {
			arr2.add(Integer.parseInt(tmp1.substring(i,i+1)));
			arr2.add(Integer.parseInt(tmp2.substring(i,i+1)));
		}
		
		while(true) {
			int len = arr2.size();
			if(len == 2) {
				break;
			}
			String tmp = "";
			for(int i=0; i<len-1; i++) {
				int num = (arr2.get(i)+arr2.get(i+1))%10;
				tmp += String.valueOf(num);
			}
			arr2.clear();
			for(int i=0; i<tmp.length(); i++) {
				arr2.add(Integer.parseInt(tmp.substring(i, i+1)));
			}
		}
		if(arr2.get(0)==0) {
			sb.append(0).append(String.valueOf(arr2.get(1)));
		}else {
			sb.append(Integer.valueOf(arr2.get(0))*10+Integer.valueOf(arr2.get(1)));
		}
		
		bw.write(sb.toString());
		bw.close();
	}
}
