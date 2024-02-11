import java.io.*;
import java.util.*;

class Solution {
    static String standard[] = {"code", "date", "maximum", "remain"};
    static int check = 0;
    static int sort = 0;
    static int cnt = 0;
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<standard.length; i++){
            if(standard[i].equals(sort_by)){
                sort = i;
            }
            if(standard[i].equals(ext)){
                check = i;
            }
        }
        
        for(int i=0; i<data.length; i++){
            if(data[i][check] < val_ext){
                cnt++;
                list.add(data[i][sort]);
            }
        }
        
        Collections.sort(list);
        
        int answer[][] = new int[list.size()][4];
        
        for(int i=0; i<data.length; i++){
            for(int j=0; j<data[1].length; j++){
                for(int k=0; k<list.size(); k++){
                    if(data[i][sort] == list.get(k)){
                        answer[k][j] = data[i][j];
                    }
                }
            }
        }
        
        return answer;
    }
}