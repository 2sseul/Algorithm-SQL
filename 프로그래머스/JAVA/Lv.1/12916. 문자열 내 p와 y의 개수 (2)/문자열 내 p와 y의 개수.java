class Solution {
    boolean solution(String s) {
        int length = s.length();
        int cnt1 = 0;
        int cnt2 = 0;
        for(int i=0; i<length; i++){
            if(s.substring(i,i+1).equals("y")||s.substring(i,i+1).equals("Y")){
                cnt1++;
            }else if(s.substring(i,i+1).equals("p")||s.substring(i,i+1).equals("P")){
                cnt2++;
            }
        }
        
        boolean answer = true;
        if(cnt1 != cnt2){
            answer = false;
        }

        return answer;
    }
}