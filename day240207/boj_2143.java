package day240207;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


/*
 * 풀이 시간: 2시간 30분?
 * 참고: 백준 질문게시판(오버플로)
 *
 * <접근>
 *  - 배열 합 구한 후 정렬, 이분탐색
 *
 * <다른 방법>
 *  - 찾아보니 해시맵 두개로 하면 아주 간단함..그러게..
 *
 */
public class boj_2143 {

	private static int T;
	private static List<Integer> subA;
	private static List<Integer> subB;


	private static List<Integer> makeSub(int[] input) {
		List<Integer> sub = new ArrayList<>();

		// make sum
		for (int i = 1; i < input.length; i++) {
			input[i] += input[i - 1];
		}

		sub.add(input[0]);
		for (int i = 1; i < input.length; i++) {
			sub.add(input[i]);
			for (int j = 0; j < i; j++) {
				sub.add(input[i] - input[j]);
			}
		}

		return sub;
	}


	private static int binarySearch(int num, List<Integer> list) {
		int left = 0;
		int right = list.size() - 1;

		while (left < right) {
			int idx = (right - left) / 2 + left;
			int half = list.get(idx);
			if (num < half) {
				right = idx - 1;
			} else if (num > half) {
				left = idx + 1;
			} else {
				right = idx;
				break;
			}
		}

		// 동일 갯수 계산
		if (right < 0 || num != list.get(right)) {
			return 0;
		} else {
			int count = 1;
			int idx = right;
			while (idx < list.size() - 1 && num == list.get(++idx)) {
				count++;
			}
			idx = right;
			while (idx > 0 && num == list.get(--idx)) {
				count++;
			}
			return count;
		}
	}


	private static long logic() {
		long result = 0;
		Collections.sort(subA);
		Collections.sort(subB);

		int prevA = subA.get(0);
		int aCount = 1;
		for (int i = 1; i < subA.size(); i++) {
			if (prevA == subA.get(i)) {
				aCount++;
			} else {
				int bCount = binarySearch(T - prevA, subB);
				result += ((long) aCount) * bCount;

				// reset
				aCount = 1;
				prevA = subA.get(i);
			}
		}
		int bCount = binarySearch(T - subA.get(subA.size() - 1), subB);
		result += ((long) aCount) * bCount;

		return result;
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] inputA = new int[n];
		for (int i = 0; i < n; i++) {
			inputA[i] = Integer.parseInt(st.nextToken());
		}

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] inputB = new int[m];
		for (int i = 0; i < m; i++) {
			inputB[i] = Integer.parseInt(st.nextToken());
		}

		subA = makeSub(inputA);
		subB = makeSub(inputB);

		System.out.println(logic());

	}

}
