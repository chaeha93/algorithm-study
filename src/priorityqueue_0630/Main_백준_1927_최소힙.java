package priorityqueue_0630;
import java.io.*;
import java.util.*;

public class Main_백준_1927_최소힙 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				if(pq.isEmpty()) {
					sb.append(0).append("\n");
				} else {
					sb.append(pq.poll()).append("\n");
				}
			} else {
				pq.offer(num);
			}
		}
		System.out.println(sb);
	}

}
