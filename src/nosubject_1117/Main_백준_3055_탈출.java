package nosubject_1117;
import java.io.*;
import java.util.*;

public class Main_백준_3055_탈출 {
	
	private static int R, C;
	private static char[][] map;
	public static char[][] after; // 물이 찰 예정인 배열
	public static int[] di = {-1, 0, 1, 0};
	public static int[] dj = {0, 1, 0, -1};
	private static Queue<int[]> bfsQueue;
	private static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		after = new char[R][C];
		int Sx = 0;
		int Sy = 0;
		for(int i=0; i<R; i++) {
			String s = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j] == 'S') {
					Sx = i;
					Sy = j;
				}
			}
		}
		
		bfsQueue = new LinkedList<int[] >();
		visited = new boolean[R][C];
		bfsQueue.offer(new int[] {Sx, Sy, 0});
		visited[Sx][Sy] = true;
		int time = 0;
		int num = 0;
		copyArray(after, map);
		while(true) {
			fillUpWater();
			num = bfsHedgehog(time);
			time++;
			if(num != 0) break;
			copyArray(map, after);
		}
		if(num == -1) {
			System.out.println("KAKTUS");
		} else {
			System.out.println(time);			
		}
	}

	private static void copyArray(char[][] a, char[][] b) {
		for(int i=0; i<R; i++) {
			System.arraycopy(b[i], 0, a[i], 0, b[i].length);
		}
		
	}

	private static int bfsHedgehog(int min) {
		while(!bfsQueue.isEmpty()) {
			int[] p = bfsQueue.poll();
			
			if(min < p[2]) {
				bfsQueue.offer(p);
				return 0;
			}
			
			for(int d=0; d<4; d++) {
				int ni = p[0] + di[d];
				int nj = p[1] + dj[d];
				if(ni<0 || ni>=R || nj<0 || nj>=C || after[ni][nj] == '*' || map[ni][nj] == '*' || after[ni][nj] == 'X' || map[ni][nj] == 'X' || visited[ni][nj]) continue;
				if(map[ni][nj] == 'D') return 1;
				bfsQueue.offer(new int[] {ni, nj, p[2]+1});
				visited[ni][nj] = true;
			}
			
		}
		return -1;
		
	}

	private static void fillUpWater() {
		Queue<int[] > queue = new LinkedList<int[] >();

		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(after[i][j] == '*') {
					queue.offer(new int[] {i, j});
				}
			}
		}
		
		while(!queue.isEmpty()) {
			int[] p = queue.poll();
			
			for(int d=0; d<4; d++) {
				int ni = p[0] + di[d];
				int nj = p[1] + dj[d];
				if(ni<0 || ni>=R || nj<0 || nj>=C || after[ni][nj] != '.') continue;
				after[ni][nj] = '*';
			}
		}
	}



}
