package twopointer_210721;
import java.io.*;

public class Main_백준_2018_수들의합5 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int cnt = 0;
		int idx = 1;

		for(int i=idx; i<=N; i++) {
			int sum = 0;
			for(int j=i; j<=N; j++) {
				sum += j;
				if(sum == N) {
					cnt++;
					idx++;
					break;
				} else if(sum > N) {
					idx++;
					break;
				}
			}
		}

		System.out.println(cnt);
	}

}
