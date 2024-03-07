package day240307;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class boj_11650 {

	static class Point{
		int x, y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
		public String toString(){
			return x + " " + y;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		List<Point> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			list.add(new Point(x, y));
		}

		list.sort((o1, o2) -> o1.x != o2.x ? o1.x - o2.x : o1.y - o2.y);
		list.forEach(System.out::println);
	}
}
