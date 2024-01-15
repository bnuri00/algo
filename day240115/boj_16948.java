package day240115;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


public class boj_16948 {

	private static final int[] dy = { -2, -2, 0, 0, 2, 2 };
	private static final int[] dx = { -1, 1, -2, 2, -1, 1 };
	private static boolean[][] visit;
	private static int N, r1, c1, r2, c2;


	private static int bfs() {
		int move = 0;
		Queue<Point> q = new ArrayDeque<>();
		q.add(new Point(r1, c1));

		while (!q.isEmpty()) {

			move++;
			int size = q.size();

			for (int i = 0; i < size; i++) {
				Point curr = q.poll();

				for (int d = 0; d < 6; d++) {
					int ny = curr.y + dy[d];
					int nx = curr.x + dx[d];

					if (ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx]) continue;

					if (ny == r2 && nx == c2) {
						return move;
					}

					q.add(new Point(ny, nx));
					visit[ny][nx] = true;
				}

			}

		}
		return -1;
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		r1 = Integer.parseInt(st.nextToken());
		c1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());

		visit = new boolean[N][N];

		System.out.println(bfs());
	}


	private static class Point {

		int y, x;


		Point(int y, int x) {
			this.y = y;
			this.x = x;
		}

	}

}
