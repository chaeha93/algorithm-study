package implementation_210901;

import java.io.*;
import java.util.*;

public class Main_백준_1330_두수비교하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		if(A > B) {
			System.out.println(">");
		} else if(A < B) {
			System.out.println("<");
		} else {
			System.out.println("==");
		}
	}
}
