package day231109;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/**
 * 다익스트라
 * priority queue
 */

public class boj_1753 {

	public static int INF = Integer.MAX_VALUE;
	public static List<Edge>[] adjList;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());

		adjList = new List[V + 1];  // 0 : dummy
		for (int i = 0; i < V + 1; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adjList[u].add(new Edge(v, w));
		}

		//		int[] dijk = new int[V + 1];  // 0 : dummy
		//		Arrays.fill(dijk, INF);

		int[] dijkArr = dijk(V, K);

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			sb.append(dijkArr[i] == INF ? "INF" : dijkArr[i]).append("\n");
		}
		sb.deleteCharAt(sb.length() - 1);
		System.out.print(sb);
	}


	static int[] dijk(int V, int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();

		int[] dist = new int[V + 1]; // 0 : dummy
		Arrays.fill(dist, INF);
		dist[start] = 0;
		pq.add(new Edge(start, 0));

		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			int currIdx = edge.to;

			if (edge.weight > dist[currIdx]) continue;

			for (Edge next : adjList[currIdx]) {
				if (dist[next.to] > dist[currIdx] + next.weight) {
					dist[next.to] = dist[currIdx] + next.weight;
					pq.add(next);
				}
			}
		}
		return dist;
	}


	static class Edge implements Comparable<Edge> {

		int to, weight;


		public Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}


		@Override
		public int compareTo(Edge e) {
			return this.weight - e.weight;
		}

	}

}
