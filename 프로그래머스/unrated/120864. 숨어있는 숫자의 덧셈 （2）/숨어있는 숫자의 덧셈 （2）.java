import java.util.*;

class Solution {
    public int solution(String my_string) {
        String tmp = my_string.toUpperCase().replaceAll("A|B|C|D|E|F|G|H|I|J|K|L|M|N|O|P|Q|R|S|T|U|V|W|X|Y|Z"," ");
        String arr[] = tmp.split("\\s");
        int answer = 0;
        System.out.println(Arrays.toString(arr));
        for(int i=0; i<arr.length; i++){
            if(arr[i].equals("")){
                continue;
            }
            arr[i] = arr[i].trim();
           answer += Integer.parseInt(arr[i]); 
        }
        return answer;
    }
}