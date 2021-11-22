package nosubject_1117;

import java.io.*;
import java.util.*;

public class Main_백준_5800_성적통계 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int K = Integer.parseInt(br.readLine());
		for(int k=1; k<=K; k++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int[] score = new int[N];
			for(int n=0; n<N; n++) {
				score[n] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(score);
			sb.append("Class ").append(k).append("\n");
			sb.append("Max ").append(score[N-1]).append(", ").append("Min ").append(score[0]).append(", ");
			int max = 0;
			for(int i=0; i<N-1; i++) {
				int sub = score[i+1] - score[i];
				max = Math.max(max, sub);
			}
			sb.append("Largest gap ").append(max).append("\n");
		}
		System.out.println(sb);
	}

}
