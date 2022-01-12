package graphtheory_210908;
import java.io.*;
import java.util.*;

public class Main_백준_11724_연결요소의개수 {

	private static int N, ans;
	private static boolean[][] arr;
	public static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new boolean[N][N];
		visited = new boolean[N];
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			arr[u-1][v-1] = true;
			arr[v-1][u-1] = true;
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				dfs(i);
				ans++;
			}
		}
		System.out.println(ans);
	}

	private static void dfs(int num) {
		visited[num] = true;
		
		for(int j=0; j<N; j++) {
			if(arr[num][j] && !visited[j]) {
				dfs(j);
			}
		}
	}

}
