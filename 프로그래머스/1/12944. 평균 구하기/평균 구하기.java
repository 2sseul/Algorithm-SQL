class Solution {
    public double solution(int[] arr) {
        double num = 0;
        for(int i=0; i<arr.length; i++){
            num+= arr[i];
        }
        double answer = num/arr.length;
        return answer;
    }
}