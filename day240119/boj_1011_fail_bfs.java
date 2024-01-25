package day240119;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


public class boj_1011_fail_bfs {

	private static final int[] move = { -1, 0, 1 };
	private static Queue<Spaceship> q = new ArrayDeque<>();
	private static int visit = 0;


	private static int bfs(int x, int y) {
		if (y - x == 1) {   // 첫 이동에서 y 도착하는 경우
			return 1;
		}

		int count = 1;
		q.add(new Spaceship(x + 1, 1));

		while (!q.isEmpty()) {
			int size = q.size();
			count++;

			for (int i = 0; i < size; i++) {

				Spaceship s = q.poll();

				for (int j = 0; j < move.length; j++) {
					int nextMove = s.previousMove + move[j];
					int nextLocation = s.location + nextMove;

					if (nextMove < 0 || nextLocation > y) { // move valid check
						continue;
					}

					if (nextMove == 1 && nextLocation == y) {   // end condition
						return count;
					}

					q.add(new Spaceship(nextLocation, nextMove));

				}

			}
		}

		return -1;
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			// init
			q.clear();

			// input
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			sb.append(bfs(x, y)).append('\n');
		}

		// print
		System.out.println(sb);
	}


	private static class Spaceship {

		int location;
		int previousMove;


		Spaceship(int location, int previousMove) {
			this.location = location;
			this.previousMove = previousMove;
		}

	}

}
