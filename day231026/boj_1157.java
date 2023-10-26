package day231026;


import java.io.*;


public class boj_1157 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] inputCharArr = br.readLine().toUpperCase().toCharArray();

		//		System.out.println((int) 'a');  // 97
		//		System.out.println((int) 'A');  // 65

		int[] countArr = new int[26];
		for (char c : inputCharArr) {
			countArr[c - 'A']++;
		}

		boolean isDuplicateMaxCount = false;
		int maxNum = 0;
		int idx = -1;
		for (int i = 0; i < 26; i++) {
			if (maxNum < countArr[i]) {
				idx = i;
				maxNum = countArr[i];
				isDuplicateMaxCount = false;
			} else if (maxNum == countArr[i]) {
				isDuplicateMaxCount = true;
			}
		}

		if (isDuplicateMaxCount) System.out.println('?');
		else System.out.println((char) (idx + 'A'));

	}

}
