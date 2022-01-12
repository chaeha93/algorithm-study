package backtracking_210707;
import java.io.*;
import java.util.*;

public class Main_백준_15656_N과M7 {
	
	private static StringBuilder sb;
	private static int N, M;
	private static int[] inputs;
	private static int[] numbers;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		inputs = new int[N];
		numbers = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			inputs[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(inputs);
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
		for(int i=0; i<N; i++) {
			numbers[cnt] = inputs[i];
			permutation(cnt+1);
		}
		
	}

}
