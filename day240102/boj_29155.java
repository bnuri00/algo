package day240102;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


/*
 * 풀이시간: 1시간+
 *
 * <풀이>
 *   - 정렬, 그리디
 *   - 제약사항들로 인해 예외케이스 없음
 *   - 문제 조건이 작아서 정렬하는 대신 PriorityQueue를 써도 상관없었음
 *
 * <실수한 것>
 *   - logic에서 휴식시간 계산 if문을 if (j < problemCountArr[i] - 1) 이렇게 했었는데 마지막 휴식시간을 넣지 않으려는 의도였으나 잘못생각했다
 *   - 이전 - 현재 의 휴식사간이기 때문에 넣어야한다
 * <기타>
 *   - List로 받아서 정렬하는 것이 나을듯?
 */
public class boj_29155 {

	private static int[] problemCountArr;
	private static Queue<Integer>[] problemQ;


	private static int logic() {
		int totalTime = 0;
		int prevProblemTime = -1;

		for (int i = 1; i <= 5; i++) {

			for (int j = 0; j < problemCountArr[i]; j++) {  // 시간이 조금 필요한 문제부터 풀기
				int currProblemTime = problemQ[i].poll();
				totalTime += currProblemTime;

				if (j > 0) {    // 현재 난이도 첫문제가 아닌 경우 휴식시간
					totalTime += currProblemTime - prevProblemTime;
				}
				prevProblemTime = currProblemTime;

			}
			totalTime += 60;    // 난이도 증가시 휴식 60분

		}
		return totalTime - 60;  // 마지막에 더해진 60분 빼기
	}


	public static void main(String[] args) throws IOException {
		problemQ = new PriorityQueue[6];    // 0 : dummy
		for (int i = 1; i <= 5; i++) {
			problemQ[i] = new PriorityQueue<>();
		}
		problemCountArr = new int[6];    // 0 : dummy

		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= 5; i++) {
			problemCountArr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int level = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			problemQ[level].add(time);
		}

		// print
		System.out.println(logic());

	}

}
