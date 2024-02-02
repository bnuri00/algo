package day240202;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


/*
 * 백준 1700 멀티탭 스케줄링
 *
 * 풀이 시간: 1시간 10분
 * 참고: 코드빼고 다봄..(그리디 조건, 반례)
 * 링크: https://www.acmicpc.net/problem/1700
 *
 * <접근>
 * - 그리디
 * try 1:
 *      - 가장 적은 빈도로 사용하는 전기용품 콘센트를 빼려고 했으나
 *      - 틀림..
 *      - 반례:
 * 			2 9
 *			1 2 3 1 2 3 1 2 3
 *			-> 정답 : 4, 이전 코드 답: 5
 * try 2:
 *      - 남는 콘센트가 없을 경우 가장 나중에 쓰는 or 사용하지 않는 전기용품을 찾는다
 *
 * <기타>
 *  - 알고리즘 하다가 os 공부한 느낌
 *
 */
public class boj_1700 {

	private static int getLatestUseItem(Set<Integer> multiTab, int[] input, int startIndex) {
		// set에 있는 item 중 가장 나중에 사용되는 or 이후 사용없는 item 찾기
		int index = -1;
		for (Integer item : multiTab) {
			int tmpIndex = startIndex;

			while (input[tmpIndex] != item) {
				tmpIndex++;
				if (tmpIndex >= input.length) {
					return item;
				}
			}
			index = Math.max(index, tmpIndex);

		}
		return input[index];
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] input = new int[K];    // 입력된 사용 순서 저장
		for (int i = 0; i < K; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		Set<Integer> multiTab = new HashSet<>(N);
		int plugOffCount = 0;
		for (int i = 0; i < K; i++) {
			int item = input[i];
			if (!multiTab.contains(item)) {
				if (multiTab.size() >= N) {
					if (i != K - 1) {   // 마지막 인덱스 indexOutOfBound 발생 방지
						multiTab.remove(getLatestUseItem(multiTab, input, i + 1));
					}
					plugOffCount++;
				}

				multiTab.add(item);

			}

		}

		System.out.println(plugOffCount);
	}

}
