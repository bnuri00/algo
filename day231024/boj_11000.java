package day231024;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


/**
 * todo: 풀기
 */
public class boj_11000 {

	public static void main(String[] args) throws Exception {
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Lesson> lessonList = new ArrayList<Lesson>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			lessonList.add(new Lesson(
				Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken())
			));
		}

		// logic
		Collections.sort(lessonList,
			(o1, o2) -> o1.start == o2.start ? o2.end - o1.end : o2.start - o1.start);

		List<Integer> room = new ArrayList<>();

	}


	static class Lesson {

		int start, end;


		Lesson(int start, int end) {
			this.start = start;
			this.end = end;
		}

	}

}
