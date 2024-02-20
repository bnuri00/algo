package day240220;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class boj_1253 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> input = new ArrayList<>(N);
		Map<Integer, Integer> inputCountMap = new HashMap<>();
		for (int i = 0; i < N; i++) {
			int inputNum = Integer.parseInt(st.nextToken());
			input.add(inputNum);
			inputCountMap.put(inputNum, inputCountMap.getOrDefault(inputNum, 0) + 1);

		}

		Set<Integer> sumSet = new HashSet<>(N / 2);

		// 0 제거 후 따로 처리
		Integer zeroCount = inputCountMap.remove(0);
		if (zeroCount != null && zeroCount >= 3) {
			sumSet.add(0);
		}

		// 같은 수 2개 이상일 경우 set에 *2 한 수 추가
		for (Map.Entry<Integer, Integer> entry : inputCountMap.entrySet()) {
			if (entry.getValue() >= 2) {
				sumSet.add(entry.getKey() * 2);
			}
		}

		// 서로 다른 수의 합 set에 더하기
		List<Integer> distinctInput = input.stream().distinct().collect(Collectors.toList());
		if (distinctInput.size() >= 2) {
			Collections.sort(distinctInput);
			for (int j = 1; j < distinctInput.size(); j++) {
				for (int i = 0; i < j; i++) {
					int a = distinctInput.get(i);
					int b = distinctInput.get(j);
					if (a == 0 && inputCountMap.get(b) == 1) {
						// do nothing
					} else if (b == 0 && inputCountMap.get(a) == 1) {
						// do nothing
					} else {
						sumSet.add(distinctInput.get(i) + distinctInput.get(j));
					}
				}
			}
		}

		int count = 0;
		for (int num : input) {
			if (sumSet.contains(num)) {
				count++;
			}
		}
		System.out.println(count);
	}

}
