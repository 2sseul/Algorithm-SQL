import java.util.*;
import java.io.*;

class Solution {
    public int solution(int a, int b, int n) {
        
        int num = 0;
		int count = n;
		int per = 0;
		
		while(true) {
			int coke = count/a;	//빈병이랑 바꿔오는 콜라 새거
			count = count - (a*coke) + coke*b + per;  //전체 콜라병 
			num += coke*b;
			if(count < a) {
				break;
			}
        }

        return num;
    }
}