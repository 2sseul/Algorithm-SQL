import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> map = new HashMap<>();
		List<String> list = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String S = st.nextToken();
		String E = st.nextToken();
		String Q = st.nextToken();
		
		String S_time = S.substring(0, 2);
		String S_min = S.substring(3, 5);
		String E_time = E.substring(0, 2);
		String E_min = E.substring(3, 5);
		String Q_time = Q.substring(0, 2);
		String Q_min = Q.substring(3, 5);
		
		int StartTime = ((S_time.charAt(0)-48)*10+(S_time.charAt(1)-48))*60 + (S_min.charAt(0)-48)*10+(S_min.charAt(1)-48);
		int EndTime = ((E_time.charAt(0)-48)*10+(E_time.charAt(1)-48))*60 + (E_min.charAt(0)-48)*10+(E_min.charAt(1)-48);
		int QuiteTime = ((Q_time.charAt(0)-48)*10+(Q_time.charAt(1)-48))*60 + (Q_min.charAt(0)-48)*10+(Q_min.charAt(1)-48);

		String who = "";
		
		while((who = br.readLine())!=null && !who.isEmpty()) {
			String chat = who.substring(0,5);
			
			String chat_time = chat.substring(0, 2);
			String chat_min = chat.substring(3, 5);
			
			int chatting = ((chat_time.charAt(0)-48)*10+(chat_time.charAt(1)-48))*60 + (chat_min.charAt(0)-48)*10+(chat_min.charAt(1)-48);
			
			String nickname = who.substring(6);
			
			if(chatting <= StartTime) {
				map.put(nickname, 1);
			}
			
			if(chatting >= EndTime && chatting <= QuiteTime) {
				if(map.containsKey(nickname)) {
					map.put(nickname, map.get(nickname)+1);
				}
			}
		}
		
		int ans = 0;
		if(map.size()!=0) {
			
			list.addAll(map.keySet());
			
			for(int i=0;i<list.size();i++) {
				if(map.get(list.get(i))>=2) {
					ans++;
				}
			}
		}
		
		System.out.println(ans);
		
	}
}
