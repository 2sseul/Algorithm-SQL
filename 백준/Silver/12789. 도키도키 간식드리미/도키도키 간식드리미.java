import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		//한명씩 빠지는 공간 
		Stack<Integer> stack = new Stack<>();
		//줄서있는 공간 
		Queue<Integer> queue = new LinkedList<>();
		
		int N = Integer.parseInt(br.readLine());
		int now = 1;
		int move = N;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			queue.add(Integer.parseInt(st.nextToken()));
		}
		
		while(true) {
			//기존 줄 비어있고 한명씩 서있는 곳에만 사람이 있을 때,
			if(queue.isEmpty()) {
				if(!stack.isEmpty()) {
					if(stack.peek() == now) {
						stack.pop();
						now++;
					}else {
						sb.append("Sad");
						break;
					}
				}else {
					break;
				}
			//기존 줄 비어있지 않을 때,
			}else {
				//기존 줄 첫사람이 뽑아야 하는 사람일 경우 
				if(queue.peek() == now) {
					queue.poll();
					now++;
				//기존 줄 첫사람이 뽑아야 하는 사람이 아닐 경우 
				}else {
					//한명씩 서있는 곳 에서 확인해야함.
					if(!stack.isEmpty()) { 
						//한명씩 서있는 곳에 있구나~
						if(stack.peek() == now) {
							stack.pop();
							now++;
						//엥 여기도 없어? 그럼 못가..
						}else {
							stack.add(queue.poll());
						} 
					//엥 한명씩 서있는 줄도 비어있어? 그럼 너 가서 줄 서!
					}else { 
						stack.add(queue.poll());
					} 
				}
			}

			if(stack.isEmpty() && queue.isEmpty()) {
				sb.append("Nice");
				break;
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();

		

	}
}
