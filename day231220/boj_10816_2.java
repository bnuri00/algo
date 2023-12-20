package day231220;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


/*
 * 메모리는 좀 줄었는데 시간이 늘엇음~~
 *
 * 178320 KB	1352 ms (256 MB 1초)
 * 참고: x
 *
 * <풀이>
 * - 배열 대신 hashmap 사용
 *
 */
public class boj_10816_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> hmap = new HashMap<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			int cardNum = Integer.parseInt(st.nextToken());
			hmap.put(cardNum, hmap.getOrDefault(cardNum, 0) + 1);
		}

		br.readLine();  // M 값 입력받아 사용하지 않음

		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (st.hasMoreTokens()) {
			int cardNum = Integer.parseInt(st.nextToken());
			sb.append(hmap.getOrDefault(cardNum, 0)).append(' ');
		}
		sb.deleteCharAt(sb.length() - 1);

		System.out.print(sb);
	}

}
