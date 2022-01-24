package nosubject_220119;

import java.io.*;
import java.util.*;

public class Main_백준_17086_아기상어2 {

	private static int N, M;
	private static int[][] map;
	public static int[] di = { -1, -1, 0, 1, 1, 1, 0, -1 };
	public static int[] dj = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int max = 0;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) continue;
				cnt = bfs(i, j, 0);
				max = Math.max(cnt, max);
			}
		}
		System.out.println(max);
	}

	private static int bfs(int i, int j, int cnt) {
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][] visited = new boolean[N][M];

		queue.offer(new int[] { i, j, cnt});
		visited[i][j] = true;
		
		int count = 0;
		ex: while (!queue.isEmpty()) {
			int[] p = queue.poll();
			for (int d = 0; d < 8; d++) {
				int ni = p[0] + di[d];
				int nj = p[1] + dj[d];
				if(ni<0 || ni>=N || nj<0 || nj>=M || visited[ni][nj]) continue;
				if(map[ni][nj] == 1) {
					count = p[2] + 1;
					break ex;
				}
				queue.offer(new int[] {ni, nj, p[2] + 1});
				visited[ni][nj] = true;
			}
		}
		return count;
	}

}
