package day240103;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
 * 풀이시간: 10분+
 *
 * <풀이>
 *    - A를 B로 바꾸는 대신 반대로 연산하여 B를 A로 바꾸기
 *    - 두가지 연산의 결과를 확실히 구분할 수 있으며 상호 배타적 -> 구한 해가 무조건 답이 된다
 *
 * <실수한 것>
 *    - 종료조건을 제대로 안걸어서 (A > B 의 경우) 무한루프
 */
public class boj_16953 {

	private static int logic(int A, int B, int count) {
		if (A > B) {
			return -1;
		}
		if (A == B) {
			return count + 1;
		}

		if (B % 10 == 1) {  // 1을 가장 오른쪽에 추가하는 연산
			return logic(A, B / 10, count + 1);
		}

		if (B % 2 == 0) {   // 2를 곱하는 연산
			return logic(A, B / 2, count + 1);
		}
		return -1;
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		System.out.println(logic(A, B, 0));

	}

}
