class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown+yellow;
        double tmp = Math.sqrt(total);
        int num = (int) tmp;
        int num1 = 0;
        int num2 = 0;
        int cal = 0;
        int num3 = Integer.MAX_VALUE;
        for(int i=1;i<=num;i++){
            for(int j=1;i*j<=total;j++){
            	if(i*j == total && (i-2)*(j-2)==yellow) {
            		num1 = i;
            		num2 = j;
            	}
            }
        }
        int[] answer = {num2,num1};
        return answer;
    }
}