package day240124;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/*
 * 풀이 시간: 1시간+
 * 참고: 알고리즘 분류 (dp)
 *
 * <접근>
 *  고민한 거:
 *      - 조합인가 했으나 n이 최대 10,000개라 절대 아님
 *      - 냅색인가 했는데 알고리즘 분류 보고 나서 문제 자세히 읽으니 아니었다
 *  try 1:
 *      - 앞에서부터 dp 계산함
 *      - 연속 3번 마시면 안된다
 *          -i가 현재 관심사인 와인잔의 인덱스일 때,
 *          - O O X, O X O, X O O 의 3가지 경우가 있다. i-2, i-1, i 순서임
 *              - type O O X : dp[i-1]
 *              - type O X O : dp[i-2] + wine[i]
 *              - type X O O : dp[i-3] + wine[i-1] + wind[i]
 *              - 편의상 O로 표현했지만 X 이전에 있는 O는 dp 배열로, 최대값이 계산 완료되었다는 것임
 *                실제로는 해당 인덱스의 와인을 마시지 않았을 수 있다. (ex. 와인이 6 5 4 3 2 1 로 놓여졌을 경우)
 *          - 위의 3가지 경우 중 최댓값을 찾는다
 *
 * <다른 방법>
 *  - X
 *
 * <실수한 것>
 *  - 문제 대충봄
 *
 * <기타>
 *  - 냅색인줄 알앗음 (당연히 위장 제한 잇는줄;; 문제 잘보자..)
 *
 */
public class boj_2156 {

	private static int n;
	private static int[] wine;
	private static int[] dp;


	private static int logic() {
		int result = -1;

		if (n <= 2) {   // 특이케이스
			result = Arrays.stream(wine).sum();
		} else if (n == 3) {
			result = Math.max(wine[0] + wine[1], Math.max(wine[0] + wine[2], wine[1] + wine[2]));
		} else {
			setDp();
			result = dp[n - 1];
		}
		return result;
	}


	private static void setDp() {
		// init
		dp = new int[n];
		dp[0] = wine[0];
		dp[1] = wine[0] + wine[1];
		dp[2] = Math.max(dp[1], Math.max(wine[0] + wine[2], wine[1] + wine[2]));

		for (int i = 3; i < n; i++) {
			dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + wine[i], dp[i - 3] + wine[i] + wine[i - 1]));
		}
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		wine = new int[n];
		for (int i = 0; i < n; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}

		System.out.println(logic());
	}

}
