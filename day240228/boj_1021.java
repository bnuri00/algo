package day240228;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


/*
 * 풀이 시간: 30분+
 * 참고: X
 *
 * <접근>
 *  - 연산 횟수가 작은 쪽을 연산으로 선택
 *  - 뽑아낸 수의 인덱스를 처음 인덱스로 사용해서 이후 계산
 *
 * <다른 방법>
 *  - deque로 그냥 구현하는 것이 더 빠르다..
 *
 */
public class boj_1021 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		List<Integer> list = new ArrayList<>(N);
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}

		int result = 0;
		int beforeIndex = 0;
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			int index = list.indexOf(num);

			int diff = Math.abs(beforeIndex - index);
			int reverseDiff = list.size() - diff;
			result += Math.min(diff, reverseDiff);

			list.remove(index);
			beforeIndex = list.size() > index ? index : 0;
		}

		System.out.println(result);

	}

}
