package day231021;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


public class boj_7576 {

	public static int N, M; // 세로, 가로
	public static int max = 0;
	public static int[][] map;
	public static Queue<Point> queue;

	// 상 하 좌 우
	public static int[] dy = { -1, 1, 0, 0 };
	public static int[] dx = { 0, 0, -1, 1 };


	public static void ripe() {
		while (!queue.isEmpty()) {
			Point curr = queue.poll();
			printMap();

			for (int d = 0; d < 4; d++) {
				int ny = curr.y + dy[d];
				int nx = curr.x + dx[d];

				if (ny < 0 || nx < 0 || ny >= N || nx >= M || map[ny][nx] != 0) continue;

				map[ny][nx] = map[curr.y][curr.x] + 1;
				queue.add(new Point(ny, nx));
			}
		}
	}


	public static int checkMap() {
		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) return -1;
				if (map[i][j] > result) {
					result = map[i][j];
				}
			}
		}
		return result - 1;
	}


	public static void printMap() {
		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("----------------------");
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());   // 가로
		N = Integer.parseInt(st.nextToken());   // 세로

		// init
		map = new int[N][M];
		queue = new ArrayDeque<>();

		int ripeNum = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					queue.add(new Point(i, j));
					ripeNum++;
				}
			}
		}

		ripe();
		int result = checkMap();

		System.out.println(result);

	}


	static class Point {

		int y, x;


		Point(int y, int x) {
			this.y = y;
			this.x = x;
		}

	}

}
