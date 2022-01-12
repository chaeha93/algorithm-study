package graphtheory_210908;
import java.io.*;
import java.util.*;

public class Main_백준_7576_토마토 {
	
	private static int M, N; 
	private static int[][] arr;
	public static Queue<int[] > queue = new LinkedList<int[] >();
	public static boolean[][] visited;
	public static int[] di = {-1, 0, 1, 0};
	public static int[] dj = {0, 1, 0, -1};
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) {
					queue.offer(new int[] {i, j, 0});
					visited[i][j] = true;
				}
			}
		}
		
		int time = bfs();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] == 0) time = -1;
			}
		}
		System.out.println(time);
	}

	private static int bfs() {
		int time = 0;
		while(!queue.isEmpty()) {
			int[] p = queue.poll();
			
			for(int d=0; d<4; d++) {
				int ni = p[0] + di[d];
				int nj = p[1] + dj[d];
				if(ni<0 || ni>=N || nj<0 || nj>=M || visited[ni][nj] || arr[ni][nj] != 0) continue;
				queue.offer(new int[] {ni, nj, p[2]+1});
				visited[ni][nj] = true;
				arr[ni][nj] = 1;
				if(time < p[2]+1) time = p[2]+1;
			}
		}
		return time;
	}

}
