import java.io.*;
import java.util.*;

public class Main_백준_1916_최소비용구하기 {
	
	static class Node implements Comparable<Node>{
		int end; // 정점
		int weight; // 가중치
		
		
		public Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}

	private static int N;
	private static ArrayList<ArrayList<Node>> list;
	private static int[] distance;
	private static int start, end;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()); // 도시의 개수
		int M = Integer.parseInt(br.readLine()); // 버스의 개수
		list = new ArrayList<ArrayList<Node>>();
		distance = new int[N+1];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		for(int i=0; i<=N; i++) {
			list.add(new ArrayList<Node>());
		}
		
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list.get(a).add(new Node(b, c));
		}
		st = new StringTokenizer(br.readLine(), " ");
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		System.out.println(dijkstra());
	}

	private static int dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		boolean[] visited = new boolean[N+1];
		
		pq.offer(new Node(start, 0));
		distance[start] = 0;
		visited[start] = true;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			for(Node next : list.get(cur.end)) {
				if(!visited[next.end] && distance[cur.end] + next.weight < distance[next.end]) {
					distance[next.end] = distance[cur.end] + next.weight;
					pq.offer(new Node(next.end, distance[next.end]));
					visited[cur.end] = true;
				}
			}
		}
		return distance[end];
	}

}
