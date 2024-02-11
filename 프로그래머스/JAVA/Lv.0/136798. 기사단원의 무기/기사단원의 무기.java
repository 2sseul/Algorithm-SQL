class Solution {
    public int solution(int number, int limit, int power) {
        int cnt = 1;
		int count = 0;
		int ans = 0;
		
		while(cnt!=number+1) {
			for(int i=1; i*i<=cnt;i++) {
				if(i*i == cnt) {
					count++;
				}else if(cnt%i==0) {
					count+=2;
				}
			}
			cnt++;
			if(count>limit) {
				count = power;
			}
			ans+=count;
			count = 0;
		}
		
        return ans;
    }
}