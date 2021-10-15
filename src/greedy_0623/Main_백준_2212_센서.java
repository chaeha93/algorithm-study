package greedy_0623;
import java.io.*;
import java.util.*;

public class Main_백준_2212_센서 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 센서의 개수
		int K = Integer.parseInt(br.readLine()); // 집중국의 개수
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int ans = 0; // 최종 출력할 수신 가능 영역의 길이의 합의 최솟값
		Arrays.sort(arr);
		if (K >= N) {
			ans = 0;
		} else if (K == 1) {
			ans = arr[N - 1] - arr[0];
		} else {
			Integer[] distance = new Integer[N - 1]; // 거리 차이를 담을 배열
			for (int i = 1; i < N; i++) {
				distance[i - 1] = arr[i] - arr[i - 1];
			}
			Arrays.sort(distance, Collections.reverseOrder());
			for(int i=K-1; i<N-1; i++) {
				ans += distance[i];
			}
		}
		System.out.println(ans);
	}
}
