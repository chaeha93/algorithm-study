package string_0616;
import java.io.*;
import java.util.*;

public class Main_백준_1427_소트인사이드 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
		int size = s.length();
		int[] arr = new int[size];
		for(int i=0; i<size; i++) {
			arr[i] = s.charAt(i) - '0';
		}
		Arrays.sort(arr);
		for(int i=size-1; i>=0; i--) {
			sb.append(arr[i]);
		}
		System.out.println(sb);
	}
}
