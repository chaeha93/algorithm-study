package string_0616;
import java.io.*;

public class Main_백준_1157_단어공부 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int[] alphabet = new int[26];
		for(int i=0; i<s.length(); i++) {
			Character c = s.charAt(i);
			if((int)c >= 97) {
				alphabet[(int)c - 97]++;
				continue;
			}
			alphabet[(int)c-65]++;
		}
		int max = 0;
		int index = 0;
		for(int i=0; i<26; i++) {
			if(max < alphabet[i]) {
				max = alphabet[i];
				index = i;
			}
		}
		int cnt = 0;
		boolean flag = false;
		for(int i=0; i<26; i++) {
			if(max == alphabet[i]) {
				cnt++;
				if(cnt >= 2) flag = true;
			}
		}
		if(flag) {
			System.out.println("?");
		} else {
			System.out.println((char)(index+65));
		}

	}

}
