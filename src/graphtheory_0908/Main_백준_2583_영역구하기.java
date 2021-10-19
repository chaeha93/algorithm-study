package graphtheory_0908;
import java.io.*;
import java.util.*;

public class Main_백준_2583_영역구하기 {
	
	private static int M, N;
	private static int[][] map;
	public static boolean[][] visited;
	public static int[] di = {-1, 0, 1, 0}; // 상우하좌
	public static int[] dj = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		visited = new boolean[M][N];
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int k=0; k<K; k++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for(int i=x1; i<x2; i++) {
				for(int j=y1; j<y2; j++) {
					map[j][i] = 1;
				}
			}
		}
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 0 && !visited[i][j]) {
					int area = bfs(i, j);
					list.add(area);
				}
			}
		}
		
		sb.append(list.size()).append("\n");
		Collections.sort(list);
		for(int p : list) {
			sb.append(p).append(" ");
		}
		System.out.println(sb);
	}

	private static int bfs(int i, int j) {
		int max = 1;
		Queue<int[] > queue = new LinkedList<int[] >();
		
		queue.offer(new int[] {i, j});
		visited[i][j] = true;
		
		while(!queue.isEmpty()) {
			int[] p = queue.poll();
			
			for(int d=0; d<4; d++) {
				int ni = p[0] + di[d];
				int nj = p[1] + dj[d];
				if(ni<0 || ni>=M || nj<0 || nj>=N || visited[ni][nj] || map[ni][nj] != 0) continue;
				max++;
				visited[ni][nj] = true;
				queue.offer(new int[] {ni, nj});
			}
		}
		return max;
	}

}
