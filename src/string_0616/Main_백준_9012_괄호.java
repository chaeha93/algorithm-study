package string_0616;
import java.io.*;
import java.util.*;

public class Main_백준_9012_괄호 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String s = br.readLine();
			Stack<Character> stack = new Stack<Character>();
			stack.push(s.charAt(0));
			for (int i = 1; i < s.length(); i++) {
				Character c2 = s.charAt(i);
				if (stack.isEmpty()) {
					stack.push(c2);
				} else {
					Character c = stack.peek();
					if (c.equals('(') && c2.equals(')')) {
						stack.pop();
					} else {
						stack.push(c2);
					}
				}
			}
			if (!stack.isEmpty()) {
				sb.append("NO").append("\n");
			} else {
				sb.append("YES").append("\n");
			}
		}
		System.out.println(sb);
	}

}
