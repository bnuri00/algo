package day240129;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;


public class boj_1004_fail {

	private static final int[] dy = { -1, 1, 0, 0 };
	private static final int[] dx = { 0, 0, -1, 1 };
	static int[][] map = new int[2001][2001];


	private static void initMap() {
		for (int i = 0; i < 2001; i++) {
			Arrays.fill(map[i], 0);
		}
	}


	private static void setMap(int j, int cx, int cy, int r) {
		int convertedCx = cx + 1000;
		int convertedCy = cy + 1000;
		int startX = convertedCx - r;
		int startY = convertedCy - r;
		int endX = convertedCx + r;
		int endY = convertedCy + r;

		for (int y = startY; y <= endY; y++) {
			for (int x = startX; x <= endX; x++) {
				if (Math.pow(convertedCy - y, 2) + Math.pow(convertedCx - x, 2) <= r * r) {
					map[y][x] |= 1 << j;    // 지도에 원 표시하기
				}
			}
		}

	}


	private static int logic(int x1, int y1, int x2, int y2) {
		// 좌표를 로직에 맞추어 수정
		int startX = x1 + 1000;
		int startY = y1 + 1000;
		int destX = x2 + 1000;
		int destY = y2 + 1000;

		int[][] dijk = new int[2001][2001];
		for (int i = 0; i < 2001; i++) {
			Arrays.fill(dijk[i], Integer.MAX_VALUE);
		}

		Queue<int[]> q = new ArrayDeque<>();
		dijk[startY][startX] = 0;
		q.add(new int[] { startY, startX });

		while (!q.isEmpty()) {
			int[] currLocation = q.poll();

			for (int d = 0; d < 4; d++) {
				int ny = currLocation[0] + dy[d];
				int nx = currLocation[1] + dx[d];

				if (ny < 0 || nx < 0 || ny >= 2001 || nx >= 2001) {
					continue;
				}

				int nCount = dijk[currLocation[0]][currLocation[1]] +
					Integer.bitCount(map[ny][nx] - map[currLocation[0]][currLocation[1]]);

				if (nCount >= dijk[ny][nx]) {   // 다음 위치의 계산 결과 이전보다 크거나 같아서 변화 X
					continue;
				}

				dijk[ny][nx] = nCount;
				if (ny == destY && nx == destX) {   // at the destination
					continue;
				}

				q.add(new int[] { ny, nx });

			}

		}

		return dijk[destY][destX];
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			initMap();

			// input
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			int n = Integer.parseInt(br.readLine());
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				int cx = Integer.parseInt(st.nextToken());
				int cy = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());

				setMap(j, cx, cy, r);

			}

			System.out.println(logic(x1, y1, x2, y2));
		}
	}

}
