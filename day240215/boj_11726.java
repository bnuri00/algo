package day240215;


import java.util.Scanner;


public class boj_11726 {

	private static int[] dp = new int[2001];


	private static int logic(int n) {
		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i - 2] + dp[i - 1]) % 10_007;
		}
		return dp[n];
	}

	//	private static int logic(int n) {
	//		if (dp[n] != 0) return dp[n];
	//		return dp[n] = (logic(n - 2) + logic(n - 1)) % 10_007;
	//	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;

		System.out.println(logic(N));

	}

}
