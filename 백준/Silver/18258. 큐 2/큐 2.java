import java.io.*;
import java.util.*;

public class Main {
    static Deque<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++){
            String[] tmp = br.readLine().split(" ");
            String order = tmp[0];
            int num = 0;
            if(tmp.length >= 2) {
                num = Integer.parseInt(tmp[1]);
            }

            if(order.equals("push")){
                q.add(num);
            }else if(order.equals("pop")){
                if(!q.isEmpty()){
                    int popNum = q.poll();
                    sb.append(popNum).append('\n');
                }else{
                    sb.append(-1).append('\n');
                }
            }else if(order.equals("size")){
                sb.append(q.size()).append('\n');
            }else if(order.equals("empty")){
                if(!q.isEmpty()){
                    sb.append(0).append('\n');
                }else{
                    sb.append(1).append('\n');
                }
            }else if(order.equals("front")){
                if(!q.isEmpty()){
                    sb.append(q.peekFirst()).append('\n');
                }else{
                    sb.append(-1).append('\n');
                }
            }else if(order.equals("back")){
                if(!q.isEmpty()){
                    sb.append(q.peekLast()).append('\n');
                }else{
                    sb.append(-1).append('\n');
                }
            }
        }
        System.out.println(sb);
    }
}
