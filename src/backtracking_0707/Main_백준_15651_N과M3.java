package backtracking_0707;
import java.io.*;
import java.util.*;

public class Main_백준_15651_N과M3 {

	private static StringBuilder sb;
	private static int N, M;
	private static int[] numbers;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[M];
		sequence(0);
		System.out.println(sb);
	}

	private static void sequence(int cnt) {
		if(cnt == M) {
			for(int i=0; i<M; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=1; i<=N; i++) {
			numbers[cnt] = i;
			sequence(cnt+1);
		}
	}
}
