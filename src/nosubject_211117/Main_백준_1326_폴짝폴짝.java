package nosubject_211117;
import java.io.*;
import java.util.*;

public class Main_백준_1326_폴짝폴짝 {
	
	private static int N, start, end;
	private static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		start = Integer.parseInt(st.nextToken()) - 1;
		end = Integer.parseInt(st.nextToken()) - 1;
		
		int ans = bfs();
		System.out.println(ans);
	}

	private static int bfs() {
		Queue<int[] > queue = new LinkedList<int[] >();
		boolean[] visited = new boolean[N];
		queue.offer(new int[] {start, 0});
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int[] p = queue.poll();
			
			int idx = 1;
			for(int i=arr[p[0]]; i<N; i=idx*arr[p[0]]) {
				if(i+p[0] == end || p[0]-i == end) return p[1]+1;
				if(i+p[0] <N && !visited[i + p[0]]) { // 오른쪽 이동
					queue.offer(new int[] {i+p[0], p[1]+1});
					visited[i+p[0]] = true;					
				}
				if(p[0]-i >= 0 && !visited[p[0]-i]) { // 왼쪽 이동
					queue.offer(new int[] {p[0]-i, p[1]+1});
					visited[p[0]-i] = true;
				}
				idx++;
			}
		}
		return -1;
	}

}
