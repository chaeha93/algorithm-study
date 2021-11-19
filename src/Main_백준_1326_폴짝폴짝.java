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
		queue.offer(new int[] {start, 0});
		
		while(!queue.isEmpty()) {
			int[] p = queue.poll();
			if(p[0] == end) {
				return p[1];
			}
			int idx = 1;
			for(int i=arr[p[0]]; i<N; i=arr[p[0]]*idx) {
				idx++;
				queue.offer(new int[] {i, p[1]+1});
				if(p[0]-i >= 0) {
					queue.offer(new int[] {p[0]-i, p[1]+1});
				}
			}
		}
		return -1;
		
	}

}
