package nosubject_1208;
import java.io.*;

public class Main_백준_16486_운동장한바퀴 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int d1 = Integer.parseInt(br.readLine());
		int d2 = Integer.parseInt(br.readLine());
		double l = 2 * 3.141592 * d2;
		double area = l + d1 + d1;
		System.out.println(area);
	}
}
