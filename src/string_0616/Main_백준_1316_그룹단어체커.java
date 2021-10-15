package string_0616;
import java.io.*;
import java.util.*;

public class Main_백준_1316_그룹단어체커 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		for(int n=1; n<=N; n++) {
			int[] letters = new int[26];
			String s = br.readLine();
			boolean flag = true;
			for(int i=0; i<s.length(); i++) {
				int asc = (int)(s.charAt(i)-97);
				if(letters[asc] >= 1 && s.charAt(i-1) != s.charAt(i)) {
					flag = false;
					break;
				} letters[asc]++;
			}
			if(flag) ans++;
		}
		System.out.println(ans);
	}

}
