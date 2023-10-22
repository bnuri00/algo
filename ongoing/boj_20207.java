package ongoing;

import java.io.*;
import java.util.*;

public class boj_20207 {
	static class Schedule{
		int startDate;
		int endDate;
		int length;

		public Schedule(int startDate, int endDate){
			this.startDate = startDate;
			this.endDate = endDate;
			this.length = endDate - startDate + 1;
		}

		@Override
		public String toString(){
			return "Schedule : " + startDate + " - " + endDate + " : " + length;
		}
	}

	public static int N;

	public static List<Schedule> scheduleList;

	public static int[][] calender;

	public static void main(String[] args) throws IOException{
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		scheduleList = new ArrayList<>();
		for(int i = 0; i < N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int startDate = Integer.parseInt(st.nextToken());
			int endDate = Integer.parseInt(st.nextToken());
			scheduleList.add(new Schedule(startDate, endDate));
		}

		// init calender
		calender = new int[N][365];


		// list -> sort by
		// 1. start date
		// 2. length
		Collections.sort(scheduleList,
			(o1, o2) -> o1.startDate == o2.startDate ? o1.length-o2.length : o1.startDate - o2.startDate);

		scheduleList.forEach(System.out::println);

		// 어카지??
		// 색칠하기...??!!
		// length : 365
		// 근데 이거 높이는 최악의 경우 1000개인데
		// 오 될지도
		// 메모리제한 512니까 ㄱㄱ


		// 1. 연속성 찾기 (가로 길이)
		// 2. 세로 길이!
		// 곱해서 결과에 더하기
	}
}
