package day231021;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


public class boj_2178 {

	public static int N, M; // 세로, 가로
	public static int[][] map;

	// 상 하 좌 우
	public static int[] dy = { -1, 1, 0, 0 };
	public static int[] dx = { 0, 0, -1, 1 };


	public static void bfs() {
		boolean[][] visit = new boolean[N][M];
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] { 0, 0 });
		visit[0][0] = true;

		while (!q.isEmpty()) {
			int[] curr = q.poll();

			if (curr[0] == N - 1 && curr[1] == M - 1) {
				return;
			}

			for (int d = 0; d < 4; d++) {
				int ny = curr[0] + dy[d];
				int nx = curr[1] + dx[d];
				if (ny < 0 || nx < 0 || ny >= N || nx >= M || map[ny][nx] == 0 || visit[ny][nx]) continue;

				q.add(new int[] { ny, nx });
				map[ny][nx] = map[curr[0]][curr[1]] + 1;
			}
		}

	}


	public static int dfs() {
		return 1;
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
			}
		}
		bfs();
		System.out.println(map[N - 1][M - 1]);
	}

}
