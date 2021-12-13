package nosubject_1208;

import java.io.*;
import java.util.*;

public class Main_백준_5596_시험점수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int min = 0;
		int man = 0;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<4; i++) {
			min += Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<4; i++) {
			man += Integer.parseInt(st.nextToken());
		}
		int ans = Math.max(min, man);
		System.out.println(ans);
	}
}
