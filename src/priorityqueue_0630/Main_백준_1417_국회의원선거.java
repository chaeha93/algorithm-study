package priorityqueue_0630;
import java.io.*;
import java.util.*;

public class Main_백준_1417_국회의원선거 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<int[] > pq = new PriorityQueue<>(new Comparator<int[] >() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[1] - o1[1];
			}
			
		});
		int da_vote = Integer.parseInt(br.readLine());
		for(int i=2; i<=N; i++) {
			int vote = Integer.parseInt(br.readLine());
			pq.offer(new int[] {i, vote});
		}
		
		int cnt = 0;
		while(!pq.isEmpty()) {
			int[] p = pq.poll();
			if(p[1] < da_vote) break;
			cnt++;
			da_vote++;
			p[1]--;
			pq.offer(p);
		}
		System.out.println(cnt);
	}

}
