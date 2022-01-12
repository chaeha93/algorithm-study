package implementation_210901;

import java.io.*;

public class Main_백준_2739_구구단 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i=1; i<=9; i++) {
			System.out.println(N + " * " + i + " = " + N*i);
		}
	}
}
