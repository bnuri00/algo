package day240314;


import java.util.Scanner;


public class boj_9625 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int ACount = 0;
		int BCount = 1;
		for (int i = 1; i < N; i++) {
			int tmp = ACount;
			ACount = BCount;
			BCount += tmp;
		}
		System.out.println(ACount + " " + BCount);

	}
}
