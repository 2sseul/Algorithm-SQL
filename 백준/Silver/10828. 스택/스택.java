import java.io.*;
import java.util.*;

public class Main {
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            String tmp[] = br.readLine().split(" ");

            String order = tmp[0];
            int number = 0;
            if(tmp.length >= 2){
                number = Integer.parseInt(tmp[1]);
            }

            if(order.equals("push")){
                stack.push(number);
            }else if(order.equals("pop")){
                if(stack.isEmpty()){
                    sb.append(-1).append('\n');
                }else{
                    int pop = stack.pop();
                    sb.append(pop).append('\n');
                }
            }else if(order.equals("size")){
                sb.append(stack.size()).append('\n');
            }else if(order.equals("empty")){
                if(stack.isEmpty()){
                    sb.append(1).append('\n');
                }else{
                    sb.append(0).append('\n');
                }
            }else if(order.equals("top")) {
                if (stack.isEmpty()) {
                    sb.append(-1).append('\n');
                } else{
                    sb.append(stack.peek()).append('\n');
                }
            }
        }
        System.out.println(sb);
    }
}
