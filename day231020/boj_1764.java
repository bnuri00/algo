package day231020;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class boj_1764 {

	public static int N, M;
	public static HashSet<String> noListenPersonSet;
	public static HashSet<String> noSeePersonSet;


	public static List<String> logic() {
		List<String> resultList = new ArrayList<>();
		noListenPersonSet.stream().forEach(o -> {
			if (noSeePersonSet.remove(o)) {
				resultList.add(o);
			}
		});
		return resultList;
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		noListenPersonSet = new HashSet<>();
		noSeePersonSet = new HashSet<>();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			noListenPersonSet.add(br.readLine());
		}
		for (int i = 0; i < M; i++) {
			noSeePersonSet.add(br.readLine());
		}

		List<String> list = logic();
		Collections.sort(list);
		System.out.println(list.size());
		StringBuilder sb = new StringBuilder();
		for (String str : list) {
			sb.append(str).append("\n");
		}
		System.out.print(sb);
	}

}
