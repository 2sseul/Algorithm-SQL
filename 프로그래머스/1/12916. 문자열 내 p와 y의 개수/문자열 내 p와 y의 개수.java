class Solution {
    boolean solution(String s) {
        int num1 = 0;
        int num2 = 0;
        for(int i=0; i<s.length(); i++){
            if(s.substring(i,i+1).equals("p")||s.substring(i,i+1).equals("P")){
                num1++;
            }else if(s.substring(i,i+1).equals("y")||s.substring(i,i+1).equals("Y")){
                num2++;
            }
        }
        boolean answer = true;
        if(num1==num2){
            answer=true;
        }else{
            answer=false;
        }
        return answer;
    }
}