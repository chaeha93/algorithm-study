package backtracking_210707;
import java.io.*;
import java.util.*;

public class Main_백준_15649_N과M1 {
	
	private static int N, M;
	public static int[] numbers;
	private static boolean[] visited;
	private static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[M];
		visited = new boolean[N+1];
		permutation(0);
		System.out.println(sb);
	}

	private static void permutation(int cnt) {
		if(cnt == M) {
			for(int i=0; i<M; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				numbers[cnt] = i;
				visited[i] = true;
				permutation(cnt+1);
				visited[i] = false;
			}
		}
	}

}
