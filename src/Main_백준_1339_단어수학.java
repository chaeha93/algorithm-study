import java.io.*;
import java.util.*;

public class Main_백준_1339_단어수학 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Integer[] alpha = new Integer[26];
		Arrays.fill(alpha, 0);
		for(int n=0; n<N; n++) {
			String s = br.readLine();
			for(int i=0; i<s.length(); i++) {
				alpha[s.charAt(i)-65] += (int) Math.pow(10, s.length()-1-i);
			}
		}
		
		Arrays.sort(alpha, Collections.reverseOrder());
		int sum = 0;
		int idx = 9;
		for(int i=0; i<10; i++) {
			sum += alpha[i] * idx--; 
		}
		System.out.println(sum);
	}

}
