import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<Long,Integer> number = new HashMap<>();
		List<Long> list = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());
		
		long arr[] = new long[N];
		
		for(int i=0;i<N;i++) {
			arr[i]= Long.parseLong(br.readLine());
		}
		
		int max = 1;
		long num = 0;
		for(int i=0;i<N;i++) {
			int cnt = 1;
			if(number.containsKey(arr[i])) {
				cnt = number.get(arr[i])+1;
				number.put(arr[i], cnt);
				if(cnt>=max) {
					max = cnt;
				}
			}else {
				number.put(arr[i], cnt);
			}
		}
		
		for(long key : number.keySet()) {
			if(number.get(key)==max) {
				list.add(key);
			}
		}
		
		Collections.sort(list);
		
		
		System.out.println(list.get(0));
		
	}
}
