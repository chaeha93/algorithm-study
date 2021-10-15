package nosubject_1006;

import java.io.*;
import java.util.*;

public class Main_백준_7576_토마토 {

	public static int[] di = {-1, 1, 0, 0}; // 상하좌우
	public static int[] dj = {0, 0, -1, 1};
	private static int N, M, unTomato;
	private static int[][] map;
	public static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		unTomato = 0; // 안 익은 토마토의 개수
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) {
					unTomato++;
				}
			}
		}
		
		int day = bfs();
		System.out.println(day);
	}

	private static int bfs() {
		Queue<int[] > queue = new LinkedList<int[] >();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 1) {
					queue.offer(new int[] {i, j, 0});
					visited[i][j] = true;
				}
			}
		}
		
		int day = 0;
		
		while(!queue.isEmpty()) {
			int[] p = queue.poll();
			
			for(int d=0; d<4; d++) {
				int ni = p[0] + di[d];
				int nj = p[1] + dj[d];
				if(ni<0 || ni>=N || nj<0 || nj>=M || visited[ni][nj] || map[ni][nj] != 0) continue;
				map[ni][nj] = 1;
				visited[ni][nj] = true;
				unTomato--;
				queue.offer(new int[] {ni, nj, p[2]+1});
				if(day < p[2]+1) day = p[2]+1;
			}
		}
		
		if(unTomato != 0) return -1;
		return day;
	}

}
