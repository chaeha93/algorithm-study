package implementation_210609;
import java.io.*;
import java.util.*;

public class Main_백준_15683_감시 {

	private static int N, M, min;
	private static int[][] map;
	private static ArrayList<int[]> cctv;
	public static int[][] status = {
			{0, 0, 0, 1}, {0, 0, 1, 0}, {0, 1, 0, 0}, {1, 0, 0, 0},
			{0, 0, 1, 1}, {0, 1, 0, 1}, {0, 1, 1, 0}, {1, 0, 0, 1}, {1, 0, 1, 0}, {1, 1, 0, 0},
			{0, 1, 1, 1}, {1, 0, 1, 1}, {1, 1, 0, 1}, {1, 1, 1, 0},
			{1, 1, 1, 1},
	};
	public static int[] dx = {0, 1, -1, 0};
	public static int[] dy = {1, 0, 0, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cctv = new ArrayList<int[] >();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] > 0 && map[i][j] <= 5) { // CCTV이면 
					cctv.add(new int[] {i, j});
				} else if(map[i][j] == 0) {
					min++;
				}
			}
		}
		
		bfs(min);
		System.out.println(min);
	}

	private static void bfs(int n) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(new Node(n, map));
		
		for(int i=0; i<cctv.size(); i++) {
			int len = queue.size();
			
			for(int t=0; t<len; t++){
				Node node = queue.poll();
				int num =  node.num;
				int x = cctv.get(i)[0];
				int y = cctv.get(i)[1];
				
				if(map[x][y] == 1) {
					queue.offer(cctvDir(node.map, x, y, num, status[0]));
					queue.offer(cctvDir(node.map, x, y, num, status[1]));
					queue.offer(cctvDir(node.map, x, y, num, status[2]));
					queue.offer(cctvDir(node.map, x, y, num, status[3]));
				} else if(map[x][y] == 2) {
					queue.offer(cctvDir(node.map, x, y, num, status[5]));
					queue.offer(cctvDir(node.map, x, y, num, status[8]));
				} else if(map[x][y] == 3) {
					queue.offer(cctvDir(node.map, x, y, num, status[4]));
					queue.offer(cctvDir(node.map, x, y, num, status[6]));
					queue.offer(cctvDir(node.map, x, y, num, status[7]));
					queue.offer(cctvDir(node.map, x, y, num, status[9]));
				} else if(map[x][y] == 4) {
					queue.offer(cctvDir(node.map, x, y, num, status[11]));
					queue.offer(cctvDir(node.map, x, y, num, status[12]));
					queue.offer(cctvDir(node.map, x, y, num, status[13]));
					queue.offer(cctvDir(node.map, x, y, num, status[10]));
					
				} else if(map[x][y] == 5) {
					queue.offer(cctvDir(node.map, x, y, num, status[14]));
				}
			}
		}
	}

	private static Node cctvDir(int[][] map, int x, int y, int num, int[] stat) {
		//  배열 복사
		int[][] result = new int[N][M];
		for(int i=0; i<N; i++) {
			System.arraycopy(map[i], 0, result[i], 0, M);
		}
		for(int d=0; d<4; d++) {
			if(stat[d] == 0) continue;
			int nx = x;
			int ny = y;
			while(true) {
				nx += dx[d];
				ny += dy[d];
				if(nx<0 || nx>=N || ny<0 || ny >=N || result[nx][ny] == 6) break;
				if(result[nx][ny] == 0) {
					result[nx][ny] = 8;
					num--;
				}
			}
			
		}
		if(min > num) min = num;
		return new Node(num, result);
	}
}

class Node {
	int num;
	int[][] map;
	
	public Node(int num, int[][] map) {
		this.num = num;
		this.map = map;
	}
}
