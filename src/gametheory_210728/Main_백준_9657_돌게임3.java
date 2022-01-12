package gametheory_210728;
import java.io.*;

public class Main_백준_9657_돌게임3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if (N % 7 == 0 || N % 7 == 2) {
			System.out.println("CY");
		} else {
			System.out.println("SK");
		}
	}

}
