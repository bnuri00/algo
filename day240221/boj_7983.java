package day240221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 풀이 시간: 30분<
 * 참고: X
 *
 * <접근>
 *  - 마감일자 기준 정렬
 *  - 시작날짜를 1.이전 시작날짜+걸리는 날 과 2.마감날짜 + 걸리는 날 중 작은 것으로 설정
 *  - 모든 과제 다할때까지 반복~~
 *
 */
public class boj_7983 {
    private static class Report{
        int duration, t;
        Report(int duration, int t){
            this.duration = duration;
            this.t = t;
        }
    }
    public static void main(String[] args) throws IOException {
        List<Report> inputList = new ArrayList<>();

        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());    // need day
            int t = Integer.parseInt(st.nextToken());    // end day
            inputList.add(new Report(d, t));
        }

        int result = (int) Math.pow(10, 9);
        inputList.sort((o1, o2 )-> o2.t - o1.t);
        for(Report r : inputList){
            result = Math.min(result, r.t);
            result -= r.duration;
        }
        System.out.println(result);
    }
}
