package string_0616;
import java.io.*;

public class Main_백준_2941_크로아티아알파벳 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int ans = 0;
		int idx = 0;
		while(idx < str.length()) {
			char c = str.charAt(idx);
			ans++;
			if(c == 'c') {
				if(idx< str.length()-1 && (str.charAt(idx+1) == '=' || str.charAt(idx+1) == '-')) {
					idx += 2;
				} else {
					idx++;
				}
			} else if(c == 'd') {
				if(idx<str.length()-2 && (str.charAt(idx+1) == 'z' && str.charAt(idx+2) == '=')) {
					idx += 3;
				} else if (idx<str.length()-1 && str.charAt(idx+1) == '-') {
					idx += 2;
				} else {
					idx++;
				}
			} else if (idx<str.length()-1 && c == 'l' && str.charAt(idx+1) == 'j') {
				idx += 2;
			} else if (idx<str.length()-1 && c == 'n' && str.charAt(idx+1) == 'j') {
				idx += 2;
			} else if (idx<str.length()-1 && c == 's' && str.charAt(idx+1) == '=') {
				idx += 2;
			} else if (idx<str.length()-1 && c == 'z' && str.charAt(idx+1) == '=') {
				idx += 2;
			} else {
				idx++;
			}
		}
		System.out.println(ans);
	}

}
