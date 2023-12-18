package day231218;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
 * 18316 KB	160 ms
 *
 * 풀이시간: 2시간+
 * 참고: lcs 알고리즘 학습 자료
 *
 * <풀이>
 * - lcs1 + 실제 부분문자열 구하기
 *
 * - dp 배열로 lcs 구함
 * - lcs 길이 출력 (dp 배열 맨 끝, dp[inputStr1.length()][inputStr2.length()])
 * - 이까지는 백준 9251 lcs와 같음
 *
 * - lcs를 구한 dp 배열을 토대로 실제 lcs 출력
 * - 왼쪽, 위쪽이 현재 길이와 같은지 확인
 * - 같으면 이동
 * - 같지 않으면
 *    - dp 계산 과정 중 (어딘가) -> 현재 이동에서 문자열이 추가된 것임
 *    - 따라서 현재 문자가 lcs에 포함됨
 *    - 현재 문자를 저장 후 i-1, j-1로 이동 (다른 위치는 이미 확인 / 확인할 필요 없으므로 이 위치로 이동)
 *
 * <실수한 것>
 * - dp 코드 편의성을 위해 0 인덱스를 사용하지 않게 했는데 lcs 문자 구하는 부분에서
 *   inputStr1.charAt 의 인덱스 처리를 잘못하여(1을 안뺌) 디버깅에 시간이 걸림.
 *
 * <기타>
 * - lcs 몇번 더 풀어봐야 할 것 같다
 */
public class boj_9252 {

	public static int[][] dp;
	public static String inputStr1;
	public static String inputStr2;


	public static void setLcsDp() {
		for (int i = 1; i <= inputStr1.length(); i++) {
			for (int j = 1; j <= inputStr2.length(); j++) {
				if (inputStr1.charAt(i - 1) == inputStr2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}
	}


	public static String getLcs() {
		/*
		 * dp로 구한 lcs 를 문자로 반환
		 * dp 과정 반대로 조회함 (이것도 백트래킹이라던데 헷갈림;;)
		 */
		StringBuilder sb = new StringBuilder();
		int i = inputStr1.length();
		int j = inputStr2.length();

		while (dp[i][j] > 0) {
			if (dp[i][j] == dp[i - 1][j]) { // 왼쪽이 현재 위치와 문자열 길이 같은 경우 이동
				i--;
			} else if (dp[i][j] == dp[i][j - 1]) { // 위쪽이 현재 위치와 문자열 길이 같은 경우 이동
				j--;
			} else {    // 왼쪽, 위쪽 모두 같지 않은 경우 현재 위치의 문자가 lcs 에 포함된다. StringBuilder에 추가
				sb.append(inputStr1.charAt(i - 1));
				i--;
				j--;
			}
		}
		return sb.reverse().toString();
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		inputStr1 = br.readLine();
		inputStr2 = br.readLine();
		dp = new int[inputStr1.length() + 1][inputStr2.length() + 1];

		// lcs dp 배열 구하기
		setLcsDp();

		System.out.println(dp[inputStr1.length()][inputStr2.length()]); // dp로 구한 lcs 길이 출력
		if (dp[inputStr1.length()][inputStr2.length()] != 0) {
			// lcs 출력
			System.out.println(getLcs());
		}
	}

}
