import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> dq = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            String[] tmp = br.readLine().split(" ");

            String order = tmp[0];

            int number = 0;
            if(tmp.length >= 2){
                number = Integer.parseInt(tmp[1]);
            }

            if(order.equals("push_front")){
                dq.addFirst(number);
            }else if(order.equals("push_back")){
                dq.addLast(number);
            }else if(order.equals("pop_front")){
                if(dq.size()==0){
                    sb.append(-1).append('\n');
                }else{
                    sb.append(dq.getFirst()).append('\n');
                    dq.removeFirst();
                }
            }else if(order.equals("pop_back")){
                if(dq.size()==0){
                    sb.append(-1).append('\n');
                }else{
                    sb.append(dq.getLast()).append('\n');
                    dq.removeLast();
                }
            }else if(order.equals("size")){
                sb.append(dq.size()).append('\n');
            }else if(order.equals("empty")){
                if(dq.size() == 0){
                    sb.append(1).append('\n');
                }else{
                    sb.append(0).append('\n');
                }
            }else if(order.equals("front")){
                if(dq.size() == 0){
                    sb.append(-1).append('\n');
                }else{
                    sb.append(dq.getFirst()).append('\n');
                }
            }else {
                if (dq.size() == 0) {
                    sb.append(-1).append('\n');
                } else {
                    sb.append(dq.getLast()).append('\n');
                }
            }
        }

        System.out.println(sb);
    }
}
