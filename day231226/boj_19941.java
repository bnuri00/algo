package day231226;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class boj_19941 {

	public static void main(String[] args) throws IOException {
		int result = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		char[] inputArr = br.readLine().toCharArray();
		for (int i = 0; i < N; i++) {
			if (inputArr[i] == 'P') {
				int startIndex = Math.max(i - K, 0);
				int endIndex = Math.min(i + K, N - 1);
				for (int j = startIndex; j <= endIndex; j++) {
					if (inputArr[j] == 'H') {
						inputArr[j] = 'x';
						result++;
						break;
					}
				}
			}
		}
		System.out.println(result);
	}

}
