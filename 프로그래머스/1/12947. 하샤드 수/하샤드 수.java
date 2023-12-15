class Solution {
    public boolean solution(int x) {
        String number = String.valueOf(x);
        int sum = 0;
        for(int i=0; i<number.length(); i++){
            sum+=Integer.valueOf(number.substring(i,i+1));
        }
        boolean answer = true;
        if(x%sum==0){
            answer = true;
        }else{
            answer = false;
        }
        return answer;
    }
}