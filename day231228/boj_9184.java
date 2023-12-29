package day231228;


import java.io.*;
import java.util.StringTokenizer;


/*
 * 풀이시간: 1시간
 * 시간복잡도: n^3
 *
 * <풀이>
 * - dp bottom up
 * - 인자 3개 -> 3차원 배열 dp
 *
 * <기타>
 * - 풀이시간 너무 오래걸렸는데..?
 *
 */
public class boj_9184 {

	private static int maxVal;
	private static int[][][] dp;


	private static int w(int a, int b, int c) {
		if (a <= 0 || b <= 0 || c <= 0) { // 1st condition
			return 1;
		} else if (a > maxVal || b > maxVal || c > maxVal) {    // 2nd condition
			return dp[maxVal][maxVal][maxVal];
		} else {    // return dp value
			return dp[a][b][c];
		}
	}


	private static void setDp() {
		// 0 ~ maxIdx까지 dp memoi
		for (int a = 0; a <= maxVal; a++) {
			for (int b = 0; b <= maxVal; b++) {
				for (int c = 0; c <= maxVal; c++) {
					if (a == 0 || b == 0 || c == 0) { // 1st condition
						dp[a][b][c] = 1;
					} else if (a < b && b < c) {    // 3rd condition
						dp[a][b][c] = dp[a][b][c - 1] + dp[a][b - 1][c - 1] - dp[a][b - 1][c];
					} else {    // 4th condition
						dp[a][b][c] = dp[a - 1][b][c] + dp[a - 1][b - 1][c] + dp[a - 1][b][c - 1] - dp[a - 1][b - 1][c - 1];
					}
				}
			}
		}
	}


	public static void main(String[] args) throws IOException {

		// init
		dp = new int[21][21][21];
		maxVal = 20;
		setDp();

		//				for (int i = 1; i <= 20; i++) {
		//					for (int j = 1; j <= 20; j++) {
		//						dp[i][j][0] = 1;
		//						dp[i][0][j] = 1;
		//						dp[0][i][j] = 1;
		//					}
		//				}

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
			int result = w(a, b, c);
			bw.write(String.format("w(%d, %d, %d) = %d\n", a, b, c, result));
		}

		bw.flush();
		bw.close();
	}

}
