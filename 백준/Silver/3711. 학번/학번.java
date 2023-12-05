import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> isSame = new ArrayList<>();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			int howMany = Integer.parseInt(br.readLine());
			int remainder[] = new int[howMany];
			int num = 2;
			int small = Integer.MAX_VALUE;
			isSame.clear();
			for(int arr=0; arr<howMany; arr++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				remainder[arr] = Integer.parseInt(st.nextToken());
			}
			
			if(howMany == 1) {
				small = 1;
			}else {
				loop1:
					while(true) {
						for(int j=0; j<howMany; j++) {
							if(!isSame.contains(remainder[j]%num)) {
								isSame.add(remainder[j]%num);
							}
						}
						if(isSame.size()!=howMany) {
							isSame.clear();
							small = Integer.MAX_VALUE;
							num++;
						}else {
							for(int j=0; j<howMany; j++) {
								small = Math.min(small, num);
							}
							break loop1;
						}
					}
			}
			System.out.println(small);	
		}	
	}
}
