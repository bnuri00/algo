package day231220;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
 * 199568 KB	984 ms (256 MB 1초)
 * 풀이시간: 30분
 * 참고: x
 *
 * <풀이>
 * - -10,000,000 ~ 10,000,000 (20000001 배열) 각 카드 카운팅
 * - 음수때문에 10,000,000 더해서 사용
 *
 *
 * <실수한 것>
 * - OOM 날까봐 StringBuilder 안쓰고 각각 프린트하다가 시간초과남(ㅋㅋ)
 *
 * <기타>
 * - 간신히 통과함;;
 * - 다른 알고리즘 써서 시간, 메모리 사용 줄여보기
 */
public class boj_10816 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] hasCardArr = new int[10000000 * 2 + 1];  // -10,000,000 ~ 10,000,000

		StringTokenizer st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			int cardNum = Integer.parseInt(st.nextToken());
			hasCardArr[cardNum + 10000000]++;  // 음수 카드도 있으므로 10,000,000을 더해서 양수 인덱스로 만듦
		}

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (st.hasMoreTokens()) {
			int cardNum = Integer.parseInt(st.nextToken());
			sb.append(hasCardArr[cardNum + 10000000]).append(' ');
		}
		sb.deleteCharAt(sb.length() - 1);

		System.out.print(sb);
	}

}
