package day231229;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


/*
 * 풀이시간: 30분
 * 참고: x
 *
 * <풀이>
 * - 불, 지훈이 각각 bfs
 * - 시간당 (한턴당) 움직임을 구하기 위해 큐의 사이즈만큼만 꺼내서 사용
 *
 *
 */
public class boj_4179_2 {

	private static final char FIRE = 'F';
	private static final char WALL = '#';
	private static final char EMPTY = '.';
	private static final char INIT_LOCATION = 'J';
	private static int[] dy = { -1, 1, 0, 0 };
	private static int[] dx = { 0, 0, -1, 1 };
	private static int R, C;
	private static char[][] map;
	private static Point startPoint;


	private static int logic() {
		int time = 0;

		boolean[][] visited = new boolean[R][C];
		boolean[][] fireVisited = new boolean[R][C];

		Queue<Point> q = new ArrayDeque<>();
		q.add(startPoint);
		visited[startPoint.y][startPoint.x] = true;

		Queue<Point> fireQ = new ArrayDeque<>();
		for (int y = 0; y < R; y++) {
			for (int x = 0; x < C; x++) {
				if (map[y][x] == FIRE) {
					fireQ.add(new Point(y, x));
				}
			}
		}

		while (!q.isEmpty()) {
			int personNum = q.size();
			int fireNum = fireQ.size();

			// 불 번짐
			for (int i = 0; i < fireNum; i++) {
				Point p = fireQ.poll();
				for (int d = 0; d < 4; d++) {
					int ny = p.y + dy[d];
					int nx = p.x + dx[d];

					if (ny < 0 || nx < 0 || ny >= R || nx >= C || fireVisited[ny][nx] || map[ny][nx] == WALL) continue;

					map[ny][nx] = FIRE;
					fireVisited[ny][nx] = true;
					fireQ.add(new Point(ny, nx));
				}
			}

			// 사람 무브
			for (int i = 0; i < personNum; i++) {
				Point currPoint = q.poll();

				if (currPoint.y == 0 || currPoint.x == 0 || currPoint.y == R - 1 || currPoint.x == C - 1) {   // person escape!
					return ++time;
				}

				for (int d = 0; d < 4; d++) {
					int ny = currPoint.y + dy[d];
					int nx = currPoint.x + dx[d];

					if (ny < 0 || nx < 0 || ny >= R || nx >= C || visited[ny][nx] || (map[ny][nx] == FIRE || map[ny][nx] == WALL)) continue;

					q.add(new Point(ny, nx));
					visited[ny][nx] = true;
				}
			}
			time++;

		}

		return -1;
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String inputLine = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = inputLine.charAt(j);
				if (map[i][j] == INIT_LOCATION) {
					startPoint = new Point(i, j);
					map[i][j] = EMPTY;
				}
			}
		}

		int escapeTime = logic();
		System.out.println(escapeTime != -1 ? escapeTime : "IMPOSSIBLE");
	}


	private static class Point {

		int y, x;


		Point(int y, int x) {
			this.y = y;
			this.x = x;
		}

	}

}
