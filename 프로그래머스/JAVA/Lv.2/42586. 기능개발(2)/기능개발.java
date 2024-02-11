import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int howLong[] = new int[progresses.length];
        for(int i=0; i<progresses.length; i++){
            int tmp = (100-progresses[i])%speeds[i];
            howLong[i] = ((100-progresses[i])/speeds[i]);
            if(tmp!=0){
                howLong[i] = ((100-progresses[i])/speeds[i])+1;
            }
        }
        
        System.out.println(Arrays.toString(howLong));
        
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for(int i=0; i<howLong.length; i++){
            if(stack.isEmpty()){
                stack.add(howLong[i]);
            }else{
                int tmp = stack.peek();
                if(tmp>=howLong[i]){
                    count++;
                }else if(tmp<howLong[i]){
                    count++;
                    answer.add(count);
                    count = 0;
                    stack.pop();
                    stack.add(howLong[i]);
                }
            }
        }
        
        answer.add(count+1);
        
        return answer;
    }
}