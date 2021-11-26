package nosubject_1125;

import java.io.*;
import java.util.*;

public class Main_백준_16430_제리와톰 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int num = gcd(B-A, B);
		if(num == 1) {
			sb.append(B-A).append(" ").append(B);
		} else {
			sb.append((B-A)/num).append(" ").append(B/num);
		}
		System.out.println(sb);
	}

	private static int gcd(int a, int b) {
		for(int i=2; i<=a; i++) {
			if(a%i == 0 && b%i == 0) {
				return i;
			}
		}
		return 1;
	}

}
