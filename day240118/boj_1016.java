package day240118;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


/*
 * 풀이 시간: 40분+
 * 참고: Math.floorDiv, Math.ceilDiv 자료, Math 클래스
 *
 * <접근>
 *  - min <= n <= max 에서 제곱수의 배수를 찾는다
 *      - 루프:
 *          2 ~ (루트 max) -> 제곱수 만들기
 *      - 루프의 내부 루프:
 *          min / (제곱수) 의 올림 ~ max / (제곱수) 의 내림
 *
 *  - 답 -> max - min + 1 - (제곱수 배수의 개수)
 *
 * <다른 방법>
 *  - 범위가 작으므로 (최대 1,000,000) set 대신 boolean 배열 사용, 인덱스 활용하기
 *      -> 중복제거 연산X,  시간 줄일 수 있음
 *
 * <실수한 것>
 *  - 부등호 실수 ( num 루프에서 <= 로 해야할 것을 < 로 함)
 *
 * <기타>
 *  - for(long num=2; num*num <= max ;num++)
 *      - 가독성이 좋지만 연산 추가로 필요
 *      - 생각해보기? 염두에 두기
 */
public class boj_1016 {

	public static void main(String[] args) throws IOException {
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long min = Long.parseLong(st.nextToken());
		long max = Long.parseLong(st.nextToken());

		// logic
		Set<Long> excludeNumberSet = new HashSet<>();    // 제곱ㄴㄴ수가 아닌 수  저장
		for (int num = 2; num <= Math.sqrt(max); num++) {
			long sqrtNum = (long) num * num;
			long start = min / sqrtNum + (min % sqrtNum == 0 ? 0 : 1);   // min / (제곱수) 의 올림, Math.ceilDiv 없어서 직접 올림 계산
			long end = Math.floorDiv(max, sqrtNum);     //  max / (제곱수) 의 내림

			for (long j = start; j <= end; j++) {
				excludeNumberSet.add(sqrtNum * j);
			}
		}

		// print
		System.out.println(max - min + 1 - excludeNumberSet.size());
	}

}
