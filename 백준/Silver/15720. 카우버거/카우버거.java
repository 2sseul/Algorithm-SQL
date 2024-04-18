import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> hamQ = new PriorityQueue<>(new Comparator<>() {
			public int compare(Integer o1, Integer o2) {
				if(o1 < o2) {
					return 1;
				}else if(o1 > o2) {
					return -1;
				}else {
					return 0;
				}
			}
		});
		
		PriorityQueue<Integer> sideQ = new PriorityQueue<>(new Comparator<>() {
			public int compare(Integer o1, Integer o2) {
				if(o1 < o2) {
					return 1;
				}else if(o1 > o2) {
					return -1;
				}else {
					return 0;
				}
			}
		});
		
		PriorityQueue<Integer> drinkQ = new PriorityQueue<>(new Comparator<>() {
			public int compare(Integer o1, Integer o2) {
				if(o1 < o2) {
					return 1;
				}else if(o1 > o2) {
					return -1;
				}else {
					return 0;
				}
			}
		});
		
		int num = Integer.MAX_VALUE;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		num = Math.min(H, Math.min(S, Math.min(D, num)));
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<H; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			hamQ.offer(tmp);
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<S; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			sideQ.offer(tmp);
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<D; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			drinkQ.offer(tmp);
		}
		
		int sum = 0;
		for(int i=0; i<num; i++) {
			int h = hamQ.poll();
			int s = sideQ.poll();
			int d = drinkQ.poll();
			sum += (h+s+d);
		}
		
		int el = 0;
		if(!hamQ.isEmpty()) {
			while(!hamQ.isEmpty()) {
				el += hamQ.poll();
			}
		}
		if(!sideQ.isEmpty()) {
			while(!sideQ.isEmpty()) {
				el += sideQ.poll();
			}
		}
		if(!drinkQ.isEmpty()) {
			while(!drinkQ.isEmpty()) {
				el += drinkQ.poll();
			}
		}
		
		sb.append(sum+el).append('\n').append((int)(sum*0.9)+el);
		bw.write(sb.toString());
		bw.close();
	}
}
