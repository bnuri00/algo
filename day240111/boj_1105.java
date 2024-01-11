package day240111;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class boj_1105 {

	private static int logic(String origin, int R) {
		int count = 0;
		for (int i = 0; i < origin.length(); i++) {
			// 새 숫자 만들기 (8을 9로 바꿈)
			if (origin.charAt(i) == '8') {

				int num = 0;
				for (int j = 0; j < i; j++) {
					num = num * 10 + origin.charAt(j) - '0';
				}
				num = num * 10 + 9;
				for (int j = i + 1; j < origin.length(); j++) {
					num *= 10;
				}

				if (num <= R) { // 새로 만든 숫자가 R보다 작은 숫자이면 유효, 현재까지 count를 리턴
					return count;
				} else {    //
					count++;
				}
			}
		}
		return count;
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String input1 = st.nextToken();
		int R = Integer.parseInt(st.nextToken());

		System.out.println(logic(input1, R));

	}

}
