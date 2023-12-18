import java.util.*;

class Solution {
    static boolean decimal[];
    static int length;
    static String number = "";
    static List<Integer> list = new ArrayList<>();
    public int solution(String numbers) {        
        decimal = new boolean[10000000]; 
        
        decimal[0] = decimal[1] = true;
        
        for(int i=2; i*i<10000000; i++){
            if(!decimal[i]){
            	for(int j=i*i; j<10000000; j+=i) decimal[j] = true;                
            }        
        }
        
        //부분집합 만들기
        length = numbers.length();
        String[] arr = numbers.split("");
        String[] output = new String[length];
        boolean[] checked = new boolean[length];
        for(int i=0; i<length; i++){
            dfs(0, i+1, arr, checked, output);   
        }
        
        int answer = 0;
        
        for(int i=0; i<list.size(); i++){
            if(!decimal[list.get(i)]){
                //System.out.println(list.get(i));
                answer++;
            }
        }

        return answer;
    }
    
    public static void dfs(int L, int howLong, String[] arr, boolean[] checked, String[] output){
        if(L == howLong){
            for(int i=0; i<howLong; i++){
                number+=output[i];
            }
            if(!list.contains(Integer.valueOf(number))){
                list.add(Integer.valueOf(number));
            }
            number="";
            return;
        } 
        for (int i=0; i<arr.length; i++) {
            if (!checked[i]) {
                checked[i] = true;
                output[L] = arr[i];
                dfs(L+1, howLong, arr, checked, output);       
                checked[i] = false;
            }
    }
    }
}