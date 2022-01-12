package nosubject_211208;
import java.io.*;
import java.util.*;

public class Main_백준_10026_적록색약 {
	
	private static int N;
	private static char[][] map;
	private static boolean[][] visited;
	public static int[] di = {-1, 0, 1, 0};
	public static int[] dj = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		visited = new boolean[N][N];
		int ans1 = 0;
		int ans2 = 0;
		// 정상
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					ans1++;
					notRedgreen(i, j);
				}
			}
		}
		// 적록색약
		visited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					ans2++;
					redgreen(i, j);
				}
			}
		}
		
		sb.append(ans1).append(" ").append(ans2);
		System.out.println(sb);
	}

	private static void redgreen(int i, int j) {
		Queue<int[] > queue = new LinkedList<int[] >();
		queue.offer(new int[] {i, j});
		visited[i][j] = true;
		
		while(!queue.isEmpty()) {
			int[] p = queue.poll();
			
			for(int d=0; d<4; d++) {
				int ni = p[0] + di[d];
				int nj = p[1] + dj[d];
				
				if(ni<0 || ni>=N || nj<0 || nj>=N || visited[ni][nj]) continue;
				if((map[p[0]][p[1]] == 'R' || map[p[0]][p[1]] == 'G') && map[ni][nj] == 'B') continue;
				if(map[p[0]][p[1]] == 'B' && map[ni][nj] != 'B') continue;
				visited[ni][nj] = true;
				queue.offer(new int[] {ni, nj});
			}
		}
		
	}

	private static void notRedgreen(int i, int j) { // 정사
		Queue<int[] > queue = new LinkedList<int[] >();
		queue.offer(new int[] {i, j});
		visited[i][j] = true;
		
		while(!queue.isEmpty()) {
			int[] p = queue.poll();
			
			for(int d=0; d<4; d++) {
				int ni = p[0] + di[d];
				int nj = p[1] + dj[d];
				
				if(ni < 0 || ni >= N || nj < 0 || nj >= N || visited[ni][nj] || map[p[0]][p[1]] != map[ni][nj]) continue;
				visited[ni][nj] = true;
				queue.offer(new int[] {ni, nj});
			}
		}
	}

}
