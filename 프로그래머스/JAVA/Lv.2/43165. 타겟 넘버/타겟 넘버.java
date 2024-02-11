class Solution {
    static int answer = 0;
    static int number[] = null;
    static int targets = 0;
    public int solution(int[] numbers, int target) {
        
        number = numbers;
        targets = target;
        
        calc(0,0);
        
        return answer;
    }
    
    public static void calc(int sum, int index){
        if(index == number.length){
            if(sum == targets){
                answer++;
            }
            return;
        }
        
        calc(sum - number[index], index+1);
        calc(sum + number[index], index+1);
    }
}