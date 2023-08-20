
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String word = br.readLine();
		
		int length = word.length();
		
		String arr[] = new String[length];
		for(int i=0; i<length; i++) {
			arr[i] = word.substring(i,length);
		}
		
		Arrays.sort(arr);
		
		for(int i=0; i<length; i++) {
			System.out.println(arr[i]);
		}
	}
}
