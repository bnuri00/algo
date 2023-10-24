package day231024;


public class pg_42862 {

	public static int solution(int n, int[] lost, int[] reserve) {
		int[] student = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			student[i] = 1;
		}
		for (int idx : lost) {
			student[idx]--;
		}
		for (int idx : reserve) {
			student[idx]++;
		}

		int answer = 0;
		for (int i = 1; i <= n; i++) {
			if (student[i] == 0) {
				if (i != 1 && student[i - 1] == 2) {
					student[i - 1]--;
					student[i]++;
				} else if (i != n && student[i + 1] == 2) {
					student[i + 1]--;
					student[i]++;
				}
			}
		}
		for (int a : student) {
			answer += a >= 1 ? 1 : 0;
		}

		return answer;
	}


	public static void main(String[] args) {
		int n = 5;
		int[] lost = { 2, 4 };
		int[] reserve = { 3 };
		System.out.println(solution(n, lost, reserve));
	}

}
