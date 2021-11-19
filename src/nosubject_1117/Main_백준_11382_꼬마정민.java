package nosubject_1117;

import java.io.*;
import java.util.*;

public class Main_백준_11382_꼬마정민 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		double A = Double.parseDouble(st.nextToken());
		double B = Double.parseDouble(st.nextToken());
		double C = Double.parseDouble(st.nextToken());
		double sum = A + B + C;
		System.out.println((long)sum);
	}

}
