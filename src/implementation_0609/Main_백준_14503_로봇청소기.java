package implementation_0609;

import java.io.*;
import java.util.*;

public class Main_백준_14503_로봇청소기 {

	private static int N, M, count;
	private static int[][] map;
	private static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 세로 크기
		M = Integer.parseInt(st.nextToken()); // 가로 크기
		map = new int[N][M];
		visited = new boolean[N][M]; // 청소한 칸인지 확인
		st = new StringTokenizer(br.readLine(), " ");
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cleanUp(r, c, d);
		System.out.println(count);
	}

	private static void cleanUp(int r, int c, int d) { // 현재 위치를 청소
		visited[r][c] = true;
		count++;
		searchLeft(r, c, d, 0); // 현재 위치(r, c), 방향
	}

	private static void searchLeft(int r, int c, int d, int cnt) {
		int x = r;
		int y = c;
		if (cnt == 4) { // 네방향 모두 청소할 수 없다. 방향 유지하며 후진
			if (d == 0)
				++x;
			else if (d == 1)
				--y;
			else if (d == 2)
				--x;
			else
				++y;
			if (map[x][y] == 1) { // 후진 하려고 했는데 벽이면 끝
				return;
			} else {
				searchLeft(x, y, d, 0);
				return;
			}
		}
		int changeD = changeDir(d); // 왼쪽 방향으로 바꿈
		if (changeD == 0)
			--x;
		else if (changeD == 1)
			++y;
		else if (changeD == 2)
			++x;
		else
			--y;

		if (0 <= x && x < N && 0 <= y && y < M && !visited[x][y] && map[x][y] == 0) { // 왼쪽 방향 청소 가능
			cleanUp(x, y, changeD);
		} else { // 왼쪽 방향 청소 불가능
			searchLeft(r, c, changeD, cnt + 1);
		}
	}

	private static int changeDir(int d) {
		if (d == 0) {
			d = 3;
		} else {
			--d;
		}
		return d;
	}
}
