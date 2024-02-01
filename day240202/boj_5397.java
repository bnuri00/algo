package day240202;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;


/*
 * 풀이 시간: 1시간 30분+
 * 참고: X
 *
 * <접근>
 *  - 단순 구현
 *  - ArrayList로 했다가 시간초과
 *  - LinkedList에서 cursor 조회의 n보다 삽입, 삭제시 작업이 시간이 더 오래 걸렸다
 *
 * <다른 방법>
 *  - LinkedList, ListIterator 같이 활용
 *
 * <실수한 것>
 *  -
 *
 * <기타>
 *  - LinkedList의 장점을 활용하려면 ListIterator를 써야 한다고..(Iterator를 잘 사용하지 않아 몰랐다)
 *
 */
public class boj_5397 {

	private static String logic(String input) {
		List<Character> result = new LinkedList<>();
		int cursorIndex = 0;
		for (Character c : input.toCharArray()) {
			if (c == '-') {
				if (cursorIndex > 0) {
					result.remove(cursorIndex - 1);
					cursorIndex--;
				}
			} else if (c == '<') {
				if (cursorIndex > 0) {
					cursorIndex--;
				}
			} else if (c == '>') {
				if (cursorIndex < result.size()) {
					cursorIndex++;
				}
			} else {
				if (cursorIndex == result.size()) {
					result.add(c);
				} else {
					result.add(cursorIndex, c);
				}
				cursorIndex++;
			}
		}

		StringBuilder sb = new StringBuilder(result.size());
		for (char c : result) {
			sb.append(c);
		}
		return sb.toString();
	}


	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String input = br.readLine();
			sb.append(logic(input)).append('\n');
		}
		System.out.print(sb);
	}

}
