package nosubject_211006;
import java.io.*;
import java.util.*;

public class Main_백준_1339_단어수학 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Integer[] arr = new Integer[26];
		Arrays.fill(arr, 0);
		for(int n=0; n<N; n++) {
			String s = br.readLine();
			for(int i=0; i<s.length(); i++) {
				arr[s.charAt(i)-65] += (int) Math.pow(10, s.length()-i-1);
			}
		}
		
		Arrays.sort(arr, Collections.reverseOrder());
		int num = 9;
		int sum = 0;
		for(int i=0; i<10; i++) {
			sum += arr[i] * num--;
		}
		System.out.println(sum);
	}
}
