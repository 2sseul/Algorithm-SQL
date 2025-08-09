import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        // 하나씩 확인해보면서 넘어가야함.
        // 어떻게 하나씩 확인해볼까? 제일 최소값은 어떻게 선정하는 것이 좋을까
        // 자릿수가 3자리수라면 나올 수 있는 최대 자릿수의 합은 27(9*3)
        // 그럼 될 수 있는 최소 생성자는 N - 27
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int len = Integer.toString(N).length();
        int answer = 0;

        int start = N - len*9;

        for(int i=start; i<N; i++){
            int tmp = i;
            int sum = 0;
            for(int j=0; j<len; j++){
                sum += (tmp % 10);
                tmp /= 10;
            }
            if(sum+i == N){
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }
}