import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String sentence = br.readLine();
		
		String wrong[] = {"apa", "epe", "ipi", "opo", "upu"};
		String right[] = {"a", "e", "i", "o", "u"};
		
		for(int i=0; i<5; i++) {
			sentence = sentence.replaceAll(wrong[i], right[i]);
		}
		
		System.out.println(sentence);
		
	}
}
