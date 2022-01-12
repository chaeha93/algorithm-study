package graphtheory_210908;

import java.io.*;
import java.util.*;

public class Main_백준_14716_현수막 {

	public static int[] di = {-1, 0, 1, 0, 1, -1, 1, -1}; // 상 우 하 좌 우상 우하 좌상 좌하
	public static int[] dj = {0, 1, 0, -1, 1, 1, -1, -1};
	private static int[][] arr;
	private static int N, M; 
	public static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] == 1 && !visited[i][j]) {
					bfs(i, j);
					ans++;
				}
			}
		}
		System.out.println(ans);
	}

	private static void bfs(int i, int j) {
		Queue<int[] > queue = new LinkedList<int[] >();
		queue.offer(new int[] {i, j});
		visited[i][j] = true;
		
		while(!queue.isEmpty()) {
			int[] p = queue.poll();
			
			for(int d=0; d<8; d++) {
				int ni = p[0] + di[d];
				int nj = p[1] + dj[d];
				if(ni<0 || ni>=N || nj<0 || nj>=M || visited[ni][nj] || arr[ni][nj] != 1) continue;
				queue.offer(new int[] {ni, nj});
				visited[ni][nj] = true;
			}
		}
		
		
	}

}
