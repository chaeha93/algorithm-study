import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.offer(2);
		pq.offer(3);
		pq.offer(4);
		pq.offer(5);
		pq.offer(6);
		Integer num = 5;
		int num1 = num;
		System.out.println(num1);
		int num3 = pq.poll();
		System.out.println(num3);

	}

}
