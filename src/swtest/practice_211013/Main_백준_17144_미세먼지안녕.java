package swtest.practice_211013;
import java.io.*;
import java.util.*;

public class Main_백준_17144_미세먼지안녕 {
	
	public static int[] di = {-1, 0, 1, 0};
	public static int[] dj = {0, 1, 0, -1};
	private static int R, C;
	private static int[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		ArrayList<int[] > cleaner_list = new ArrayList<int[] >();
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) {
					cleaner_list.add(new int[] {i, j});
				}
			}
		}
		
		for(int t=1; t<=T; t++) {
			map = spreadDust();
			workUpCleaner(cleaner_list.get(0));
			workDownCleaner(cleaner_list.get(1));
		}
		
		int sum = 0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] > 0) sum += map[i][j];
			}
		}
		System.out.println(sum);
	}

	private static void workDownCleaner(int[] p) { // 시계 방향으로 순환
		// 1. 우 방향
		int temp = 0;
		int temp2 = 0;
		for(int j=1; j<C; j++) {
			temp2 = map[p[0]][j];
			map[p[0]][j] = temp;
			temp = temp2;
		}
		// 2. 하 방향
		for(int i=p[0]+1; i<R; i++) {
			temp2 = map[i][C-1];
			map[i][C-1] = temp;
			temp = temp2;
		}
		// 3. 좌 방향
		for(int j=C-2; j>=0; j--) {
			temp2 = map[R-1][j];
			map[R-1][j] = temp;
			temp = temp2;
		}
		// 4. 상 방향
		for(int i=R-2; i>p[0]; i--) {
			temp2 = map[i][0];
			map[i][0] = temp;
			temp = temp2;
		}
		
	}

	private static void workUpCleaner(int[] p) { // 반시계 방향으로 순환
		// 1. 우 방향
		int temp = 0;
		int temp2 = 0;
		for(int j=1; j<C; j++) {
			temp2 = map[p[0]][j];
			map[p[0]][j] = temp;
			temp = temp2;
		}
		// 2. 상 방향
		for(int i=p[0]-1; i>=0; i--) {
			temp2 = map[i][C-1];
			map[i][C-1] = temp;
			temp = temp2;
		}
		// 3. 좌 방향
		for(int j=C-2; j>=0; j--) {
			temp2 = map[0][j];
			map[0][j] = temp;
			temp = temp2;
		}
		// 4. 하 방향
		for(int i=1; i<p[0]; i++) {
			temp2 = map[i][0];
			map[i][0] = temp;
			temp = temp2;
		}
	}

	private static int[][] spreadDust() { // 미세먼지 확산
		int[][] arr = new int[R][C];
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] > 0) { // 미세먼지가 존재하는 경우
					int current = map[i][j];
					for(int d=0; d<4; d++) {
						int ni = i + di[d];
						int nj = j + dj[d];
						if(ni<0 || ni>=R || nj<0 || nj>=C || map[ni][nj] == -1) continue;
						int num = map[i][j] / 5;
						arr[ni][nj] += num;
						current -= num;
					}
					arr[i][j] += current;
				} else if(map[i][j] == -1) {
					arr[i][j] = -1;
				}
			}
		}
		return arr;
	}

}
