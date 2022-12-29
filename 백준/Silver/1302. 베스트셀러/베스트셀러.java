import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		HashMap<String, Integer> books = new HashMap<>();
		List<String> list = new ArrayList<>();
		
		String arr[] = new String[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = br.readLine();
		}
		
		int max = 0;
		for(int i=0;i<N;i++) {
			int cnt = 1;
			if(books.containsKey(arr[i])) {
				cnt = books.get(arr[i])+1;
			}
			books.put(arr[i], cnt);
			if(max < cnt) {
				max = cnt;
			}
		}
		
		for(String key : books.keySet()) {
			if(books.get(key).equals(max)) {
				list.add(key);
			}
		}
		
		Collections.sort(list);
		
		System.out.println(list.get(0));
	}
}
