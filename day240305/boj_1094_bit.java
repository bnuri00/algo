package day240305;

import java.util.Scanner;


/*
 * 참고: 블로그
 *
 * <로직>
 *  - 막대기는 반으로 잘라서 막대기가 원하는 길이보다 길다면 반을 버린다
 *  - 같은 길이의 막대기 2개가 불가능, 모든 막대는 2의 제곱수임
 * -> 입력받은 숫자 1 비트카운트..
 *
 */
public class boj_1094_bit {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		System.out.println(Integer.bitCount(x));
	}
}
