package greedy_0623;
import java.io.*;
import java.util.*;

public class Main_백준_1946_신입사원 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}

			// 서류 전형 순위를 오름차순으로 정렬
			Arrays.sort(arr, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0] - o2[0];
				}

			});
			int count = N; // 최종 합격한 지원자 수
			int standard_interview = arr[0][1]; // 서류 1위 지원자의 면접 순위
			for (int i = 1; i < N; i++) { // 서류 순위 순서대로 반복
				if (arr[i][1] > standard_interview) { // 기준 면접 순위보다 낮으면 불합격 처리
					count--;
				} else { // 기준 면접 순위보다 높으면 기준을 갱신
					standard_interview = arr[i][1];
				}
			}

			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}
}
