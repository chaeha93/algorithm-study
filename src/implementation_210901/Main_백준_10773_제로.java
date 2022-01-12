package implementation_210901;

import java.io.*;
import java.util.*;

public class Main_백준_10773_제로 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int k=0; k<K; k++) {
			int num = Integer.parseInt(br.readLine());
			if(num != 0) {
				list.add(num);
			} else {
				list.remove(list.size()-1);
			}
		}
		
		int sum = 0;
		for(int i=0; i<list.size(); i++) {
			sum += list.get(i);
		}
		System.out.println(sum);
	}

}
