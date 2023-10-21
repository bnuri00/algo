package day231010;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


public class boj_2606 {

	public static int N, M; // N: 컴퓨터 수, M: 간선수
	public static int virusCount = 0;
	public static List<Integer>[] adjList;


	public static void bfs(int startVertex) {
		boolean[] visit = new boolean[N + 1]; // 0 : dummy
		Queue<Integer> queue = new ArrayDeque<>();

		visit[startVertex] = true;
		queue.add(startVertex);

		while (!queue.isEmpty()) {
			int currVertex = queue.poll();
			for (int v : adjList[currVertex]) {
				if (!visit[v]) {
					virusCount++;
					visit[v] = true;
					queue.add(v);
				}
			}
		}
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		// 인접리스트 초기화
		adjList = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			String[] input = br.readLine().split(" ");
			int v1 = Integer.parseInt(input[0]);
			int v2 = Integer.parseInt(input[1]);
			adjList[v1].add(v2);
			adjList[v2].add(v1);
		}

		bfs(1);
		System.out.print(virusCount);
	}

}
