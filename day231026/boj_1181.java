package day231026;


import java.io.*;
import java.util.*;


public class boj_1181 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		TreeSet<String> treeSet = new TreeSet<>((o1, o2) -> {
			if (o1.length() != o2.length()) {
				return o1.length() - o2.length();
			} else {
				return o1.compareTo(o2);
			}
		});

		// Tree Set에 추가
		for (int i = 0; i < N; i++) {
			treeSet.add(br.readLine());
		}

		// 출력
		StringBuilder sb = new StringBuilder();
		for (String item : treeSet) {
			sb.append(item).append("\n");
		}
		System.out.println(sb);
	}

}
