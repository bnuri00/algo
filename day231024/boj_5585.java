package day231024;


import java.io.*;


public class boj_5585 {

	public static final int[] money = { 500, 100, 50, 10, 5, 1 };


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int pay = Integer.parseInt(br.readLine());
		int remain = 1000 - pay;

		int result = 0;
		for (int i = 0; i < money.length - 1; i++) {
			result += remain / money[i];
			remain -= money[i] * (remain / money[i]);
			if (remain == 0) break;
		}

		result += remain;
		System.out.println(result);

	}

}
