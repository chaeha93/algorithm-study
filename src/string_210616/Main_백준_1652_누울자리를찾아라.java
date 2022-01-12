package string_210616;
import java.io.*;

public class Main_백준_1652_누울자리를찾아라 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine()); // 방의 크기
		String[][] map = new String[N][N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			String[] arr = s.split("");
			for (int j = 0; j < N; j++) {
				map[i][j] = arr[j];
			}
		}
		
		// 가로
		int width = 0;
		int cnt = 0;
		for(int i=0; i<N; i++) {
			cnt = 0;
			for(int j=0; j<N; j++) {
				if(map[i][j].equals(".")) {
					cnt++;
				}
				if(map[i][j].equals("X")) {
					if(cnt >= 2) width++;
					cnt = 0;
				}
			}
			if(cnt >= 2) width++;
		}
		
		// 세로
		int vertical = 0;
		for(int j=0; j<N; j++) {
			cnt = 0;
			for(int i=0; i<N; i++) {
				if(map[i][j].equals(".")) {
					cnt++;
				}
				if(map[i][j].equals("X")) {
					if(cnt >= 2) vertical++;
					cnt = 0;
				}
			}
			if(cnt >= 2) vertical++;
		}
 		sb.append(width).append(" ").append(vertical);
		System.out.println(sb);
	}
}
