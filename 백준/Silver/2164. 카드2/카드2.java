import java.io.*;
import java.util.*;

// 1. 제일 위 카드 버리기
// 2. 그 다음 제일 위 카드를 제일 아래에 있는 카드 밑으로 옮기기
// 3. 제일 마지막에 남는 카드 번호를 출력

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> dq = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        for(int i=1; i<=N; i++){
            dq.add(i);
        }

        while(dq.size() > 1){
            dq.pop(); // 1. 제일 위 카드 버리기

            int top = dq.pop(); // 2-1. 그 다음 제일 위 카드를
            dq.addLast(top); // 2-2. 제일 아래에 있는 카드 밑으로 옮기기
        }

        System.out.println(dq.pop()); // 3. 제일 마지막에 남는 카드 번호 출력
    }
}
