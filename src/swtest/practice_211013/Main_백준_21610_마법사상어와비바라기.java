package swtest.practice_211013;
import java.io.*;
import java.util.*;

public class Main_백준_21610_마법사상어와비바라기 {
	
	public static int[] di = {-1, 1, -1, 1}; // 우상 우하 좌상 좌하  
	public static int[] dj = {1, 1, -1, -1};
	private static int[][] map;
	private static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		boolean[][] cloud = new boolean[N][N];
		ArrayList<int[] > cloudlist = new ArrayList<int[] >();
		cloudlist.add(new int[] {N-2, 0});
		cloudlist.add(new int[] {N-2, 1});
		cloudlist.add(new int[] {N-1, 0});
		cloudlist.add(new int[] {N-1, 1});
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			int D = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			cloudlist = moveCloud(D, S%N, cloudlist); // 구름 이동
			
			for(int i=0; i<N; i++) {
				Arrays.fill(cloud[i], false);
			}
			for(int[] p : cloudlist) { // 구름이 있는 칸에 1씩 비 내리기
				map[p[0]][p[1]]++;
				cloud[p[0]][p[1]] = true;
			}
			
			computeDiagonal(cloudlist); // 대각선 물의 양 따지기
			cloudlist.clear();
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] >=2 && !cloud[i][j]) {
						map[i][j] -= 2;
						cloudlist.add(new int[] {i, j});
					}
				}
			}
		}
		
		int ans = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				ans += map[i][j];
			}
		}
		System.out.println(ans);
	}

	private static void computeDiagonal(ArrayList<int[]> cloudlist) {
		int[] arr = new int[cloudlist.size()];
		
		for(int i=0; i<cloudlist.size(); i++) { // 대각선 확인
			int[] p = cloudlist.get(i);
			for(int d=0; d<4; d++) {
				int ni = p[0] + di[d];
				int nj = p[1] + dj[d];
				if(ni<0 || ni >=N || nj<0 || nj >=N || map[ni][nj] == 0) continue;
				arr[i]++;
			}
		}
		
		for(int i=0; i<cloudlist.size(); i++) { // 대각선 더하기
			if(arr[i] > 0) {
				int[] p = cloudlist.get(i);
				map[p[0]][p[1]] += arr[i];
			}
		}
	}

	private static ArrayList<int[]> moveCloud(int d, int s, ArrayList<int[]> cloudlist) {
		ArrayList<int[] > list = new ArrayList<int[] >();
		
		if(d == 1) { // 좌로 이동
			for(int i=0; i<cloudlist.size(); i++) {
				int[] p = cloudlist.get(i);
				p[1] -= s;
				if(p[1] < 0) p[1] += N;
				list.add(p);
			}
		} else if(d == 2) { // 좌상으로 이동
			for(int i=0; i<cloudlist.size(); i++) {
				int[] p = cloudlist.get(i);
				p[0] -= s;
				p[1] -= s;
				if(p[0] < 0) p[0] += N;
				if(p[1] < 0) p[1] += N;
				list.add(p);
			}
			
		} else if(d == 3) { // 상으로 이동
			for(int i=0; i<cloudlist.size(); i++) {
				int[] p = cloudlist.get(i);
				p[0] -= s;
				if(p[0] < 0) p[0] += N;
				list.add(p);
			}
			
		} else if(d == 4) { // 우상으로 이동
			for(int i=0; i<cloudlist.size(); i++) {
				int[] p = cloudlist.get(i);
				p[0] -= s;
				p[1] += s;
				if(p[0] < 0) p[0] += N;
				if(p[1] >= N) p[1] -= N;
				list.add(p);
				
			}
			
		} else if(d == 5) { // 우로 이동
			for(int i=0; i<cloudlist.size(); i++) {
				int[] p = cloudlist.get(i);
				p[1] += s;
				if(p[1] >= N) p[1] -= N;
				list.add(p);
			}
			
		} else if(d == 6) { // 우하로 이동
			for(int i=0; i<cloudlist.size(); i++) {
				int[] p = cloudlist.get(i);
				p[0] += s;
				p[1] += s;
				if(p[0] >= N) p[0] -= N;
				if(p[1] >= N) p[1] -= N;
				list.add(p);
			}
			
		} else if(d == 7) { // 하로 이동
			for(int i=0; i<cloudlist.size(); i++) {
				int[] p = cloudlist.get(i);
				p[0] += s;
				if(p[0] >= N) p[0] -= N;
				list.add(p);
			}
			
		} else { // 좌하로 이동
			for(int i=0; i<cloudlist.size(); i++) {
				int[] p = cloudlist.get(i);
				p[0] += s;
				p[1] -= s;
				if(p[0] >= N) p[0] -= N;
				if(p[1] < 0) p[1] += N;
				list.add(p);
			}
			
		}
		return list;
	}

}
