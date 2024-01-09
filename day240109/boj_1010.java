package day240109;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
 * 풀이시간: 1시간+
 * 참고: 거의 보고풀었음ㅜㅜ
 *
 * <풀이>
 *      - 조합, 2차원 dp
 *      - 조합 공식을 사용하여 dp 구함
 *
 * <실수한 것>
 *      - factorial로 dp하다가 시간초과남
 *
 */
public class boj_1010 {

	private static int[][] dp;


	private static int calcCombination(int n, int r) {
		r = Math.min(r, n - r);
		if (dp[n][r] > 0) {
			return dp[n][r];
		}

		if (r == 0) {
			return dp[n][r] = 1;
		}
		return dp[n][r] = calcCombination(n - 1, r - 1) + calcCombination(n - 1, r);
	}


	public static void main(String[] args) throws IOException {

		// init
		dp = new int[31][16];

		StringBuilder sb = new StringBuilder();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());   // N <= M
			sb.append(calcCombination(M, N)).append('\n');
		}

		System.out.print(sb);
	}

}
