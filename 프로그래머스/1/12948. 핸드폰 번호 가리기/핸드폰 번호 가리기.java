class Solution {
    public String solution(String phone_number) {
        String num = phone_number.substring(phone_number.length()-4,phone_number.length());
        String answer = phone_number.replaceAll("[0123456789]","*").substring(0,phone_number.length()-4)+num;
        return answer;
    }
}