package day240201;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class sw_7954 {

	// 하, 우
	private static int[] dy = { 1, 0 };
	private static int[] dx = { 0, 1 };

	private static int n, max;
	private static int[][] map;
	private static boolean[][] visit;


	private static void logic(int y, int x, int sum, int count) {
		if (count == 4) {
			max = Math.max(max, sum);
			return;
		}

		for (int i = y; i < n; i++) {
			for (int j = (i == y ? x : 0); j < n; j++) {

				if (visit[i][j]) {
					continue;
				}

				visit[i][j] = true;
				logic(i, j, sum, count); // 선택 X

				for (int d = 0; d < dy.length; d++) {

					int ny = i + dy[d];
					int nx = j + dx[d];
					if (ny < 0 || nx < 0 || ny >= n || nx >= n || visit[ny][nx]) {
						continue;
					}

					int bindSum = map[i][j] + map[ny][nx];

					visit[ny][nx] = true;
					logic(i, j, sum + bindSum, count + 1);
					visit[ny][nx] = false;
				}

				visit[i][j] = false;

			}
		}

		max = Math.max(max, sum);

	}


	public static void main(String[] args) throws IOException {
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visit = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		logic(0, 0, 0, 0);
		System.out.println(max);

	}

}