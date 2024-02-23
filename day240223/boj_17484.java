package day240223;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 풀이 시간: 30분
 * 참고: X
 *
 * <접근>
 *  - bfs
 *    - 작은 사이즈로 bfs 풀이 가능
 *  - 동일한 방향 두번 움직이지 못하는 것 주의
 *
 * <다른 방법>
 *  - dp
 *
 */
public class boj_17484 {

	private static class SpaceShip {
		int y, x, fuel, prevDir;
		SpaceShip(int y, int x, int fuel, int prevDir){
			this.y = y;
			this.x = x;
			this.fuel = fuel;
			this.prevDir = prevDir;
		}
	}
	private static int[] dx = {-1, 0, 1};

	private static int bfs(int N, int M, int[][] map){
		int minFuel = Integer.MAX_VALUE;

		// init & add start point
		Queue<SpaceShip> q = new ArrayDeque<>(N * M * 3);
		for (int i = 0; i < M; i++) {
			q.add(new SpaceShip(0, i, map[0][i],  -1));
		}

		while (!q.isEmpty()){
			SpaceShip spaceShip = q.poll();

			if(spaceShip.y == N-1){ // arrive
				minFuel = Math.min(minFuel,spaceShip.fuel);
				continue;
			}

			for (int i = 0; i < 3; i++) {
				if(spaceShip.prevDir == i) continue; // can not move same direction twice

				int ny = spaceShip.y + 1;
				int nx = spaceShip.x + dx[i];
				if(nx < 0 || nx >= M){ // invalid index
					continue;
				}

				q.add(new SpaceShip(ny, nx, spaceShip.fuel + map[ny][nx], i));
			}
		}
		return minFuel;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(bfs(N, M, map));
	}
}
