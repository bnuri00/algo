package day231010;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 풀다말앗음

public class boj_1260 {

	public static int N, M, V;
	public static StringBuilder sb;
	public static List<Integer>[] adjList;
	public static boolean[] visit;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]); // total vertex number
		M = Integer.parseInt(input[1]); // total edge number
		V = Integer.parseInt(input[2]); // start vertex number
		visit = new boolean[N + 1];   // 0 : dummy

		// init adjacent List
		adjList = new ArrayList[N + 1];   // 0 : dummy
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 1; i <= M; i++) {
			String[] inputLine = br.readLine().split(" ");
			int v1 = Integer.parseInt(inputLine[0]);
			int v2 = Integer.parseInt(inputLine[1]);
			adjList[v1].add(v2);
			adjList[v2].add(v1);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(adjList[i]);
		}
		dfs(V);
		sb.deleteCharAt(sb.length() - 1);
		sb.append('\n');
		bfs(V);
		sb.deleteCharAt(sb.length() - 1);
		System.out.print(sb);
	}


	public static void bfs(int start) {
		boolean[] visit = new boolean[N + 1];
		Queue<Integer> deque = new ArrayDeque<>();
		deque.add(start);
		sb.append(start).append(' ');
		visit[start] = true;

		while (!deque.isEmpty()) {
			int curr = deque.poll();
			for (int v : adjList[curr]) {
				if (!visit[v]) {
					visit[v] = true;
					sb.append(v).append(' ');
					deque.add(v);
				}
			}
		}

	}


	public static void dfs(int currPoint) {
		sb.append(currPoint).append(' ');
		visit[currPoint] = true;

		for (int v : adjList[currPoint]) {
			if (!visit[v]) {
				dfs(v);
			}
		}
	}

}
