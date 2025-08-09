import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    static int now = 0;
    static LinkedList<String> list = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        // 만약 지금 내가 KBS1이 아니라면 현재 선택한 채널을 한 칸 아래로 내린다(3) KBS1이 다음에 올 때까지
        // KBS1을 맨 위까지 올리고, 아래칸으로 하나 내려온 뒤 KBS2가 나올 때까지 화살표를 아래로 내린다.
        // KBS2를 만나면 현재 선택한 채널을 한 칸 위로 올린다(1)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            list.add(i, br.readLine());
        }

        // KBS1을 찾을 때까지 아래로 내려간다.
        // KBS1을 찾으면 화살표를 아래로 한칸 내린 뒤(1), 현재 선택한 채널을 0번까지 위로 계속 올린다(4)
        if(!list.get(0).equals("KBS1")){
            findKBS(0, 0, list, "KBS1");
            if(!list.get(1).equals("KBS2")){
                findKBS(0, 1, list, "KBS2");
            }else{
                sb.append(1);
            }
        }else{
            // KBS2를이제 1번에 배치해야한다.
            // KBS1을 배치했으면 우선 화살표를 아래로 한칸 내리고(1) KBS2인지 확인한다.
            if(!list.get(1).equals("KBS2")){
                findKBS(0, 1, list, "KBS2");
            }else{
                sb.append(1);
            }
        }

        System.out.println(sb.toString());
    }
    static void findKBS(int now, int goal, LinkedList<String> channel, String target){
        while(true) {
            // 현재 채널 아래가 target이면, 다음 채널을 0번째까지 올린다.
            if(channel.get(now+1).equals(target) && now+1 != goal){
                sb.append(1); // 화살표를 아래로 내린다.
                now += 1;
                channel.remove(target);
                for(int i=0; i<now-goal; i++){
                    sb.append(4);
                }
                channel.add(goal, target);
                break;
            }else{
                // 현재 채널 아래가 target이 아니면, 계속 내려가야지!
                sb.append(1);
                now += 1;
            }
        }
    }
}
