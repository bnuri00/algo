package day240122;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/*
 * 풀이 시간: 2시간+
 * 참고: 플로이드-와샬 알고리즘
 *
 * <접근>
 *  - 출발보다 시간이 돌아가있는 경우?
 *      - 웜홀 -> 웜홀 출발지로 돌아가는 경로 등~~
 * try 1:
 *  - 웜홀을 조합으로 선택해서 해당 웜홀을 거친 경로중 최단거리 만들기
 *  - 로 생각하다가 많은 노드를 반복적으로 탐색해야 할 것 같아 플로이드-와샬로 접근
 *
 * try 2:
 *  - 플로이드-와샬로 구현
 *      - 도로 -> 양방향, 양수 가중치
 *      - 웜홀 -> 단방향, 음수 가중치
 *  - 특히 출발때보다 시간이 돌아가있는 경우 -> 음수 사이클임
 *      - 알고리즘 수행 후 자기 자신에게 가는 간선 거리가 0보다 작은 경우가 있으면 YES
 *      - 없으면 NO
 *
 * <다른 방법>
 *  - 벨만-포드로 구현
 *      - 원래 문제 의도인듯
 *      - 왜 된거지???
 *      - 벨만포드 모름..., 담에 해보기
 *
 * <실수한 것>
 *  -
 *
 * <기타>
 *  - 왜 되지..??
 *      - 시간 제한이 2초인데 1초 걸렸음
 *      - TC = 5, 모든 TC의 N이 500일 경우 6억번 반복됨
 *      - 간단한 연산의 경우 1초에 10억번~20억번 가능하다고..
 *          - worst case의 floyd()에서 발생한 연산 횟수는 500^2 * 500 * 3 * 5 ≈ 18억
 *
 *  - 플로이드-와샬 알고리즘이 성립하는 이유를 명확히 설명할 수 있도록 고민해보기
 *      - 알고리즘 수행 후 최단거리가 보장되는 이유를 잘 모르겠음
 *      - update 한번 더 안해도 되나 그런거~~
 *
 */
public class boj_1865 {

	private static final int INF = 1_000_000;
	private static int N, M, W;
	private static int[][] adj;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기

		for (int tc = 0; tc < TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());   // number of place
			M = Integer.parseInt(st.nextToken());   // number of road
			W = Integer.parseInt(st.nextToken());   // number of wormhole
			adj = new int[N + 1][N + 1];    // 0 : dummy

			// init INF & self
			for (int i = 1; i <= N; i++) {
				Arrays.fill(adj[i], INF);
				adj[i][i] = 0;
			}

			// input road
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				if (adj[S][E] > T) {
					adj[S][E] = T;
					adj[E][S] = T;
				}
			}

			// input wormhole
			for (int i = 0; i < W; i++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				adj[S][E] = Math.min(adj[S][E], -1 * T);    // wormhole 에서 T는 줄어드는 시간
			}

			System.out.println(logic() ? "YES" : "NO");
		}

		//실험할 코드 추가

		long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
		System.out.println("시간차이(ms) : " + (afterTime - beforeTime));
	}


	private static void floyd() {
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
				}
			}
		}
	}


	public static boolean logic() {
		floyd();
		for (int i = 1; i <= N; i++) {
			if (adj[i][i] < 0) {
				return true;
			}
		}
		return false;
	}

}
