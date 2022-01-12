package string_210616;
import java.io.*;
import java.util.*;

public class Main_백준_1342_행운의문자열 {

	private static String S;
	private static int length, ans;
	private static int[] alphabet;
	private static boolean[] visit;
	private static ArrayList<Character> list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine();
		length = S.length();
		alphabet = new int[26];
		visit = new boolean[length];
		list = new ArrayList<Character>();
		for(int i=0; i<length; i++) {
			alphabet[(int)S.charAt(i)-97]++;
		}
		luckyString(0);
		for(int i=0; i<26; i++) {
			if(alphabet[i] > 1) {
				ans /= factorial(alphabet[i]);
			}
		}
		System.out.println(ans);
	}

	private static int factorial(int num) {
		if(num == 1) return 1;
		return num * factorial(num-1);
	}

	private static void luckyString(int cnt) {
		if(cnt == length) {
			if(check()) {
				ans++;
				return;				
			}
		}
		for(int i=0; i<length; i++) {
			if(!visit[i]) {
				list.add(S.charAt(i));
				visit[i] = true;
				luckyString(cnt+1);
				
				list.remove(list.size()-1);
				visit[i] = false;
			}			
		}
		
	}

	private static boolean check() {
		boolean flag = true;
		for(int i=1; i<length; i++) {
			if(list.get(i) == list.get(i-1)) {
				flag = false;
			}
		}
		return flag;
	}
}
