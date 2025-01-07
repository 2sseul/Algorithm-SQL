class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String binary_k = Long.toString(n, k);
        binary_k = binary_k.replaceAll("0", " ");
        
        String binary[] = binary_k.split("\\s+");
        for(int i=0; i<binary.length; i++){
            long num = Long.valueOf(binary[i]);
            boolean flag = isPrime(num);
            if(!flag){
                answer++;
            }
        }
        
        return answer;
    }
    static boolean isPrime(long n){
        if(n == 1){
            return true;
        }
        long sqrt = (long) Math.sqrt(n) + 1;
        for(int i=2; i<sqrt; i++){
            if(n%i == 0){
                return true;
            }
        }
        return false;
    }
}