import java.io.*;
import java.util.*;

public class Main_백준_20058_마법사상어와파이어스톰 {
	
	private static int N;
	private static int[][] map;
	public static int[] di = {-1, 0, 1, 0};
	public static int[] dj = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		N = (int) Math.pow(2, N);
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int q=0; q<Q; q++) {
			int L = Integer.parseInt(st.nextToken());
			L = (int) Math.pow(2, L);
			map = rotateClockwise(L); // 모든 부분 격자를 시계 방향으로 90도 회전
			checkIce(); // 얼음이 있는 칸 3개 이상 인접해 있지 않으면 얼음의 양 -1
		}
		int sum = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sum += map[i][j];
			}
		}
		int max = findBig();
		sb.append(sum).append("\n").append(max);
		System.out.println(sb);
	}

	private static int findBig() {
		int max = 0;
		boolean[][] visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 0) continue;
				int cnt = 1;
				Queue<int[] > queue = new LinkedList<int[] >();
				queue.offer(new int[] {i, j});
				visited[i][j] = true;
				while(!queue.isEmpty()) {
					int[] p = queue.poll();
					for(int d=0; d<4; d++) {
						int ni = p[0] + di[d];
						int nj = p[1] + dj[d];
						if(ni<0 || ni>=N || nj<0 || nj>=N || visited[ni][nj] || map[ni][nj] == 0) continue;
						visited[ni][nj] = true;
						cnt++;
						queue.offer(new int[] {ni, nj});
					}
				}
				max = Math.max(max, cnt);
			}
		}
		return max;
	}

	private static void checkIce() {
		ArrayList<int[] > list = new ArrayList<int[] >(); // 녹일 좌표
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 0) continue;
				int cnt = 0;
				for(int d=0; d<4; d++) {
					int ni = i + di[d];
					int nj = j + dj[d];
					if(ni<0 || ni>=N || nj<0 || nj>=N || map[ni][nj] == 0) continue;
					cnt++;
				}
				if(cnt < 3) { // 얼음이 있는 칸 3개 미만으로 인접해 있으면
					list.add(new int[] {i, j});
				}
			}
		}
		
		// 얼음의 양 1 감소
		for(int[] p : list) {
			map[p[0]][p[1]] -= 1;
		}
	}

	private static int[][] rotateClockwise(int l) {
		int[][] arr = new int[N][N];
	
		for(int i=0; i<N; i+=l) {
			for(int j=0; j<N; j+=l) {
				int x = j;
				int y = i;
				for(int a=j; a<j+l; a++) {
					x = j;
					for(int b=i+l-1; b>=i; b--) {
						arr[y][x++] = map[b][a];
					}
					y++;
				}
			}
		}
		return arr;
	}

}
