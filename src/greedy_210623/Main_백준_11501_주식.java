package greedy_210623;
import java.io.*;
import java.util.*;

public class Main_백준_11501_주식 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			int max = 0;
			long profit = 0;
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			for(int i=N-1; i>=0; i--) {
				if(max < arr[i]) {
					max = arr[i];
				} else {
					profit += max - arr[i];
				}
			}
			
			sb.append(profit).append("\n");
		}
		System.out.println(sb);
	}

}
