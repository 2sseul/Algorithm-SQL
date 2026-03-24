import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=N; i++){
            list.add(i);
        }

        int start = 0;
        int end = N-1;
        int maxLen = list.size();

        sb.append("<");
        while(list.size()!=1){
            int popNum = start+K-1;
            if(popNum >= maxLen){
                popNum %= maxLen;
            }
            sb.append(list.get(popNum)+", ");
            list.remove(list.get(popNum));
            // System.out.println(list);
            maxLen = list.size();
            start = popNum;
            if(start >= N){
                start %= maxLen;
            }
            // System.out.println(start);
        }
        sb.append(list.get(0)+">");
        System.out.println(sb);
    }
}
