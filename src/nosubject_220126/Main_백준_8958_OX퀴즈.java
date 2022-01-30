package nosubject_220126;

import java.io.*;

public class Main_백준_8958_OX퀴즈 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			String s = br.readLine();
			int cnt = 0;
			int sum = 0;
			for(int i=0; i<s.length(); i++) {
				char c = s.charAt(i);
				if(c == 'O') {
					cnt++;
				} else {
					cnt = 0;
				}
				sum += cnt;
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}
}
