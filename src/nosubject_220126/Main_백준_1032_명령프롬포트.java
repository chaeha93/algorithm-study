package nosubject_220126;

import java.io.*;
import java.util.*;

public class Main_백준_1032_명령프롬포트 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N];
		for(int i=0; i<N; i++) {
			arr[i] = br.readLine();
		}
		sb.append(arr[0]);
		for(int i=1; i<N; i++) {
			for(int j=0; j<arr[0].length(); j++) {
				char c1 = sb.charAt(j);
				char c2 = arr[i].charAt(j);
				if(c1 == c2 && c1 != '?' && c2 != '?') {
					sb.setCharAt(j, c1);
				} else {
					sb.setCharAt(j, '?');
				}
			}
			
		}
		System.out.println(sb);
	}

}
