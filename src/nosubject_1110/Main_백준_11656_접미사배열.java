package nosubject_1110;
import java.io.*;
import java.util.*;

public class Main_백준_11656_접미사배열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		String[] arr = new String[str.length()];
		for(int i=0; i<str.length(); i++) {
			String s = "";
			for(int j=i; j<str.length(); j++) {
				s += str.charAt(j);
			}
			arr[i] = s;
		}
		Arrays.sort(arr);
		for(int i=0; i<arr.length; i++) {
			sb.append(arr[i]).append("\n");
		}
		System.out.println(sb);
	}
}
