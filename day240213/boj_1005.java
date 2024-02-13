package day240213;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/*
 * 풀이 시간: 1시간 20분
 * 참고: X
 *
 * <접근>
 *  try 1:
 *      - bfs
 *      - 이전에 지어져야 할 건물을 모두 지어야 한다는 점을 간과함
 *  try 2:
 *      - 백트래킹 & dp
 *      - 건설 가능한 최소시간이 구해지지 않았다면 백트래킹으로 구한다
 *      - 이전에 건설해야할 건물의 시간 중 최댓값을 선정해 memoi
 *
 * <다른 방법>
 *  - 위상정렬
 *
 * <실수한 것>
 *  - 문제 조건을 중간에 헷갈려서 시간이 오래걸렸다
 */
public class boj_1005 {

	private static int N, W;
	private static Map<Integer, List<Integer>> inputMap = new HashMap<>();
	private static int[] buildTime = new int[1001]; // 0 : dummy
	private static int[] dp = new int[1001];  // 0 : dummy


	private static int logic(int no) {
		List<Integer> prevBuildList = inputMap.get(no);
		if (prevBuildList == null) {
			return buildTime[no];
		} else {

			int max = 0;
			for (int prev : prevBuildList) {
				if (dp[prev] == Integer.MAX_VALUE) {
					dp[prev] = logic(prev);
				}

				max = Math.max(max, dp[prev]);
			}
			return max + buildTime[no];
		}
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			// init
			inputMap.clear();
			Arrays.fill(dp, Integer.MAX_VALUE);

			// input
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			// input time
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				buildTime[i] = Integer.parseInt(st.nextToken());
			}
			// input order
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				List<Integer> prevBuildList = inputMap.getOrDefault(Y, new ArrayList<>());
				prevBuildList.add(X);
				inputMap.put(Y, prevBuildList);
			}
			W = Integer.parseInt(br.readLine());

			// solve & print
			System.out.println(logic(W));
		}
	}

}
