package day240111;


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
 *      - bfs를 하며 영역 안의 양 개수, 늑대 개수 바로 세기
 *      - visit 처리는 지도에 바로
 *      - 양 <= 늑대 일 경우:
 *          전체 늑대 개수 += 현재 늑대 개수
 *      - 그 외:
 *          전체 양 개수 += 현재 양 개수
 *      - 탈출칸은 신경쓸 필요 X (맨 처음 모든 동물은 영역 안에 잇음 )
 *
 */
public class boj_3184 {

	private static final char WALL = '#';
	private static final char WOLF = 'v';
	private static final char SHEEP = 'o';
	private static final char VISIT = 'x';
	private static int[] dy = { -1, 1, 0, 0 };
	private static int[] dx = { 0, 0, -1, 1 };
	private static int R, C;
	private static char[][] map;
	private static int totalWolfCount, totalSheepCount;


	private static void bfs(int y, int x) {
		int cellWolfCount = 0, cellSheepCount = 0;

		Queue<Point> q = new ArrayDeque<>();
		q.add(new Point(y, x));

		// 현재 위치가 늑대일 경우 or 양일 경우 카운팅
		if (map[y][x] == WOLF) {
			cellWolfCount++;
		} else if (map[y][x] == SHEEP) {
			cellSheepCount++;
		}
		map[y][x] = VISIT;  // 지도에 바로 visit 처리

		while (!q.isEmpty()) {
			Point curr = q.poll();
			for (int d = 0; d < 4; d++) {
				int ny = curr.y + dy[d];
				int nx = curr.x + dx[d];

				// 영역 밖 | 이미 방문 | 벽일 경우 넘어감
				if (ny < 0 || nx < 0 || ny >= R || nx >= C || map[ny][nx] == VISIT || map[ny][nx] == WALL) {
					continue;
				}

				q.add(new Point(ny, nx));

				if (map[ny][nx] == WOLF) {
					cellWolfCount++;
				} else if (map[ny][nx] == SHEEP) {
					cellSheepCount++;
				}
				map[ny][nx] = VISIT;
			}
		}

		if (cellSheepCount <= cellWolfCount) {
			totalWolfCount += cellWolfCount;
		} else {
			totalSheepCount += cellSheepCount;
		}

	}


	private static void logic() {

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != WALL) {
					bfs(i, j);  // 벽이 아닐 경우 bfs 실행
				}
			}
		}
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		logic();

		System.out.println(totalSheepCount + " " + totalWolfCount);

	}


	static class Point {

		int y, x;


		Point(int y, int x) {
			this.y = y;
			this.x = x;
		}

	}

}
