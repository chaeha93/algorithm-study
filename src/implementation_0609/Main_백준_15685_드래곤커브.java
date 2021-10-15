package implementation_0609;
import java.io.*;
import java.util.*;

public class Main_백준_15685_드래곤커브 {
	
    private static boolean[][] map;
    public static int[] di = {1, 0, -1, 0};
    public static int[] dj = {0, -1, 0, 1};
	private static int ans;
    
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	map = new boolean[101][101];
    	for(int tc=1; tc<=N; tc++) {
    		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    		int x = Integer.parseInt(st.nextToken());
    		int y = Integer.parseInt(st.nextToken());
    		int d = Integer.parseInt(st.nextToken());
    		int g = Integer.parseInt(st.nextToken());
    		
    		dragonCurve(x, y, d, g);
    		
    		// 정사각형 개수 조사
    		ans = 0;
    		for(int i=0; i<100; i++) {
    			for(int j=0; j<100; j++) {
    				if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1]) ans++;
    			}
    		}
    	}
    	System.out.println(ans);
    	
    }

	private static void dragonCurve(int x, int y, int d, int g) {
		List<Integer> list = new ArrayList<Integer>(); // 방향을 저장
		list.add(d);
		
		for(int i=1; i<=g; i++) { // 세대 만큼
			for(int j=list.size()-1; j>=0; j--) {
				int dir = (list.get(j)+1)%4;
				list.add(dir);
			}
		}
		
		map[x][y] = true;
		for(int dir : list) {
			x += di[dir];
			y += dj[dir];
			map[x][y] = true;
		}
	}
}