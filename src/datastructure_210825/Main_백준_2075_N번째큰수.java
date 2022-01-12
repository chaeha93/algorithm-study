package datastructure_210825;
import java.io.*;
import java.util.*;
	
public class Main_백준_2075_N번째큰수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder()); // 큰 순서대로 우선순위 큐에 담음
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				pq.offer(Integer.parseInt(st.nextToken()));
			}
		}
		for(int i=0; i<N-1; i++) {
			pq.poll();
		}
		System.out.println(pq.poll());
	}
}
