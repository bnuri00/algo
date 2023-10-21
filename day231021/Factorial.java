package day231021;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Factorial {

	public static int factorial(int n) {
		if (n == 1) return 1;
		if (n == 2) return 2;
		
		return factorial(n - 1) * n;
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(factorial(n));
	}

}
