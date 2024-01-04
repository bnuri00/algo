package day240104;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/*
 * 풀이시간: 40분+
 * <풀이>
 *     - 단어의 알파벳 개수 카운터 2개
 *     - 구성을 확인하기 위해 비교할 문자 카운터에서 첫번째 문자 카운터를 각각 뺀다
 *
 *     - 비슷한 단어가 될 조건은 아래의 두가지가 있다.
 *     - 서로 다른 문자가 2개이며 각각 다른 단어에 있는 경우 (하나의 문자를 다른 문자로 바꾸는 경우)
 *          -> sum == 0 && remainCount == 2
 *     - 서로 다른 문자의 개수가 1개 이하인 경우 (한 문자를 더하거나 빼는 경우)
 *          -> remainCount <= 1
 */
public class boj_2607 {

	private static int[] firstWordCounter;
	private static int[] otherWordCounter;


	public static boolean checkSimilar(String word) {
		// init
		Arrays.fill(otherWordCounter, 0);
		for (int i = 0; i < word.length(); i++) {
			otherWordCounter[word.charAt(i) - 'A']++;
		}

		// logic
		int sum = 0;
		int remainCount = 0;
		for (int i = 0; i < 26; i++) {
			int tmp = otherWordCounter[i] - firstWordCounter[i];
			remainCount += Math.abs(tmp);   // 서로 다른 문자의 개수
			sum += tmp;
		}

		return (sum == 0 && remainCount == 2) || remainCount <= 1;
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		String firstWord = br.readLine();

		// set wordCounter
		otherWordCounter = new int[26];
		firstWordCounter = new int[26];
		for (int i = 0; i < firstWord.length(); i++) {
			firstWordCounter[firstWord.charAt(i) - 'A']++;
		}

		int count = 0;
		for (int i = 0; i < N - 1; i++) {
			// logic
			if (checkSimilar(br.readLine())) {
				count++;
			}
		}

		System.out.println(count);

	}

}
