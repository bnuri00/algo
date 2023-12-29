package day231229;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


/*
 * 풀이시간: 1시간 30분
 * 참고: x
 *
 * <풀이>
 * - 불, 지훈이 각각 bfs
 * - 시간만큼만 각각 움직인다
 *
 * <실수한 것>
 * - 불 완탐으로 하다가 시간초과
 *
 * <기타>
 * - 큐의 사이즈를 확인해서 반복문 돌리면 되는데 복잡하게 시간 체크했음, 이상하게 풀었다
 * - 처음 map 입력받을 때부터 큐에 넣는 것이 좋겠다
 */
public class boj_4179 {

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
		int result = -1;

		boolean[][] visited = new boolean[R][C];
		boolean[][] fireVisited = new boolean[R][C];

		Queue<Point> q = new ArrayDeque<>();
		q.add(startPoint);
		visited[startPoint.y][startPoint.x] = true;

		Queue<Point> fireQ = new ArrayDeque<>();
		for (int y = 0; y < R; y++) {
			for (int x = 0; x < C; x++) {
				if (map[y][x] == FIRE) {
					fireQ.add(new Point(y, x, 0));
				}
			}
		}

		int currTime = 0;
		while (!q.isEmpty()) {
			Point currPoint = q.poll();

			if (currPoint.y == 0 || currPoint.x == 0 || currPoint.y == R - 1 || currPoint.x == C - 1) {   // person escape!
				result = currPoint.time + 1;
				break;
			}

			if (currPoint.time == currTime) {   // set time, fire
				// 불 확산시키기
				while (!fireQ.isEmpty() && fireQ.peek().time == currTime) {
					Point p = fireQ.poll();
					for (int d = 0; d < 4; d++) {
						int ny = p.y + dy[d];
						int nx = p.x + dx[d];

						if (ny < 0 || nx < 0 || ny >= R || nx >= C || fireVisited[ny][nx] || map[ny][nx] == WALL) continue;

						map[ny][nx] = FIRE;
						fireVisited[ny][nx] = true;
						fireQ.add(new Point(ny, nx, currPoint.time + 1));
					}
				}

				currTime = currPoint.time + 1;
			}

			for (int d = 0; d < 4; d++) {
				int ny = currPoint.y + dy[d];
				int nx = currPoint.x + dx[d];

				if (ny < 0 || nx < 0 || ny >= R || nx >= C || visited[ny][nx] || (map[ny][nx] == FIRE || map[ny][nx] == WALL)) continue;

				q.add(new Point(ny, nx, currPoint.time + 1));
				visited[ny][nx] = true;
			}

		}

		return result;
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
					startPoint = new Point(i, j, 0);
					map[i][j] = EMPTY;
				}
			}
		}

		int escapeTime = logic();
		System.out.println(escapeTime != -1 ? escapeTime : "IMPOSSIBLE");
	}


	private static class Point {

		int y, x, time;


		Point(int y, int x, int time) {
			this.y = y;
			this.x = x;
			this.time = time;
		}

	}

}
