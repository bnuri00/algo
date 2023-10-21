package day231021;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 욕심쟁이 판다
 */

public class boj_1937 {

	public static int N;
	public static int[][] map;
	public static int[][] memoi;

	// 상 하 좌 우
	public static int[] dy = { -1, 1, 0, 0 };
	public static int[] dx = { 0, 0, -1, 1 };


	public static void printMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(memoi[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("----------------------");
	}


	public static int dfs(int y, int x) {
		if (memoi[y][x] == -1) {
			memoi[y][x] = 1;
			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				if (ny < 0 || nx < 0 || ny >= N || nx >= N || map[ny][nx] <= map[y][x]) continue;

				memoi[y][x] = Math.max(memoi[y][x], dfs(ny, nx) + 1);

			}
		}
		return memoi[y][x];
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());   // map 크기
		map = new int[N][N];
		memoi = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				memoi[i][j] = -1;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				dfs(i, j);
			}
		}

		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (max < memoi[i][j]) max = memoi[i][j];
			}
		}

		System.out.println(max);
	}

}
