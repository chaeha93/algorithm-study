package backtracking_210707;

import java.io.*;
import java.util.*;

public class Main_백준_15652_N과M4 {

	private static StringBuilder sb;
	private static int N, M;
	private static int[] numbers;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[M];
		permutation(0, 1);
		System.out.println(sb);
	}

	private static void permutation(int cnt, int start) {
		if(cnt == M) {
			for(int i=0; i<M; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=start; i<=N; i++) {
			numbers[cnt] = i;
			permutation(cnt+1, i);
		}
	}

}
