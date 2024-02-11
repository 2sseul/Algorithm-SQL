class Solution {
    public String solution(int n) {
        String answer = "";
        String[] arr = {"수","박"};
        for(int i=0; i<n; i++){
            answer+=arr[i%2];
        }
        return answer;
    }
}