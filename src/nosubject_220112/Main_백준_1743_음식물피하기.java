package nosubject_220112;

import java.io.*;
import java.util.*;

public class Main_백준_1743_음식물피하기 {
	
	private static int N, M;
	private static int[][] map;
	private static boolean[][] visited;
	public static int[] di = {-1, 0, 1, 0};
	public static int[] dj = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1];
		visited = new boolean[N+1][M+1];
		for(int k=0; k<K; k++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = -1;
		}
		
		int max = 0;
		int cnt = 0;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				if(!visited[i][j] && map[i][j] == -1) {
					cnt = bfs(i, j);
				}
				max = Math.max(cnt, max);
			}
		}
		System.out.println(max);
		
	}

	private static int bfs(int r, int c) {
		int cnt = 1;
		Queue<int[] > queue = new LinkedList<int[] >();
		queue.offer(new int[] {r, c});
		visited[r][c] = true;
		
		while(!queue.isEmpty()) {
			int[] p = queue.poll();
			
			for(int d=0; d<4; d++) {
				int ni = p[0] + di[d];
				int nj = p[1] + dj[d];
				if(ni<=0 || ni>N || nj<=0 || nj>M || visited[ni][nj] || map[ni][nj] != -1) continue;
				queue.offer(new int[] {ni, nj});
				visited[ni][nj] = true;
				cnt++;
			}
		}
		return cnt;
	}

}
