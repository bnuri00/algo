package day231027;


import java.util.*;


/*
못풀엇음
* */
public class pg_92334 {

	public static void main(String[] args) {
		pg_92334 pg = new pg_92334();
		String[] id_list = { "muzi", "frodo", "apeach", "neo" };
		String[] report = { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" };
		int k = 2;
		int[] resultList = pg.solution(id_list, report, k);
		System.out.println(Arrays.toString(resultList));
	}


	public static int getIdIdx(String[] id_list, String id) {
		for (int i = 0; i < id_list.length; i++) {
			if (id.equals(id_list[i])) return i;
		}
		return -1;
	}


	public int[] solution(String[] id_list, String[] report, int k) {
		int idLen = id_list.length;
		int[] answer = new int[idLen];

		HashSet<String> hSet = new HashSet<>(List.of(report));
		HashMap<String, ArrayList<String>> hMap = new HashMap<>();

		for (String str : hSet) {
			String[] splitStr = str.split(" ");
			if (hMap.get(splitStr[1]) == null) {
				hMap.put(splitStr[1], new ArrayList<>(Arrays.asList(splitStr[0])));
			} else {
				hMap.get(splitStr[1]).add(splitStr[0]);
			}
		}

		hMap.forEach((key, list) -> {
			if (list.size() >= k) {
				for (String str : list) {
					answer[getIdIdx(id_list, str)]++;
				}
			}
		});

		return answer;
	}

	//	static class ReportLog{
	//		String targetId;
	//		int count;
	//
	//		ReportLog(String targetId, int count){
	//			this.targetId = targetId;
	//			this.count = count;
	//		}
	//
	//	}

}
