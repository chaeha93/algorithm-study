package adhoc_210714;
import java.io.*;

public class Main_백준_4999_아 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		if(s1.length() >= s2.length()) {
			System.out.println("go");
		} else {
			System.out.println("no");
		}

	}
}
