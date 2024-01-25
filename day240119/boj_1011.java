package day240119;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
 * 풀이 시간: 2시간
 * 참고: 다른사람 풀이
 *
 * <접근>
 * try 1
 *  - bfs
 *
 * try 2
 * - y - x 에 따라 이동 횟수 최솟값이 정해짐, 차이값 diff로 계산한다
 * - 규칙찾기, 함수 구현
 * - 규칙 요약:
 *      - 1부터 시작
 *      - 1. 제곱수 지난 후
 *      - 2. 제곱수 사이 중간 값을 지날때 증가
 *      =>  자기보다 작거나 같은 가장 큰 제곱수를 찾아서 범위 확인, 규칙에 따라 계산한다 (제곱수, ~제곱수 중간값, ~다음 제곱수-1)
 *
 * - 실제 접근:
 *      - n은 제곱했을 때
 *          1. 자신(diff)보다 작은
 *          2.가장 가까운 수
 *
 *      - [기준 1] : n*n        ex) 1 2 3 2 1 , ... (가운데 수 기준 대칭, 1씩 상승하다가 1씩 감소, 양끝은 1)
 *          - n*n = n(n+1)/2 + (n-1)n/2
 *          - 이동 횟수 : 2n - 1
 *
 *      - [기준 2] : n(n+1)     ex) 1 2 3 3 2 1 , ... (등차수열, 대칭)
 *          - n*n에 1 ~ n 사이의 숫자를 더한 거리      => n*n +1 에서 n*n + n 까지~~
 *              - ex) n=3에서 수열 1 2 3 2 1 1 (합 10), 1 2 3 2 2 1 (합 11)
 *          - 조건: n*n < diff <= n(n+1)
 *          - 이동 횟수 : 2n
 *
 *      - other :
 *          - n(n+1) 에 1 ~ n 사이의 숫자를 더한 거리  => n(n+1) +1 에서 n(n+1) + n 까지~~
 *          - 조건: diff > n(n+1)
 *              - ex) n=3에서 수열 1 2 3 3 2 1 1 (합 13), 1 2 3 3 3 2 1 (합 15)
 *              - 위 예시와 같이 기준 2의 수열에서 n 이하 숫자 하나가 추가되는 경우
 *          - 이동 횟수 : 2n+1
 *          - 참고:  n(n+1) + (n+1) 일 경우 (n+1) ^2, n+1의 [기준 1] 수열임
 *
 *      => logic 구현
 *
 *
 * <다른 방법>
 *  -
 *
 * <실수한 것>
 *  - 대충 풀엇음 -> 잘못된 접근, 메모리초과
 *
 * <기타>
 *  - 코테에 나왔으면 걍 망햇음
 *  - 문제 파악 잘하기...
 *
 */
public class boj_1011 {

	private static int logic(int x, int y) {
		int diff = y - x;    // 1 ~ (2^31-1)
		int n = (int) Math.sqrt(diff);  // n : 제곱했을 때  1. 자신보다 작은 2.가장 가까운 수

		if (diff == n * n) {
			return 2 * n - 1;
		} else if (diff <= n * (n + 1)) {
			return 2 * n;
		} else {
			return 2 * n + 1;
		}
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			// input
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			sb.append(logic(x, y)).append('\n');
		}

		// print
		System.out.println(sb);
	}

}
