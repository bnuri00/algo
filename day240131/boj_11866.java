package day240131;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class boj_11866 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		List<Integer> list = new LinkedList<>(IntStream.range(1, N + 1).boxed().collect(Collectors.toList()));

		StringBuilder sb = new StringBuilder("<");
		int index = 0;
		while (!list.isEmpty()) {
			index = (index - 1 + K) % list.size(); // 이전에 원소 하나를 없앴으니까 -1
			sb.append(list.remove(index)).append(", ");
		}
		sb.delete(sb.length() - 2, sb.length());
		sb.append('>');
		System.out.println(sb);
	}

}
