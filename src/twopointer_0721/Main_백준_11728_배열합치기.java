package twopointer_0721;
import java.io.*;
import java.util.*;

public class Main_백준_11728_배열합치기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer> list = new ArrayList<Integer>();
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<M; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(list);
		for(int i=0; i<list.size(); i++) {
			sb.append(list.get(i)).append(" ");
		}
		System.out.println(sb);

	}

}
