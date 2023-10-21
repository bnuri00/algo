package day231021;


import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class boj_1450 {

	public static int N, C;


	// binarySearch
	// dfs
	public static void dfs(int idx, int sum, ArrayList<Integer> weight, ArrayList<Integer> answer) {
		// end condition
		if (sum > C) return;
		if (idx == weight.size()) {
			answer.add(sum);
			return;
		}

		// 물건 넣는 경우
		dfs(idx + 1, sum + weight.get(idx), weight, answer);

		// 물건 넣지 않는 경우
		dfs(idx + 1, sum, weight, answer);
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());   // 물건 크기
		C = Integer.parseInt(st.nextToken());   // 배낭 가용 무게

		ArrayList<Integer> weight1 = new ArrayList<>();
		ArrayList<Integer> weight2 = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			if (i < N / 2) {
				weight1.add(Integer.parseInt(st.nextToken()));
			} else {
				weight2.add(Integer.parseInt(st.nextToken()));
			}
		}

		ArrayList<Integer> sum1 = new ArrayList<>();
		ArrayList<Integer> sum2 = new ArrayList<>();

		dfs(0, 0, weight1, sum1);
		dfs(0, 0, weight2, sum2);

	}

}
