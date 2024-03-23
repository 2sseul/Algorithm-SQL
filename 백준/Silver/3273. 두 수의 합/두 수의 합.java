import java.io.*;
import java.util.*;

public class Main {
	static int N, X, ans;
	static List<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		ans = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			list.add(Integer.parseInt(st.nextToken())); 
		}
		
		X = Integer.parseInt(br.readLine());
		
		Collections.sort(list);
		
		for(int i=0; i<N-1; i++) {
			Check(i, list.get(i), i+1, N-1);
		}
		
		sb.append(ans);
		
		bw.write(sb.toString()); bw.flush(); bw.close();
	}
	static void Check(int num, int x, int start, int end) {
		
		while(start <= end) {
			int mid = (start + end) / 2;
			
			if(x+list.get(mid) == X) {
				ans++;
				break;
			}else if(x+list.get(mid) > X) {
				end = mid-1;
			}else {
				start = mid+1;
			}

		}
	}
}
