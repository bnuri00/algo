package day240112;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


/*
 *
 * <풀이>
 *   - 그래프 간선 입력받기
 *   - dfs로 끝까지 가기
 *   - 다시 볼 필요가 없을 경우 (dfs 시작점인 노드, 인접 노드가 2개 이하일 경우) visit 처리
 *   - 모든 리프노드에 대해 dfs
 */
public class boj_1167_fail_dfs {

	private static int V;
	private static List<Edge>[] adjList;

	private static List<Edge> leafEdgeList;

	private static boolean[] visit;

	private static int result;


	private static void dfs(int v, int prevV, int length) {
		if (adjList[v].size() == 1) { // end condition
			result = Math.max(result, length);
			return;
		}

		for (Edge e : adjList[v]) {
			if (!visit[e.v] && e.v != prevV) {
				if (adjList[v].size() == 2) {
					visit[v] = true;
				}
				dfs(e.v, v, length + e.length);
			}
		}

	}


	private static void logic() {
		leafEdgeList.sort((o1, o2) -> o2.length - o1.length);
		for (Edge e : leafEdgeList) {
			visit[e.v] = true;  // 리프노드 방문처리
			int nextNode = adjList[e.v].get(0).v;   // 리프 노드와 연결된 노드 (무조건 1개임)
			if (adjList[nextNode].size() <= 2) {    // 인접 노드가 2개 이하일 경우 다시 방문할 필요 X
				visit[nextNode] = true;
			}
			dfs(nextNode, e.v, e.length);  // 리프 노드와 연결된 노드를 시작으로 dfs
		}
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());

		leafEdgeList = new ArrayList<>();
		adjList = new ArrayList[V + 1];
		visit = new boolean[V + 1];
		for (int i = 1; i <= V; i++) {
			adjList[i] = new ArrayList<>();
		}

		// input
		StringTokenizer st;
		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			int startV = Integer.parseInt(st.nextToken());
			int destV = Integer.parseInt(st.nextToken());

			int adjCount = 0;
			while (destV != -1) {
				int length = Integer.parseInt(st.nextToken());

				adjList[startV].add(new Edge(destV, length));
				destV = Integer.parseInt(st.nextToken());
				adjCount++;
			}

			if (adjCount == 1) {
				leafEdgeList.add(new Edge(startV, adjList[startV].get(0).length));
			}

		}

		logic();
		System.out.println(result);

	}


	static class Edge {

		int v, length;


		Edge(int v, int length) {
			this.v = v;
			this.length = length;

		}

	}

}
