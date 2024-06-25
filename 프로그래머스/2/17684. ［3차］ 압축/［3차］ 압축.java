import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    static int ascii, idx, i;
    static String before, tmp;
    static Map<String, Integer> map;
    static List<Integer> list;
    public List<Integer> solution(String msg) {
        map = new HashMap<>();
        list = new ArrayList<>();
        ascii = 65;
        for(int j=1;j<=26;j++) {
            map.put(String.valueOf((char)ascii),j);
            ascii++;
        }
        idx = 27;
        tmp = String.valueOf(msg.charAt(0));
        i=1;
        boolean check = false;
        while(true) {
            if(i == msg.length()){
                if(!map.containsKey(tmp)){
                    map.put(tmp, idx);
                    list.add(map.get(before));
                    before="";
                    tmp = tmp.substring(tmp.length()-1,tmp.length());
                    idx++;
                    i -= 1;
                    check = true;
                }else{
                    list.add(map.get(tmp));
                    break;
                }
            }
            if(map.containsKey(tmp)) {
                //before: 이전까지 최장 문자열
                before = tmp;
                if(!check){
                    //tmp: 새로 넣어야될 단어
                    tmp+=String.valueOf(msg.charAt(i));
                }
                //i를 사용해서 맨 뒤에 붙여야할 문자를 지정해줌.
                i++;
            }
            //만약 사전에 없으면,
            else {
                //이전까지의 최장 문자열 숫자를 정답에 넣어
                list.add(map.get(before));
                //그리고 이전까지의 문자열 초기화
                before="";
                //그리고 사전에 새로 넣어야할 단어를 넣어줘
                map.put(tmp, idx);
                //그리고 tmp의 맨 끝에 있는 단어로 잘라.
                tmp = tmp.substring(tmp.length()-1,tmp.length());
                //사전 숫자++
                idx++;
            }
        }
        return list;
    }
}