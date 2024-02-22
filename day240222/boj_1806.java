package day240222;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
 * 풀이 시간: 1시간
 * 참고: 질문게시판
 *
 * <접근>
 *  - 누적합 구해서 이분탐색
 *
 * <다른 방법>
 *  -
 *
 * <실수한 것>
 *  - 이분탐색 구현시 실수 있었음
 *  - 문제 답 없을때 출력 놓쳐서 잘못함
 *  - 인덱스 범위 실수
 *
 * <기타>
 *  - 잘못한게 너무 많다
 *
 */
public class boj_1806 {

	private static int binarySearch(int index, int N, int S, int[] sumArr) {
		int startIndexItem = sumArr[index];

		int leftIndex = index + 1;
		int rightIndex = N;

		while (leftIndex < rightIndex) {
			int newIndex = leftIndex + (rightIndex - leftIndex) / 2;
			if (sumArr[newIndex] - startIndexItem == S) {
				rightIndex = newIndex;
				break;
			}

			if (sumArr[newIndex] - startIndexItem > S) {
				rightIndex = newIndex - 1;
			} else if (sumArr[newIndex] - startIndexItem < S) {
				leftIndex = newIndex + 1;
			}
		}

		if (sumArr[rightIndex] - startIndexItem < S) {
			rightIndex++;
			if (rightIndex > N) {
				return -1;
			}

		}

		return rightIndex - index;
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		// 누적합 구하기
		int[] sumArr = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());
			sumArr[i] = sumArr[i - 1] + num;
		}

		int length = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			int currMinLength = binarySearch(i, N, S, sumArr);
			if (currMinLength != -1) {
				length = Math.min(length, currMinLength);
			}
		}
		System.out.println(length == Integer.MAX_VALUE ? 0 : length);
	}

}
