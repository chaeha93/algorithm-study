package nosubject_220126;

import java.io.*;

public class Main_백준_11720_숫자의합 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		String s = br.readLine();
		for(int n=0; n<N; n++) {
			sum += s.charAt(n) - '0';
		}
		System.out.println(sum);
	}
}
