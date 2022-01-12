package string_210616;
import java.io.*;

public class Main_백준_1110_더하기사이클 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int temp = N;
		int cnt = 0;
		while(true) {
			int num1 = temp / 10;
			int num2 = temp % 10;
			int sum = num1 + num2;
			temp = (num2*10) + (sum%10);
			cnt++;
			if(temp == N) break;
		}
		System.out.println(cnt);
	}

}
