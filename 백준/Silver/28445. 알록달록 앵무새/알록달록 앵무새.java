import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		List<String> list = new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<2; j++) {
				String tmp = st.nextToken();
				if(!list.contains(tmp)) {
					list.add(tmp);
				}
			}
		}
		
		String[][] answer = new String[list.size()*list.size()][2];
		int cnt = 0;
		for(int i=0; i<list.size(); i++) {
			String one = list.get(i);
			for(int j=0; j<list.size(); j++) {
				String two = list.get(j);
				answer[cnt][0]=one;
				answer[cnt][1]=two;
				cnt++;
			}
		}
		
		Arrays.sort(answer, new Comparator<String[]>() {
			
            @Override
            public int compare(String[] o1, String[] o2) {
                if(o1[0].toString().contentEquals(o2[0].toString()))
                    return o1[1].toString().compareTo(o2[1].toString());
                else
                    return o1[0].toString().compareTo(o2[0].toString());
            }			
        });
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<list.size()*list.size(); i++) {
			for(int j=0; j<2; j++) {
				sb.append(answer[i][j]);
				if(j!=1) {
					sb.append(" ");
				}
			}
			if(i!=list.size()*list.size()-1) {
				sb.append('\n');
			}
		}
		
		System.out.println(sb);
	}
}
