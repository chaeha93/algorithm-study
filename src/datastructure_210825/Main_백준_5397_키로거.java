package datastructure_210825;
import java.io.*;
import java.util.*;

public class Main_백준_5397_키로거 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int L = Integer.parseInt(br.readLine());
		for(int l=0; l<L; l++) {
			String s = br.readLine();
			int size = s.length();
			List<Character> list = new LinkedList<Character>();
			int idx = 0;
			for(int i=0; i<size; i++) {
				char c = s.charAt(i);
				if(c == '<') {
					idx--;
					if(idx < 0) idx = 0;
				} else if (c == '>') {
					idx++;
					if(idx > list.size()) {
						idx = list.size();
					}
				} else if (c == '-') {
					if(idx != 0) {
						list.remove(idx-1);
					}
				} else {
					list.add(idx, c);
					idx++;
				}
			}
			for(char c : list) {
				sb.append(c);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
