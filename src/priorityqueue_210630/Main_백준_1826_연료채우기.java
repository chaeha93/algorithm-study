package priorityqueue_210630;
import java.io.*;
import java.util.*;

public class Main_백준_1826_연료채우기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine()); // 주유소의 개수
		int[][] station = new int[N][2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			station[i][0] = Integer.parseInt(st.nextToken()); // 성경이의 시작 위치에서 주유소까지의 거리
			station[i][1] = Integer.parseInt(st.nextToken()); // 주유소에서 채울 수 있는 연료의 양
		}
		st = new StringTokenizer(br.readLine(), " ");
		int L = Integer.parseInt(st.nextToken()); // 성경이의 위치에서 마을까지의 거리
		int P = Integer.parseInt(st.nextToken()); // 트럭에 원래 있던 연료의 양
		
		Arrays.sort(station, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
			
		});
		int count = 0; // 주유소를 들리는 횟수
		int index = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		while(L > P) {
			while(index<N && station[index][0] <= P) {
				pq.offer(station[index++][1]);
			}
			if(pq.isEmpty()) {
				count = -1;
				break;
			} else {
				count++;
				P += pq.poll();
			}
		}
		System.out.println(count);
	}

}
