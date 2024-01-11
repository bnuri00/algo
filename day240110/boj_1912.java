package day240110;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class boj_1912 {

	private static int N, max = Integer.MIN_VALUE;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int sum = 0;
		for (int i = 1; i <= N; i++) {
			int inputNum = Integer.parseInt(st.nextToken());
			max = Math.max(max, inputNum);  // 원소 하나씩 최댓값인지 체크
			sum += inputNum;

			if (sum < 0) {
				sum = 0;    // i까지는 포함X, 음수는 더하면 손해임
			} else {
				max = Math.max(max, sum);
			}

		}

		System.out.println(max);

	}

}
