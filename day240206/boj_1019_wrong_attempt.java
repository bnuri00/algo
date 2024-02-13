package day240206;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class boj_1019_wrong_attempt {

	private static int[] count = new int[10];


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		for (int i = 0; i < input.length(); i++) {
			int endNum = input.charAt(i);

			StringBuilder sb = new StringBuilder(input);
			sb.deleteCharAt(i);
			int repeatCount = Integer.parseInt(sb.toString());
			for (int j = (i == 0 ? 1 : 0); j < endNum; j++) {   // 첫자리는 0이 될 수 없으므로 i가 0일때는 1부터 카운팅
				count[i] += repeatCount;

				if (j == 0) {
					count[i]--; // 0인경우 제외
				}
			}
		}

	}

}
