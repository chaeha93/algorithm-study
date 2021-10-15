import java.io.*;
import java.util.*;

public class Main_백준_1520_내리막길 {

	private static int N, M, cnt;
	private static int[][] map;
	public static int[][] dp;
	public static boolean[][] visited;
	public static int[] di = { -1, 1, 0, 0 };
	public static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dp = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[N-1][M-1] = 1;
		dfs(0, 0);
		System.out.println(dp[0][0]);
	}

	private static void dfs(int r, int c) {
		if (r == N - 1 && c == M - 1) return;
		if(visited[r][c]) return;
		visited[r][c] = true;
		
		for (int d = 0; d < 4; d++) {
			int ni = r + di[d];
			int nj = c + dj[d];
			if (ni < 0 || ni >= N || nj < 0 || nj >= M || map[r][c] <= map[ni][nj]) continue;
			if(dp[ni][nj] != 0) {
				dp[r][c] += dp[ni][nj];
			} else {
				dfs(ni, nj);
				dp[r][c] += dp[ni][nj];
			}
			
		}
	}
}
