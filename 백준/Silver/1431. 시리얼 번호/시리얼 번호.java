import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		PriorityQueue<String[]> pq = new PriorityQueue<>(new Comparator<>() {
			public int compare(String[] o1, String[] o2) {
				if(o1[0].length() < o2[0].length()) {
					return -1;
				}else if(o1[0].length() > o2[0].length()) {
					return 1;
				}else {
					if(Integer.parseInt(o1[1]) < Integer.parseInt(o2[1])) {
						return -1;
					}else if(Integer.parseInt(o1[1]) > Integer.parseInt(o2[1])) {
						return 1;
					}else {
						return o1[0].compareTo(o2[0]);
					}
				}
			}
		});
		
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<N; tc++) {
			String tmp = br.readLine();
			int num = 0;
			for(int i=0; i<tmp.length(); i++) {
				if(tmp.charAt(i)<58) {
					num += tmp.charAt(i)-48;
				}
			}
			String arr[] = {tmp, num+""};
			pq.offer(arr);
			num = 0;
		}
		
		while(!pq.isEmpty()) {
			String tmp[] = pq.poll();
			sb.append(tmp[0]).append('\n');
		}
		
		bw.write(sb.toString());
		bw.close();
	}
}
