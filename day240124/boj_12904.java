package day240124;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
 * 풀이 시간: 25분
 * 참고: X
 *
 * <접근>
 *  - S 문자열로 T를 만들 수 있는지 알려면
 *  - S의 길이 == T의 길이가 될 때까지 역산한 후 문자열 비교
 *  - 문제 조건으로 인해 예외 케이스는 없다
 *
 * <다른 방법>
 *  -
 *
 * <실수한 것>
 *  -
 *
 * <기타>
 *  -
 *
 */
public class boj_12904 {

	private static boolean logic(String s, String t) {
		StringBuilder sb = new StringBuilder(t);
		while (s.length() != sb.length()) {
			char lastChar = sb.charAt(sb.length() - 1);
			sb.deleteCharAt(sb.length() - 1);
			if (lastChar == 'B') {
				sb.reverse();
			}
		}
		return s.equals(sb.toString());
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String t = br.readLine();

		System.out.println(logic(s, t) ? 1 : 0);

	}

}
