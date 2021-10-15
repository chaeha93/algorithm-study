import java.io.*;
import java.util.*;

public class Main_백준_16236_아기상어 {
	
	public static class Fish {
		int x, y, time;
		
		public Fish(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
	
	private static int[][] map;
	private static int N;
	public static boolean[][] visited;
	public static Fish shark;
	public static int size = 2;
	public static int eaten = 0;
	public static ArrayList<Fish> feedList = new ArrayList<Fish>();
	public static int ans;

	public static int[] di = {-1, 0, 1, 0};
	public static int[] dj = {0, -1, 0, 1};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) { // 아기 상어라면
					map[i][j] = 0;
					shark = new Fish(i, j, 0);
				}
			}
		}
		
		bfs();
		System.out.println(ans);
		
	}

	private static void bfs() {
		Queue<Fish> queue = new LinkedList<Fish>();
		queue.offer(shark);
		visited[shark.x][shark.y] = true;
		
		while(true) {
			while(!queue.isEmpty()) {
				Fish now = queue.poll();
				int time = now.time;
				
				for(int d=0; d<4; d++) {
					int ni = now.x + di[d];
					int nj = now.y + dj[d];
					
					if(ni<0 || ni>=N || nj<0 || nj>=N || visited[ni][nj]) continue;
					
					// 먹을 수 있는 물고기 리스트에 추가
					if(map[ni][nj] < size && map[ni][nj] != 0) {
						queue.offer(new Fish(ni, nj, time+1));
						visited[ni][nj] = true;
						feedList.add(new Fish(ni, nj, time+1));
					}
					
					// 이동만 가능
					if(map[ni][nj] == size || map[ni][nj] == 0) {
						queue.offer(new Fish(ni, nj, time+1));
						visited[ni][nj] = true;
					}
				}
			}
			
			if(!feedList.isEmpty()) {
				eat();
				visited = new boolean[N][N];
				
				queue.offer(shark);
				visited[shark.x][shark.y] = true;
			} else {
				return;
			}
		}
		
	}

	private static void eat() {
		Collections.sort(feedList, new Comparator<Fish>() {

			@Override
			public int compare(Fish o1, Fish o2) {
				if(o1.time == o2.time) {
					if(o1.x == o2.x) {
						if(o1.y > o2.y) return 1;
						else return -1;
					} else {
						if(o1.x > o2.x) return 1;
						else return -1;
					}
				} else if (o1.time > o2.time) return 1;
				else return -1;
			}
		});
		
		Fish now = feedList.get(0);
		
		shark.x = now.x;
		shark.y = now.y;
		
		if(++eaten == size) {
			size++;
			eaten = 0;
		}
		ans += now.time;
		map[now.x][now.y] = 0;
		feedList.clear();
		
	}
}
