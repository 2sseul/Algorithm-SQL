import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();
        int bridge_weight = 0;
        int time = 0;
        
        //트럭하나하나 체크를 해 줘야 함
        for(int i=0; i<truck_weights.length; i++){
            //트럭이 다리에 올라갈 수 있는지 아닌지 while문으로 체크
            while(true){
                time++;
                //만약 다리에 이미 꽉 차있으면
                if(q.size() == bridge_length){
                    //이전에 넣은 트럭을 빼준다
                    bridge_weight -= q.poll();
                }
                //트럭이 올라갈 수 있네?
                if(bridge_weight + truck_weights[i] <= weight){
                    q.offer(truck_weights[i]);
                    bridge_weight += truck_weights[i];
                    //트럭 올렸으니까 break문으로 빠져나와
                    break;
                //트럭올리면 다리무게 초과야
                }else{
                    //그러면 못올리니까 0을 그냥 넣어줘(시간만 흐르게끔)
                    q.offer(0);
                }
            }
        }
        int answer = time + bridge_length;
        return answer;
    }
}
