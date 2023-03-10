class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        
        int n = absolutes.length;
		
		int ans = 0;
		
		for(int i=0;i<n;i++) {
			if(!signs[i]) {
				ans+= absolutes[i]*-1;
			}else {
				ans+= absolutes[i];
			}
		}
		
        return ans;
    }
}