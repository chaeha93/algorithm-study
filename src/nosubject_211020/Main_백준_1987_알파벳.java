package nosubject_211020;

import java.io.*;
import java.util.*;

public class Main_백준_1987_알파벳 {

	private static int R, C, max;
	private static char[][] map;
	public static boolean[] letter;
	public static int[] di = {-1, 0, 1, 0}; // 상우하좌
	public static int[] dj = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		letter = new boolean[26];
		for(int i=0; i<R; i++) {
			String s = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		dfs(0, 0, 1);
		System.out.println(max);
	}

	private static void dfs(int i, int j, int cnt) {
		letter[map[i][j]-65] = true;
		
		for(int d=0; d<4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if(ni<0 || ni>=R || nj<0 || nj>=C || letter[map[ni][nj]-65]) continue;
			dfs(ni, nj, cnt+1);
		}
		max = Math.max(max, cnt);
		letter[map[i][j]-65] = false;
	}
}
