import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<T; i++){
            String sentence = br.readLine();
            for(int j=0; j<sentence.length(); j++){

                if(stack.isEmpty()){
                    stack.push(sentence.charAt(j));
                }else if(stack.peek() == '(' && sentence.charAt(j) == '('){
                    stack.push(sentence.charAt(j));
                }else{
                    char tmp = stack.peek();
                    if(tmp == '(' && sentence.charAt(j) == ')'){
                        stack.pop();
                    }
                }
            }
            if(stack.size() == 0){
                sb.append("YES").append('\n');
            }else{
                sb.append("NO").append('\n');
            }
            stack.clear();
        }

        System.out.println(sb);
    }
}
