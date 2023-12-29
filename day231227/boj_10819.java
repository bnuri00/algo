package day231227;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class boj_10819 {

	public static int N, maxDiff;
	public static int[] inputArr;


	static void perm(boolean[] used, int[] permIdxArr, int currIdx) {
		if (currIdx >= N) {
			int diff = 0;
			for (int i = 0; i < N - 1; i++) {
				diff += Math.abs(inputArr[permIdxArr[i]] - inputArr[permIdxArr[i + 1]]);
			}
			maxDiff = Math.max(diff, maxDiff);
		}
		for (int i = 0; i < N; i++) {
			if (!used[i]) {
				used[i] = true;
				permIdxArr[currIdx] = i;
				perm(used, permIdxArr, currIdx + 1);

				used[i] = false;
			}
		}
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		inputArr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			inputArr[i] = Integer.parseInt(st.nextToken());
		}

		perm(new boolean[N], new int[N], 0);
		System.out.println(maxDiff);
	}

}
