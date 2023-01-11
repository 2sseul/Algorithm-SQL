import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		String s = "";
		int cnt = 0;
		while(true) {
			cnt = 0;
			s = sc.nextLine();
			if(s.equals("#")) {
				break;
			}
			for(int i=0;i<s.length();i++) {
				char what = s.charAt(i);
				if(what == 'a'||what == 'e'||what == 'i'||what == 'o'||what == 'u'||what == 'A'||what == 'E'||what == 'I'||what == 'O'||what == 'U') {
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
}
