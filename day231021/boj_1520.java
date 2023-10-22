package day231021;


import java.io.*;
import java.util.*;

/*
TODO: 다시 풀어보기
 * */

public class boj_1520 {

	public static int M, N; // 세로, 가로
	public static int[][] map;
	public static int[][] memoi;

	public static int[] dy = {-1, 1, 0, 0};
	public static int[] dx = {0, 0, -1, 1};

	/**
	 * dfs 수행
	 * */
	 public static int dfs(int y, int x){
		if(y == M - 1 && x == N - 1){
			return 1;
		} else if(memoi[y][x] != -1){
			return memoi[y][x];
		}

		memoi[y][x] = 0;
		for(int d = 0; d < 4; d++){
			int ny = y + dy[d];
			int nx = x + dx[d];

			if(ny < 0 || ny >= M || nx < 0 || nx >= N || map[ny][nx] >= map[y][x]){
				continue;
			}

			memoi[y][x] += dfs(ny, nx);
		}

		return memoi[y][x];
	 }

	public static void main(String[] args) throws IOException {

		 // input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		// input map
		map = new int[M][N];
		memoi = new int[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				memoi[i][j] = -1;
			}
		}

		System.out.print(dfs(0, 0));
	}
}
