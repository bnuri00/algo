package day240304;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class boj_11651 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		List<Point> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		list.sort((o1, o2) -> o1.y == o2.y ? o1.x - o2.x : o1.y - o2.y);
		list.forEach(System.out::println);
	}


	static class Point {

		int x, y;


		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}


		public String toString() {
			return x + " " + y;
		}

	}

}
