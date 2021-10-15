package string_0616;
import java.io.*;
import java.util.*;

public class Main_백준_9081_단어맞추기 {

	private static char[] str;
	private static int size;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			str = br.readLine().toCharArray();
			size = str.length;
			nextPermutation();
			
			for(int i=0; i<size; i++) {
				sb.append(str[i]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void nextPermutation() {
		int i = size - 1; 
		while(i>0 && str[i-1] >= str[i]) { // 뒤에서부터 계산을 했을 때, 오름차순이 깨지는 경우 while문 탈출
			i--;
		}
		if(i == 0) return; // i == 0이면, 맨 앞까지 비교했지만 바꿀 것이 없다는 의미
		i--; // 바꿀 위치를 지정하기 위한 연산
	
		int j = size - 1; // 끝자리부터 다시 비교하기 위한 변수
		while(str[i] >= str[j]) { // i는 고정하고, 뒤부터 비교하였을 때 오름차순이 아니라면 while문 탈출
			j--;
		}

		// swap
		char temp = str[j];
		str[j] = str[i];
		str[i] = temp;
		Arrays.sort(str, i+1, size); // swap한 다음 자리부터 끝자리까지 정렬 
	}
}
