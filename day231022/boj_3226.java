package day231022;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class boj_3226 {

	public static int calcFee(int startHour, int startMinute, int callMinute){
		int result;

		int minuteSum = startMinute + callMinute;
		if(minuteSum > 60 && (startHour == 6||startHour==18)){
			if(startHour == 6){ // 5원 -> 10원 변경점
				result = (60-startMinute)*5 + (minuteSum - 60)*10;
			} else {   // 10원 -> 5원 변경점
				result = (60-startMinute)*10 + (minuteSum - 60)*5;
			}
		} else {
			if (startHour >= 7 && startHour < 19) {
				result = callMinute*10;
			} else{
				result = callMinute*5;
			}
		}

		return  result;
	}

	public static void main(String[] args) throws IOException {
		int fee = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int totalFee = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String startTime = st.nextToken();
			int time = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(startTime, ":");
			totalFee += calcFee(
				Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()),
				time
			);
		}
		System.out.println(totalFee);

	}
}
