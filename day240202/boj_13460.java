package day240202;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
 * 풀이 시간: 2시간 30분
 * 참고: 질문게시판 (중간에 틀릴때, 확인 후 moveCount 10번 조건문 수정)
 *
 * <접근>
 *  - 구현, dfs
 *  - 고정된 사물만 board에 기록
 *  - 각 움직임마다 최대 이동
 *      - 벽이어서 이동 종료했는지 / 구멍에 빠져서 종료했는지 확인
 *      - 공이 겹쳤을 때 위치보정 (떼주기)
 *      - 다음 움직임으로
 *
 * <다른 방법>
 *  - bfs (이게 더 쉬울듯;;)
 *  - 이유없는 움직임을 추가로 제거할 수 있음 (ex. 왼 - 왼 또는 왼-오 이동 반복 등..)
 *
 * <실수한 것>
 *  - 조건문, 조건문 순서 자잘하게 잘못함
 *  - 공 움직이는 for문 안에 움직인 count 계산을 넣었다가 벽에서 멈췄는지, 구멍에서 멈췄는지 확인하지 않고 count 0 일때 넘김
 *      - 구멍에서 멈춘 경우는 정답일 수 있으나 이렇게 해서 확인하지 않고 넘어가게 됨
 *      - 단순하게 동작을 나눠서 하는 쪽이 나았다
 *
 * <기타>
 *  - 빡세노..
 *  - 이 로직에서는 조건문, 순서가 아주 중요함
 *  - 최대한 단순하고 깔끔하게 구현하도록 노력하기
 *
 */
public class boj_13460 {

	private static final int FAIL = Integer.MAX_VALUE;

	// 상 하 좌 우
	private static int[] dy = { -1, 1, 0, 0 };
	private static int[] dx = { 0, 0, -1, 1 };
	private static int N, M, min = Integer.MAX_VALUE;
	private static char[][] board;


	private static void logic(int ry, int rx, int by, int bx, int moveCount) {
		if (moveCount == 10) {
			return;
		}

		for (int d = 0; d < dy.length; d++) {

			int nRy = ry;
			int nRx = rx;
			int nBy = by;
			int nBx = bx;

			while (board[nRy += dy[d]][nRx += dx[d]] == '.') ;
			while (board[nBy += dy[d]][nBx += dx[d]] == '.') ;

			//  벽 멈춤 보정
			if (board[nRy][nRx] == '#') {
				nRy -= dy[d];
				nRx -= dx[d];
			}
			if (board[nBy][nBx] == '#') {
				nBy -= dy[d];
				nBx -= dx[d];
			}

			// 구멍에서 멈춤 체크
			if (board[nBy][nBx] == 'O') {   // 파란공이 빠짐 -> 다음 방향 검사 위해 아무 동작 하지 않는다
				continue;
			} else if (board[nRy][nRx] == 'O') {    // 빨간공만 빠짐 -> 현재가 최소인 움직임이므로 return
				min = Math.min(min, moveCount + 1);
				return;
			}

			// 겹쳐진 공 위치 보정
			if (nRy == nBy && nRx == nBx) {
				if (rx == bx) { // 이전 위치가 같은 x축 (세로) 상에 있음
					if (d == 0) {
						// 상
						if (ry < by) {
							nBy++;
						} else {
							nRy++;
						}
					} else if (d == 1) {
						// 하
						if (ry < by) {
							nRy--;
						} else {
							nBy--;
						}
					}

				} else if (ry == by) {
					if (d == 2) {
						// 좌
						if (rx < bx) {
							nBx++;
						} else {
							nRx++;
						}
					} else if (d == 3) {
						// 우
						if (rx < bx) {
							nRx--;
						} else {
							nBx--;
						}
					}
				}
			}

			// go to next move
			logic(nRy, nRx, nBy, nBx, moveCount + 1);

		}
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new char[N][M];
		int ry = -1, rx = -1, by = -1, bx = -1;
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = input.charAt(j);

				// 공 위치만 저장하고 board에는 표시하지 않음
				if (board[i][j] == 'R') {
					ry = i;
					rx = j;
					board[i][j] = '.';
				} else if (board[i][j] == 'B') {
					by = i;
					bx = j;
					board[i][j] = '.';
				}
			}
		}
		logic(ry, rx, by, bx, 0);
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);

	}

}
