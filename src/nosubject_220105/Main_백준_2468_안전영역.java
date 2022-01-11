package nosubject_220105;
import java.io.*;
import java.util.*;

public class Main_백준_2468_안전영역 {
	
	private static int N;
	private static boolean[][] visited;
	private static int[][] map;
	public static int[] di = {-1, 0, 1, 0};
	public static int[] dj = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		boolean[] height = new boolean[101];
		visited = new boolean[N][N];
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				height[map[i][j]] = true;
			}
		}
		
		int max = 0;
		for(int n=1; n<101; n++) {
			if(!height[n]) continue;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] == n) {
						map[i][j] = 0;
					}
				}
			}
			int cnt = 0;
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(!visited[r][c] && map[r][c] > 0) {
						bfs(r, c);
						cnt++;
					}
				}
			}
			max = Math.max(max, cnt);
			for(int i=0; i<N; i++) {
				Arrays.fill(visited[i], false);
			}
		}
		if(max == 0) max = 1;
		System.out.println(max);

	}

	private static void bfs(int i, int j) {
		Queue<int[] > queue = new LinkedList<int[] >();
		queue.offer(new int[] {i, j});
		visited[i][j] = true;
		
		while(!queue.isEmpty()) {
			int[] p = queue.poll();
			
			for(int d=0; d<4; d++) {
				int ni = p[0] + di[d];
				int nj = p[1] + dj[d];
				if(ni<0 || ni>=N || nj<0 || nj>=N || visited[ni][nj] || map[ni][nj] == 0) continue;
				queue.offer(new int[] {ni, nj});
				visited[ni][nj] = true;
			}
		}
	}

}
