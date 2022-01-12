package string_210616;
import java.io.*;
import java.util.*;

public class Main_백준_1181_단어정렬 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}
		
		Arrays.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length()) {
					return o1.compareTo(o2);
				}
				return o1.length() - o2.length();
			}
			
		});
		
		sb.append(arr[0]).append("\n");
		for(int i=1; i<N; i++) {
			if(arr[i-1].equals(arr[i])) continue;
			sb.append(arr[i]).append("\n");
		}
		System.out.println(sb);
	}
}
