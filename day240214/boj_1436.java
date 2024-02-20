package day240214;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class boj_1436 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int movie = 0;
		if (N <= 6) {
			movie = (N - 1) * 1000 + 666;
		} else {
			N -= 6;
			movie = 5666;
			while (N > 0) {
				movie++;
				if (String.valueOf(movie).contains("666")) N--;
			}
		}
		System.out.println(movie);
	}

}
