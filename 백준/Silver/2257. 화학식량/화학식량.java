import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		int size = 0;
		//숫자 나올 시 곱해줘야해서 num 저장 
		int num = 0;
		
		int arr[] = new int[s.length()];
		
		for(int i=0;i<s.length();i++) {
			char what = s.charAt(i);
			if(what=='(') {
				size += 1;
				arr[size] = 0;
			}else if(what==')') {
				num = arr[size];
				size--;
				arr[size]+=num;
			}else if(what == 'H') {
				num = 1;
				arr[size] += 1;
			}else if(what == 'C') {
				num = 12;
				arr[size] += 12;
			}else if(what == 'O') {
				num = 16;
				arr[size] += 16;
			//숫자일 경우 
			}else {
				arr[size] += num * (what - 49);
			}
		}
		System.out.println(arr[0]);	
		
	}
}
