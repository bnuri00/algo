package day240206;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
 * 풀이 시간: 3시간+
 * 참고: X
 *
 * <접근>
 *  - 각 자리에 수 하나를 고정하고 나머지 들어갈 수 있는 수의 개수를 찾아 고정한 수의 count 배열에 더해줌
 *      - 예를 들어 987에서 100의 자리에 9를 고정하면 0 ~ 87까지 (900 ~ 987) 수를 넣을 수 있으므로 count[9]에 88을 더해줌
 *      - 787의 10의 자리에 3을 고정하면 0~79, 8을 고정하면 0~77, 9를 고정하면 0~69를 넣을 수 있다.
 *  - 로직은 다음과 같음
 *      - 첫째 자리수와 나머지 자리수는 나눠서 계산함
 *      - 첫째 자리수
 *          - 주어진 페이지의 최댓값으로 고정 -> 해당 자리를 제외히고 합친 숫자 + 1를 더함
 *          - 최댓값보다 작은 숫자는 10^(length-1) 을 더함
 *      - 나머지 자리수
 *          - 주어진 페이지보다 작은 숫자 고정시 -> 자리수 앞의 숫자 * 10^(현재자리수)
 *          - 주어진 페이지와 같은 숫자 고정시 -> 해당 자리를 제외히고 합친 숫자 + 1를 더함
 *          - 주어진 페이지보다 큰 숫자 고정시 -> (자리수 앞의 숫자+1) * 10^(현재자리수)
 *
 * <기타>
 *  -
 *
 */
public class boj_1019 {

	private static int[] count = new int[10];


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		if (input.length() == 1) {
			for (int i = 1; i <= Integer.parseInt(input); i++) {
				count[i]++;
			}
		} else {
			// 맨앞자리 수 카운팅
			int fullCount = (int) Math.pow(10, input.length() - 1); // 최대로 카운팅될 때의 수 (ex. 3자리수이면 0~99 가능하므로 100개임)
			int firstNum = input.charAt(0) - '0';
			count[firstNum] += Integer.parseInt(input.substring(1)) + 1;
			for (int i = firstNum - 1; i > 0; i--) {
				count[i] += fullCount;
			}

			// 이후 수 카운팅
			for (int i = 1; i < input.length(); i++) {
				int currNum = input.charAt(i) - '0';

				StringBuilder sb = new StringBuilder(input);
				sb.deleteCharAt(i);
				int addCount = Integer.parseInt(sb.toString()) + 1;  //  currNum일 때 더해줄 숫자
				int underAddCount = (int) ((Integer.parseInt(input.substring(0, i)) + 1) * Math.pow(10, input.length() - i - 1));  // currNum보다 클 때 더해줄 숫자
				int overAddCount = (int) (Integer.parseInt(input.substring(0, i)) * Math.pow(10, input.length() - i - 1));  // currNum보다 작을 때 더해줄 숫자
				for (int j = 0; j < 10; j++) {
					if (j < currNum) {
						count[j] += underAddCount;
					} else if (j == currNum) {
						count[j] += addCount;
					} else {
						count[j] += overAddCount;
					}
				}
			}

			// 자리를 차지하지 않는 0 갯수 빼주기 (ex. 0010에서 1 앞의 0, 실제 페이지는 10이다)
			int zeroCount = (int) Math.pow(10, input.length() - 2);
			while (zeroCount > 0) {
				count[0] -= zeroCount;
				zeroCount /= 10;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int num : count) {
			sb.append(num).append(" ");
		}
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb);
	}

}
