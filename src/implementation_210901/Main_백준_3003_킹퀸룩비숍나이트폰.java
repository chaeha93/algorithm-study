package implementation_210901;
import java.io.*;
import java.util.*;

public class Main_백준_3003_킹퀸룩비숍나이트폰 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] ans = {1, 1, 2, 2, 2, 8};
		for(int i=0; i<6; i++) {
			int num = Integer.parseInt(st.nextToken());
			sb.append(ans[i]-num).append(" ");
		}
		System.out.println(sb);
	}

}
