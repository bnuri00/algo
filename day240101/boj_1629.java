package day240101;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
 * 최대 2147483647번 곱함 -> 분할정복!!!
 *
 * 자료형 주의!!
 * - 반례 -> 2147483646 2147483647 2147483647
 */
public class boj_1629 {

	private static long pow(int num, int n, int divNum) {
		if (n == 1) {
			return (long) num % divNum;
		}

		long calcHalf = pow(num, n / 2, divNum) % divNum;
		if (n % 2 == 0) {
			return calcHalf * calcHalf % (long) divNum;
		} else {
			return ((calcHalf * calcHalf % divNum) * (num % divNum)) % divNum;
		}
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		System.out.println(pow(A, B, C));
	}

}
