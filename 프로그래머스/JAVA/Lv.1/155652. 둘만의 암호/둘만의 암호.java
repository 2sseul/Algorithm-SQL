class Solution {
    public String solution(String s, String skip, int index) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for(int i=0; i<skip.length(); i++){
            alphabet = alphabet.replace(skip.charAt(i)+"", "!");
        }
        String answer = "";
        for(int i=0; i<s.length(); i++){
            int num = s.charAt(i)-'a';
            int count = 0;
            while(true){
                if(count == index){
                    break;
                }
                num = (num+1)%26;
                if(alphabet.charAt(num) == '!'){
                    continue;
                }else{
                    count++;
                }
            }
            answer+=((char)(num+'a')+"");
        }
        return answer;
    }
}