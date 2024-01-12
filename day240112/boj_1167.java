package day240112;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


/*
 * 풀이시간: 많이걸림
 * 참고: 거의 보고풀었다
 *
 * <풀이>
 * 모든 점에서부터 제일 멀리있는 정점은 트리의 지름 중 한 끝점을 항상 포함한다.
 *
 * 1. 임의의 정점에서 가장 먼 정점 구하기
 * 2. 1에서 구한 정점에서 가장 먼 정점까지 거리
 *      => 트리의 지름
 *
 *
 * <실수한 것>
 * - 1차 시도 bfs + 엣지가 가장 긴 리프노드            (day240103.boj_1167_fail_bfs)
 *      => 로직 자체가 틀림
 * - 2차시도 dfs + 리프노드 + 가지치기  (day240112.boj_1167_fail_dfs)
 *      => 시간초과
 * - 메모리, 시간 계산 좀 잘 해보자;;
 *      - int[10^8] : 400MB
 *      - 10^8 번 : 1초
 * - dp로 안되나??
 *      - n^n을 피할 수 없을 것임
 */
public class boj_1167 {

	private static int V;
	private static List<Edge>[] adjList;
	private static boolean[] visit;

	private static int maxLength = 0;
	private static int node;


	private static void dfs(int v, int length) {
		// end condition
		if (adjList[v].size() == 1 && length != 0) {
			if (maxLength < length) {
				node = v;
				maxLength = length;
			}
			return;
		}
		visit[v] = true;

		for (Edge e : adjList[v]) {
			if (!visit[e.v]) {
				dfs(e.v, length + e.length);
			}
		}

	}


	public static void main(String[] args) throws IOException {
		// init & input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		adjList = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			adjList[i] = new ArrayList<>();
		}

		StringTokenizer st;
		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			int startV = Integer.parseInt(st.nextToken());
			int destV = Integer.parseInt(st.nextToken());

			while (destV != -1) {
				int length = Integer.parseInt(st.nextToken());

				adjList[startV].add(new Edge(destV, length));
				destV = Integer.parseInt(st.nextToken());
			}

		}

		// 트리 지름 구하기
		visit = new boolean[V + 1];
		dfs(1, 0);
		Arrays.fill(visit, false);
		dfs(node, 0);

		// print result
		System.out.println(maxLength);
	}


	static class Edge {

		int v, length;


		Edge(int v, int length) {
			this.v = v;
			this.length = length;

		}

	}

}
