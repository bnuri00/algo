package day231010;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class boj_1520 {

	// 상 하 좌 우
	public static int[] dy = { -1, 1, 0, 0 };
	public static int[] dx = { 0, 0, -1, 1 };

	public static int N, M; // 가로, 세로
	public static int[][] map;
	public static int[][] memoi;

	//	public static void dfsSDeque() {
	//		Deque<int[]> deque = new ArrayDeque<int[]>();
	//
	//		deque.pop();
	//
	//	}


	public static void printMap(int y, int x) {
		System.out.println("y = " + y + ", x = " + x);
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(memoi[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("----------------------");
	}


	public static int dfs(int y, int x) {
		if (y == M - 1 && x == N - 1) {
			return 1;
		}
		if (memoi[y][x] != -1) {
			return memoi[y][x];
		}

		memoi[y][x] = 0;
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if (ny >= 0 && ny < M && nx >= 0 && nx < N && map[ny][nx] < map[y][x]) {
				memoi[y][x] += dfs(ny, nx);
			}
		}

		return memoi[y][x];
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String[] input = br.readLine().split(" ");
		M = Integer.parseInt(input[0]); // 세로
		N = Integer.parseInt(input[1]); // 가로

		// map 초기화
		map = new int[M][N];
		memoi = new int[M][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				memoi[i][j] = -1;
			}
		}

		int result = dfs(0, 0);
		System.out.print(result);
	}

}
