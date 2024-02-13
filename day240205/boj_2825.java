package day240205;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
 * 풀이 시간: 1시간
 * 참고: 정답코드
 *
 * <접근>
 *  - 비트마스킹으로 0~9 숫자 존재 표시
 *  - 각 집합의 개수 구함
 *  - 조합 개수 공식으로 정답 구하기
 *
 * <실수한 것>
 *  -
 *
 * <기타>
 *  - 문제 접근까지 하고 나서 조합 공식에서 머리가 안돌아가서 코드 봣다
 *  - 다시 풀어보기ㅠㅠ
 *
 */
public class boj_2825 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[1 << 10];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			int group = 0;
			for (int j = 0; j < input.length(); j++) {
				group |= 1 << input.charAt(j) - '0';
			}
			arr[group]++;
		}

		long result = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if ((i & j) != 0) {
					result += (long) arr[i] * arr[j];
				}
			}
			if (arr[i] > 1) {
				result += (long) arr[i] * (arr[i] - 1) / 2;
			}
		}
		System.out.println(result);

	}

}
