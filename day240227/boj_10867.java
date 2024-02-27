package day240227;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class boj_10867 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Set<Integer> set = new TreeSet<>();
		while(st.hasMoreTokens()){
			set.add(Integer.parseInt(st.nextToken()));
		}
		set.forEach(i -> System.out.print(i + " "));

	}
}
