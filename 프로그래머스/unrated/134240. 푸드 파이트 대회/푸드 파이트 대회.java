class Solution {
    public String solution(int[] food) {
        		int length = food.length;
		
		String ans1 = "";
		
		for(int i=1; i<length; i++) {
			int num = food[i]/2;
			for(int j=0;j<num;j++) {
				ans1 = ans1 + i;
			}
		}
		ans1 = ans1;
		
		String ans2 = "";
		for(int i=ans1.length()-1;i>=0;i--) {
			ans2 += ans1.charAt(i);
		}
        
        String answer = ans1+"0"+ans2;
		
		return answer;
    }
}