import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = Integer.valueOf(sc.next());
		//System.out.println(N);
		long arr[] = new long[N];
		
		for(int i=0; i<N; i++) {
			StringBuilder sb = new StringBuilder(sc.next());
			arr[i] = Long.valueOf(sb.reverse().toString());
		}
		Arrays.sort(arr);
		
		for(int i=0; i<N; i++) {
			System.out.println(arr[i]);
		}
	}
}
