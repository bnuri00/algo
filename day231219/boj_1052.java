package day231219;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;


/*
 * 14492 KB	144 ms (128 MB 2초)
 *
 * 풀이시간: 1시간+
 * 참고: x
 *
 * <풀이>
 *
 * - A를 정렬한 배열 B를 구함
 *
 * - 주어진 식을 사용하여 배열 P를 구함
 *   - (만약 배열 A에 같은 숫자가 존재한다면) 앞에서부터 P에 넣어야 사전순으로 앞선 배열을 만들 수 있음
 *   - 사용한 B 배열 체크하기
 *
 * - B[P[i]] = A[i] 식으로 P 배열을 구할 때
 *   - 전체 조회 O(N^2)
 *   - 이분탐색 O(logN)
 *   - 두가지를 사용할 수 있으나 N이 1000으로 충분히 작고 + 중복으로 인해 이분탐색 까다로움
 *
 *
 * <실수한 것>
 * - 식보고 멍때림
 * - 인덱스를 찾는 함수에서 인덱스 말고 값을 리턴함 ;;
 *
 * <기타>
 * - 인덱스 어렵다 :s
 */
public class boj_1052 {

	private static int findIndexByValue(List<Integer> B, int value) {
		for (int i = 0; i < B.size(); i++) {
			if (B.get(i) == value) {
				B.set(i, -1);
				return i;
			}
		}

		return -1;
	}


	public static void main(String[] args) throws IOException {
		// 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String inputStr = br.readLine();

		StringTokenizer st = new StringTokenizer(inputStr);
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		// B 배열 구하기 (A 배열 정렬)
		List<Integer> B = Arrays.stream(A).boxed().sorted().collect(Collectors.toList());

		// P 배열 구하기
		int[] P = new int[N];

		for (int i = 0; i < N; i++) {
			// B[P[i]] = A[i] 인 P[i] 찾기
			P[i] = findIndexByValue(B, A[i]);
		}

		StringBuilder sb = new StringBuilder();
		Arrays.stream(P).forEach(o -> sb.append(o).append(' '));
		System.out.println(sb);

	}

}
