import java.io.*;
import java.util.*;

public class Main_백준_14496_그대그머가되어 {
	
	private static int N;
	private static boolean[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new boolean[N+1][N+1];
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = arr[y][x] = true;
		}
		
		int ans = bfs(a, b);
		System.out.println(ans);
	}

	private static int bfs(int a, int b) {
		Queue<int[] > queue = new LinkedList<int[] >();
		boolean[] visited = new boolean[N+1];

		visited[a] = true;
		for(int i=1; i<=N; i++) {
			if(arr[a][i]) {
				if(i == b || a == b) return 0;
				queue.offer(new int[] {i, 1});
			}
		}
		
		while(!queue.isEmpty()) {
			int[] p = queue.poll();
			
			if(p[0] == b) return p[1];
			for(int i=1; i<=N; i++) {
				if(visited[i] || !arr[p[0]][i]) continue;
				queue.offer(new int[] {i, p[1]+1});
				visited[i] = true;
			}
		}	
		return -1;
	}
	
}
