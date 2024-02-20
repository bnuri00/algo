package day240216;


import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


/*
 * 풀이 시간: 30분
 * 참고: X
 *
 * <접근>
 *  - 반대편에 있는 면은 같이 보일 수 없음
 *  - 한 면만 보일때 최솟값, edge 최솟값, corner 최솟값 구하고 정육면체에서 나오는 횟수만큼 곱함
 *
 * <실수한 것>
 *  - N == 1 일때 예외처리를 안해줌
 *
 */
public class boj_1041 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dice = new int[6];
		for (int i = 0; i < 6; i++) {
			dice[i] = sc.nextInt();
		}

		long result = 0;
		if (N == 1) {
			result = Arrays.stream(dice).sum() - Arrays.stream(dice).max().getAsInt();

		} else {
			int min1 = Math.min(dice[0], dice[5]);
			int min2 = Math.min(dice[1], dice[4]);
			int min3 = Math.min(dice[2], dice[3]);

			int min = Arrays.stream(dice).min().getAsInt();
			int edgeMin = Math.min(Math.min(min1 + min2, min1 + min3), min2 + min3);
			int cornerMin = min1 + min2 + min3;

			result = min * ((long) (N - 2) * (N - 2) + 4L * (N - 2) * (N - 1)) + (long) edgeMin * 4 * (N + N - 3) + cornerMin * 4L;

		}
		System.out.println(result);
	}

}
