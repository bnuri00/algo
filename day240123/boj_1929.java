package day240123;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class boj_1929 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		boolean[] visit = new boolean[N - M + 1];
		for (int i = 2; i <= N / 2; i++) {
			if (i - N >= 0 && i - N < visit.length && visit[i - N]) continue;

			int start = Math.max(2, (M + i - 1) / i);
			for (int j = start; i * j <= N; j++) {
				visit[i * j - M] = true;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < visit.length; i++) {
			if (N == 1 || (M == 1 && i == 0)) continue;
			if (!visit[i]) {
				sb.append(i + M).append('\n');
			}
		}
		System.out.println(sb);

	}

}
