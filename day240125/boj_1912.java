package day240125;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
 * 풀이 시간: 1시간+
 * 참고: X
 *
 * <접근>
 *  try 1:
 *      - 누적합 계산해서 각 원소 순회해서 재계산
 *      - 시간복잡도 n*n 수준으로 잘못된 시도
 *  try 2:
 *      - dp로 이전 누적합 + 현재, 현재 중 최댓값 구해 dp 배열에 저장
 *      - 시간복잡도 n 으로 성공
 *
 * <다른 방법>
 *  - 실제로 이용하는 값은 이전 값과 최댓값이다 -> 변수 두개로 가능함
 *      - max : 합의 최대
 *      - currSum : 이전까지 합, 현재 input과 currSum + 현재 input 중 최댓값으로 갱신
 *
 * <실수한 것>
 *  - 시간복잡도 고려 부족
 *
 */
public class boj_1912 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] dp = new int[N];

		dp[0] = Integer.parseInt(st.nextToken());
		int max = dp[0];
		for (int i = 1; i < N; i++) {
			int input = Integer.parseInt(st.nextToken());
			dp[i] = Math.max(dp[i - 1] + input, input);
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}

}
