package string_0616;
import java.io.*;

public class Main_백준_1747_소수팰린드롬 {

	private static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		while (true) {
			if (palindrome() && prime()) {
				break;
			} else {
				N++;
			}
		}
		System.out.println(N);
	}

	private static boolean prime() {
		if (N == 1)
			return false;
		for (int i = 2; i <=Math.sqrt(N); i++) {
			if (N % i == 0) {
				return false;
			}
		}
		return true;

	}

	private static boolean palindrome() {
		String num = String.valueOf(N);
		for(int i=0; i<=num.length()/2; i++) {
			if(num.charAt(i) != num.charAt(num.length()-1-i)) return false;
		}
		return true;
	}

}
