package day240320;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class boj_2776 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			List<Integer> list = new ArrayList<>();

			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			Collections.sort(list);

			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				sb.append(binarySearch(list, Integer.parseInt(st.nextToken())) ? 1 : 0).append("\n");
			}
		}
		System.out.println(sb);
	}


	public static boolean binarySearch(List<Integer> list, int item) {
		int left = 0;
		int right = list.size() - 1;
		int result = -1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (list.get(mid) == item) {
				return true;
			} else if (list.get(mid) > item) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return false;
	}

}
