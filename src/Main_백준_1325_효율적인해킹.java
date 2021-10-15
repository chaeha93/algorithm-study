import java.io.*;
import java.util.*;

// ArrayList 
public class Main_백준_1325_효율적인해킹 {
	
	private static int N;
	private static boolean[][] map;
	public static int[] count;
	public static int count_max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new boolean[N+1][N+1];
		count = new int[N+1];
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			map[A][B] = true;
		}
		
		for(int j=1; j<=N; j++) {
			for(int i=1; i<=N; i++) {
				if(map[i][j]) {
					bfs(j, i);
				}
			}
		}

		for(int i=1; i<=N; i++) {
			if(count_max == count[i]) {
				sb.append(i).append(" ");
			}
		}
		System.out.println(sb);
		
	}

	private static void bfs(int idx, int computer) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N+1];
		queue.offer(computer);
		
		while(!queue.isEmpty()) {
			int p = queue.poll();
			visited[p] = true;
			
			count[idx]++;
			if(p <= idx) {
				count[idx] += count[p];
			}
			if(count[idx] > count_max) {
				count_max = count[idx];
			}
			
			for(int i=p+1; i<=N; i++) {
				if(map[i][p] && !visited[i]) {
					queue.offer(i);
				}
			}
		}
	}
}
