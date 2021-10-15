package adhoc_0714;
import java.io.*;

public class Main_백준_15927_회문은회문아니야 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int cnt = s.length();
		boolean flag = Palindrome(s, 0, s.length()-1);
		if(flag) {
			boolean allSame = true;
			for(int i=1; i<s.length(); i++) {
				if(s.charAt(i) != s.charAt(i-1)) {
					allSame = false;
					break;
				}
			}
			if(!allSame) cnt--;
			else cnt = -1;
		}
		

		System.out.println(cnt);
	}

	private static boolean Palindrome(String s, int l, int r) {
		while (l < r) {
			if (s.charAt(l) == s.charAt(r)) {
				l++;
				r--;
			} else {
				return false;
			}
		}
		return true;
	}

}
