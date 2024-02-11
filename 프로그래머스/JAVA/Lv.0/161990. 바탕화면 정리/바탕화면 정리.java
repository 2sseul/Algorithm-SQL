import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        
        int N = wallpaper.length;
        int length = wallpaper[0].length();
		 
		 char[][] directory = new char[N][length];
		 for(int i=0;i<N;i++) {
			 directory[i] = wallpaper[i].toCharArray();
		 }
        
         int minXX = Integer.MAX_VALUE;
		 int minYY = Integer.MAX_VALUE;
		 int maxXX = Integer.MIN_VALUE;
		 int maxYY = Integer.MIN_VALUE;
		 for(int i=0;i<N;i++) {
			 for(int j=0;j<length;j++) {
				 if(directory[i][j]=='#') {
					 minXX = Math.min(minXX, i);
					 minYY = Math.min(minYY, j);
					 maxXX = Math.max(maxXX, i+1);
					 maxYY = Math.max(maxYY, j+1);
				 }
			 }
		 }
		 
		int arr[] = {minXX, minYY, maxXX, maxYY};
        return arr;
    }
}