package greedy_210623;
import java.io.*;
import java.util.*;

public class Main_백준_16120_PPAP {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		int cnt = 0;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == 'P') cnt++;
			else if(s.charAt(i) == 'A') {
				if(cnt >=2 && i<s.length()-1 && s.charAt(i+1) == 'P') {
					cnt--;
					i++;
				} else {
					System.out.println("NP");
					return;
				}
			} else {
				System.out.println("NP");
				return;
			}
		}
		if(cnt == 1) {
			System.out.println("PPAP");
		} else {
			System.out.println("NP");
		}
	}
}
