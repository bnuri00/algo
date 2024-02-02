package day240202;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;


/*
 * 참고: ListIterator 공식 문서
 *
 * <접근>
 *  - 단순 구현
 *  - LinkedList, ListIterator (cursor로 사용)
 *
 * <다른 방법>
 *  - LinkedList, ListIterator 같이 활용
 *
 */
public class boj_5397_iter {

	private static String logic(String input) {
		List<Character> result = new LinkedList<>();
		ListIterator<Character> iterator = result.listIterator();

		for (Character c : input.toCharArray()) {
			if (c == '-') {
				if (iterator.hasPrevious()) {
					iterator.previous();
					iterator.remove();
				}
			} else if (c == '<') {
				if (iterator.hasPrevious()) {
					iterator.previous();
				}
			} else if (c == '>') {
				if (iterator.hasNext()) {
					iterator.next();
				}
			} else {
				iterator.add(c);
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
