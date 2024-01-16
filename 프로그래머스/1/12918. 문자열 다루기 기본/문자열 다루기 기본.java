class Solution {
    public boolean solution(String s) {
        boolean answer = false;
        boolean check1 = false;
        boolean check2 = true;
        if(s.length() == 4 || s.length() == 6){
            check1 = true;
        }
        char arr[] = s.toCharArray();
        for(int i=0; i<s.length(); i++){
            if(arr[i] >= 65){
                check2 = false;
                break;
            }
        }
        
        if(check1 && check2){
            answer = true;
        }
        return answer;
    }
}