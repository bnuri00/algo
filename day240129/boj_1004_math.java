package day240129;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class boj_1004_math {

	private static final List<Circle> circleList = new ArrayList<>();


	private static long getAllCircleIndex(int x, int y) {
		long result = 0;
		for (int i = 0; i < circleList.size(); i++) {
			Circle c = circleList.get(i);
			if (c.r * c.r > (x - c.x) * (x - c.x) + (y - c.y) * (y - c.y)) {
				result |= 1L << i;
			}
		}
		return result;
	}


	private static int logic(int x1, int y1, int x2, int y2) {
		long resultIndexBit = getAllCircleIndex(x1, y1) ^ getAllCircleIndex(x2, y2);
		return Long.bitCount(resultIndexBit);
	}


	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			// init
			circleList.clear();

			// input
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			int n = Integer.parseInt(br.readLine());
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				int cx = Integer.parseInt(st.nextToken());
				int cy = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				circleList.add(new Circle(cx, cy, r));

			}

			sb.append(logic(x1, y1, x2, y2)).append('\n');
		}
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb);
	}


	static class Circle {

		int x, y, r;


		Circle(int x, int y, int r) {
			this.x = x;
			this.y = y;
			this.r = r;
		}

	}

}
