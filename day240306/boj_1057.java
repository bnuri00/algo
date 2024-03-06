package day240306;


import java.util.Scanner;


public class boj_1057 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();

		int round = 0;
		while (a != b) {
			a = (a + 1) / 2;
			b = (b + 1) / 2;
			round++;
		}
		System.out.println(round);
	}

}
