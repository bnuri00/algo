package day240207;


import java.util.Scanner;


public class boj_1562_fail {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		System.out.println(logic(N));

	}


	private static int logic(int n) {
		if (n < 10) {
			return 0;
		}

		long[][][] dp = new long[n + 1][10][10];
		dp[10][9][0] = 1;

		for (int i = 11; i <= n; i++) {
			for (int j = 1; j < 10; j++) {  // 0으로 시작하는 수는 계단수 아님
				for (int k = 0; k < 10; k++) {
					if (dp[i - 1][j][k] != 0) {
						if (j != 1) {
							dp[i][j - 1][k] += dp[i - 1][j][k];
						}
						if (j != 9) {
							dp[i][j + 1][k] += dp[i - 1][j][k];
						}

						if (k != 0) {
							dp[i][j][k - 1] += dp[i - 1][j][k];
						}
						if (k != 9) {
							dp[i][j][k + 1] += dp[i - 1][j][k];
						}
					}
				}
			}
		}

		long sum = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				sum += dp[n][i][j];
			}
		}
		return (int) (sum % 1_000_000_000);
	}

}
