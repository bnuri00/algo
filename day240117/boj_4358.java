package day240117;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;


public class boj_4358 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Map<String, Integer> map = new TreeMap<>();
		int count = 0;
		String input;
		while ((input = br.readLine()) != null && !input.isEmpty()) {
			map.put(input, map.getOrDefault(input, 0) + 1);
			count++;
		}

		// print
		double under = count;   // 분모
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, Integer> item : map.entrySet()) {
			sb.append(item.getKey())
				.append(' ')
				//				.append(Math.round(item.getValue() / under * 1000000) / 10000.f)    // 끝이 0일 경우 출력되지 않아 틀림
				.append(String.format("%.4f", item.getValue() / under * 100))
				.append('\n');
		}
		System.out.println(sb);
	}

}
