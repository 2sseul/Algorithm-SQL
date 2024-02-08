import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static StringBuilder sb = new StringBuilder();
	static String sentences[] = {"\"재귀함수가 뭔가요?\"", "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어."
			,"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.", "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\""
			,"라고 답변하였지."};
	static String answer[] = {"\"재귀함수가 뭔가요?\"", "\"재귀함수는 자기 자신을 호출하는 함수라네\"", "라고 답변하였지."};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		First();
		
		Go(N, 1);
		
		System.out.println(sb.toString());
	}
	static void First() {
		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.").append('\n');
	}
	
	static void Go(int N, int count) {
		for(int i=0; i<sentences.length; i++) {
			underBar(count);
			sb.append(sentences[i]).append('\n');
			
			if(i == 3) {
				if(N == count) {
					Answer(count);
				}else {
					Go(N, count+1);
					
				}
			}
			
			if(i == 4) {
				return;
			}
		}
		
	}
	
	static void underBar(int count) {
		if(count-1 == 0) {
			return;
		}
		for(int i=0; i<4*(count-1); i++) {
			sb.append("_");
		}
	}
	
	static void Answer(int count) {
		for(int i=0; i<answer.length; i++) {
			underBar(count+1);
			sb.append(answer[i]).append('\n');
		}
	}
}
