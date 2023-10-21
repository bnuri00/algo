package day231010;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


public class boj_1012 {

	public static boolean[][] map = new boolean[50][50];
	public static boolean[][] visit = new boolean[50][50];
	// y, x 순서, 시계방향 (상우하좌)
	public static int[][] dir = {
		{ -1, 0 },
		{ 0, 1 },
		{ 1, 0 },
		{ 0, -1 }
	};


	public static void bfs(int M, int N, int startY, int startX) {  // 가로, 세로, 시작Y, 시작X
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(startY, startX));
		visit[startY][startX] = true;

		while (!q.isEmpty()) {
			Node curr = q.poll();
			for (int d = 0; d < 4; d++) {
				int ny = curr.y + dir[d][0];
				int nx = curr.x + dir[d][1];
				if (ny >= 0 && ny < N && nx >= 0 && nx < M && map[ny][nx] && !visit[ny][nx]) {
					visit[ny][nx] = true;
					q.add(new Node(ny, nx));
				}
			}
		}
	}


	public static int logic(int M, int N) { // 가로길이, 세로길이
		int result = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[j][i] && !visit[j][i]) {
					bfs(M, N, j, i);
					result++;
				}
			}
		}
		return result;
	}


	public static void initMap(int M, int N) {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				map[j][i] = false;
				visit[j][i] = false;
			}
		}
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {   // T개의 테스트케이스만큼 반복
			String input = br.readLine();
			st = new StringTokenizer(input);
			int M = Integer.parseInt(st.nextToken());   // 가로
			int N = Integer.parseInt(st.nextToken());   // 세로
			int K = Integer.parseInt(st.nextToken());   // input line 개수

			// set Map
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = true;   // 배추 심어져있는 땅 표시
			}

			sb.append(logic(M, N)).append('\n');

			initMap(M, N);  // 가로, 세로
		}
		sb.deleteCharAt(sb.length() - 1);
		System.out.print(sb);
	}


	static class Node {

		int y;
		int x;


		Node() {}


		Node(int y, int x) {
			this.y = y;
			this.x = x;
		}

	}

}
