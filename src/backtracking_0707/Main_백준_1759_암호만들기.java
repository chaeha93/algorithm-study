package backtracking_0707;
import java.io.*;
import java.util.*;

public class Main_백준_1759_암호만들기 {

	private static StringBuilder sb;
	private static int L, C;
	private static String[] arr;
	private static String[] pw;
	private static boolean[] isSelected;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new String[C];
		pw = new String[L];
		isSelected = new boolean[C];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken();
		}

		Arrays.sort(arr);
		makePassword(0, 0);
		System.out.println(sb);
	}

	private static void makePassword(int cnt, int start) {
		if (cnt == L) {
			if (isAvailable()) {
				for (int i = 0; i < L; i++) {
					sb.append(pw[i]);
				}
				sb.append("\n");
			}
			return;
		}

		for (int i = start; i < C; i++) {
			if (!isSelected[i]) {
				pw[cnt] = arr[i];
				isSelected[i] = true;
				makePassword(cnt + 1, i+1);
				isSelected[i] = false;
			}
		}
	}

	private static boolean isAvailable() {
		int mo = 0;
		int ja = 0;
		for (int i = 0; i < L; i++) {
			char c = pw[i].charAt(0);
			if(c == 'a' || c == 'e' || c =='i' || c == 'o' || c == 'u') {
				mo++;
			} else {
				ja++;
			}
			if(mo >= 1 && ja >= 2) return true;
		}
		return false;
	}

}
