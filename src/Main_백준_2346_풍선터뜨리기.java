import java.io.*;
import java.util.*;

public class Main_백준_2346_풍선터뜨리기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		Deque<int[] > dq = new ArrayDeque<>();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		sb.append("1 ");
		int num = arr[0];
		
		for(int i=1; i<N; i++) {
			dq.add(new int[] {(i+1), arr[i]});
		}
		
		while(!dq.isEmpty()) {
			if(num > 0) { // 양수인 경우
				// 순서 뒤로 돌리기
				for(int i=1; i<num; i++) {
					dq.add(dq.poll());
				}
				int[] nxt = dq.poll();
				num = nxt[1];
				sb.append(nxt[0]).append(" ");
			} else { // 음수인 경우
				for(int i=1; i<-num; i++) {
					dq.addFirst(dq.pollLast());
				}
				int[] nxt = dq.pollLast();
				num = nxt[1];
				sb.append(nxt[0]).append(" ");
			}
		}
		System.out.println(sb);
		
	}

}
