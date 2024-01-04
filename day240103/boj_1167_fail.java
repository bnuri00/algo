package day240103;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/*
 *
 * <풀이>
 *   - 그래프 간선 입력받기
 *   - bfs로 끝까지 가기
 *   - 처음-끝 조합 방문] 체크
 */
public class boj_1167_fail {

	private static int V;
	private static List<Edge>[] adjList;

	private static List<Edge> leafEdgeList;


	private static int logic() {
		int result = 0;
		leafEdgeList.sort((o1, o2) -> o2.length - o1.length);

		boolean[] visited = new boolean[V + 1];
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] { leafEdgeList.get(0).v, 0 });
		visited[leafEdgeList.get(0).v] = true;

		while (!q.isEmpty()) {
			int[] curr = q.poll();

			if (adjList[curr[0]].size() == 1 && visited[adjList[curr[0]].get(0).v]) {
				result = Math.max(result, curr[1]);
			} else {

				for (Edge e : adjList[curr[0]]) {
					if (!visited[e.v]) {
						q.add(new int[] { e.v, curr[1] + e.length });
						visited[e.v] = true;
					}
				}
			}
		}

		return result;
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());

		leafEdgeList = new ArrayList<>();
		adjList = new ArrayList[V + 1];
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

		System.out.println(logic());

	}


	static class Edge {

		int v, length;


		Edge(int v, int length) {
			this.v = v;
			this.length = length;

		}

	}

}
