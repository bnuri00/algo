package day240130;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 최소경계 사각형으로 풀엇음
// 이게 더 복잡한가?
public class boj_2527 {

	private static char logic(int x1, int y1, int p1, int q1, int x2, int y2, int p2, int q2) {
		int w1 = p1 - x1;
		int h1 = q1 - y1;
		int w2 = p2 - x2;
		int h2 = q2 - y2;

		// minimum bounding rectangle
		int mbrW = Math.max(p1, p2) - Math.min(x1, x2);
		int mbrH = Math.max(q1, q2) - Math.min(y1, y2);

		if (mbrW > w1 + w2 || mbrH > h1 + h2) { // no overlap
			return 'd';
		} else if (mbrW == w1 + w2 && mbrH == h1 + h2) {  // point
			return 'c';
		} else if ((mbrW == w1 + w2 && mbrH < h1 + h2) || (mbrH == h1 + h2 && mbrW < w1 + w2)) { // line
			return 'b';
		} else {    // rectangle
			return 'a';
		}

	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int p1 = Integer.parseInt(st.nextToken());
			int q1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			int q2 = Integer.parseInt(st.nextToken());

			System.out.println(logic(x1, y1, p1, q1, x2, y2, p2, q2));

		}
	}

}
