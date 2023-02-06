import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Map<String,Integer> map = new TreeMap<>();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			if(s.length()>=M&&map.containsKey(s)) {
				map.put(s, map.get(s)+1);
			}else if(s.length()>=M&&!map.containsKey(s)) {
				map.put(s, 1);
			}
		}
		
		List<String> list = map.keySet().stream().collect(Collectors.toList());
		list.sort((s1,s2)->{
			int num1 = map.get(s1);
			int num2 = map.get(s2);
			
			if(num1 == num2) {
				if(s1.length() == s2.length()) {
					return s1.compareTo(s2);
				}
				return s2.length()-s1.length();
			}
			return num2-num1;
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<list.size();i++) {
			sb.append(list.get(i)).append('\n');
		}
		System.out.println(sb.toString());
		
	}
}
