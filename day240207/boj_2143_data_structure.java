package day240207;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


/*
 * <접근>
 *  - 배열 합 구한 후 map에 저장
 *
 * <다른 방법>
 *  - 해시맵 하나 만들고 다른 부배열 합 만들면서 바로 카운팅해주는 것이 더 빠름
 *
 */
public class boj_2143_data_structure {

	private static Map<Integer, Integer> makeSub(int[] input) {
		Map<Integer, Integer> sub = new HashMap<>();
		sub.put(input[0], 1);
		for (int i = 1; i < input.length; i++) {
			sub.put(input[i], sub.getOrDefault(input[i], 0) + 1);
			for (int j = 0; j < i; j++) {
				sub.put(input[i] - input[j], sub.getOrDefault(input[i] - input[j], 0) + 1);
			}
		}
		return sub;
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		int n = Integer.parseInt(br.readLine());

		// A 배열 입력받아 바로 누적합
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] sumA = new int[n];
		sumA[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < n; i++) {
			sumA[i] = sumA[i - 1] + Integer.parseInt(st.nextToken());
		}

		// B 배열 입력받아 바로 누적합
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] sumB = new int[m];
		sumB[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < m; i++) {
			sumB[i] = sumB[i - 1] + Integer.parseInt(st.nextToken());
		}

		// 부배열 합 구하기
		Map<Integer, Integer> subA = makeSub(sumA);
		Map<Integer, Integer> subB = makeSub(sumB);

		long count = 0;
		for (Map.Entry<Integer, Integer> entry : subA.entrySet()) {
			count += (long) entry.getValue() * subB.getOrDefault(T - entry.getKey(), 0);
		}
		System.out.println(count);

	}

}
