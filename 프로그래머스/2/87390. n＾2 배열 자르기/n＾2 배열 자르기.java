import java.io.*;
import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int n, long left, long right) {
        ArrayList<Integer> list = new ArrayList<>();
        for(long i = left; i <= right; i++){
            long quo = i / n;
            long mod = i % n;
            list.add(Math.max((int)quo+1, (int)mod+1));
        }

        return list;
    }
}