package day231026;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.TreeSet;


public class boj_1181_pq {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> {
			if (o1.length() != o2.length()) {
				return o1.length() - o2.length();
			} else {
				return o1.compareTo(o2);
			}
		});

		// Priority Queue에 추가
		for (int i = 0; i < N; i++) {
			pq.add(br.readLine());
		}

		// 출력
		StringBuilder sb = new StringBuilder();
		String prevItem = pq.poll();
		sb.append(prevItem).append('\n');

		while (!pq.isEmpty()) {
			String currItem = pq.poll();
			if (!prevItem.equals(currItem)) {
				sb.append(currItem).append('\n');
				prevItem = currItem;
			}
		}
		System.out.println(sb);
	}

}
