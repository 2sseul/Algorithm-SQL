import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int left = 0, right = arr.length-1;
		int sum = 0, cnt = 0;
		while(right > left) {
			sum = arr[left] + arr[right];
			if(sum <= M) {
				left++;
			}else {
				right--;
			}
			if(sum == M) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
