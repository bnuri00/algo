package day231228;


import java.io.*;
import java.util.StringTokenizer;


/*
 * 풀이시간: 20분
 * 시간복잡도: n^3
 *
 * <풀이>
 * - dp top down
 * - 인자 3개 -> 3차원 배열 dp
 *
 *
 */
public class boj_9184_2 {

	private static int[][][] dp;


	private static int w(int a, int b, int c) {
		if (0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20
			&& dp[a][b][c] != 0) {
			return dp[a][b][c];

		}

		if (a <= 0 || b <= 0 || c <= 0) {
			return 1;
		}
		if (a > 20 || b > 20 || c > 20) {
			return dp[20][20][20] = w(20, 20, 20);
		}
		if (a < b && b < c) {
			return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
		}
		return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);

	}


	public static void main(String[] args) throws IOException {

		// init
		dp = new int[21][21][21];

		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (a == -1 && b == -1 && c == -1) { // input end
				break;
			}

			// logic
			bw.write("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c) + "\n");
		}

		bw.flush();
		bw.close();
	}

}
