package greedy_210623;
import java.io.*;
import java.util.*;

public class Main_백준_11047_동전0 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int ans = 0;
		int[] coin = new int[N];
		for(int i=0; i<N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		for(int i=N-1; i>=0; i--) {
			int temp = K / coin[i];
			if(temp >= 1) {
				ans += temp;
				K -= temp * coin[i];
			}
		}
		System.out.println(ans);
	}
}
