package day240105;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
 * 풀이시간: 1시간+
 *
 * <풀이>
 *      - board의 왼쪽 위부터 조회
 *          - 오른쪽, 오른쪽아래, 아래, 왼쪽아래  4방향 확인
 *          - 방문하지 않고, 같은 바둑돌이 확인되면 해당 방향 끝까지 확인 후 visit 처리, 이어진 길이 리턴
 *      - visit 처리는 방향별로 한다 (⭐⭐⭐)
 *          - 방향별로 안했을때 -> ㅗ 모양에서 가로모양이 5개일 경우 세로부분 확인시 먼저 조회되어 중간에 조회가 끊김
 *          - 첫번째 돌 조회시에는 visit 여부 확인하지 않음
 *      - 정답 출력은
 *          - 바둑돌 5개 확인되면 -> 해당 바둑돌 출력 \n 가장 왼쪽 위치 출력하기!! index이므로 좌표에 +1 해야댐
 *          -  승부가 결정되지 않았을 경우 (board 전부 순회) -> 0 출력
 *
 * <실수한 것>
 *      - 왼쪽아래방향 안함
 *      - 승부가 결정되지 않았을 경우 출력안함
 *      - visit 방향별로 안함
 *      - 가지가지 했다~~~;;; 풀이시간 너무 오래걸림 반성하기..
 *
 */
public class boj_2615 {

	private static int N;
	// 방향: 우 우하 하 하좌
	private static int[] dy = { 0, 1, 1, 1 };
	private static int[] dx = { 1, 1, 0, -1 };

	private static char[][] board;

	private static boolean[][][] visit;


	private static boolean validIndex(int y, int x) {
		return y < N && x < N && y >= 0 && x >= 0;
	}


	private static int checkLine(int y, int x, int dir) {
		int length = 1;
		char color = board[y][x];

		while (validIndex(y += dy[dir], x += dx[dir]) && !visit[y][x][dir] && board[y][x] == color) {  // 다음 칸이 board를 벗어나지 않음 && 다음 칸이 같은 돌인지 확인
			length++;
			visit[y][x][dir] = true;
		}
		return length;
	}


	private static void printWinResult(int y, int x, int dir) {
		int lasty = y + dy[dir] * 4;
		int lastx = x + dx[dir] * 4;

		System.out.println(board[y][x]);
		if (lastx < x) {
			System.out.println((lasty + 1) + " " + (lastx + 1));
		} else {
			System.out.println((y + 1) + " " + (x + 1));
		}
	}


	private static void logic() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				if (board[i][j] != '0') {
					for (int dir = 0; dir < dy.length; dir++) {
						if (checkLine(i, j, dir) == 5) {
							printWinResult(i, j, dir);
							return;
						}
					}
				}
			}
		}
		// 승부 결정되지 않은 경우 출력
		System.out.println(0);
	}


	public static void main(String[] args) throws IOException {
		N = 19;
		board = new char[N][N];
		visit = new boolean[N][N][dy.length];

		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = st.nextToken().charAt(0);
			}
		}

		// logic
		logic();
	}

}
