package day231228;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
 * 문자열 3개
 * 3차원 배열 dp
 * ㅇㅇㅇ...
 *
 * 풀이시간: 3시간+
 * 시간복잡도: n^3
 *
 * <풀이>
 * - 3차원 dp
 *
 * <기타>
 * - 2개씩 각각 lcs를 구한 후, 그 중 길이가 최소인 lcs 문자열을 찾아 lcs를 한번 더 하는 방식을 생각했음
 *   - 최소 lcs 문자열이 여러개일 때 복잡도가 늘어나서 패스~~
 */
public class boj_1958 {

	public static int[][][] dp;


	public static int setDp3Word(String input1, String input2, String input3) {
		for (int i = 1; i <= input1.length(); i++) {
			for (int j = 1; j <= input2.length(); j++) {
				for (int k = 1; k <= input3.length(); k++) {
					if (input1.charAt(i - 1) == input2.charAt(j - 1) && input1.charAt(i - 1) == input3.charAt(k - 1)) {
						// 다 같으면 현재 문자위치 제외한 dp값에 +1
						dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
					} else {
						// 이전에 구한 값 중 max 찾아서 dp에 기록함
						dp[i][j][k] = Math.max(dp[i - 1][j][k], Math.max(dp[i][j - 1][k], dp[i][j][k - 1]));
					}
				}
			}
		}
		return dp[input1.length()][input2.length()][input3.length()];
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input1 = br.readLine();
		String input2 = br.readLine();
		String input3 = br.readLine();

		// 없는 문자열과 문자열의 lcs는 0임
		// 따라서 인덱스 0번은 0으로 세팅
		dp = new int[input1.length() + 1][input2.length() + 1][input3.length() + 1];
		System.out.println(setDp3Word(input1, input2, input3));
	}

}
