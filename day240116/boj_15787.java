package day240116;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class boj_15787 {

	private static int[] trainSeat;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		trainSeat = new int[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			int trainNo = Integer.parseInt(st.nextToken());
			int seatNo = -1;
			if (st.hasMoreTokens()) {
				seatNo = Integer.parseInt(st.nextToken());
			}
			// 입력
			doCommand(command, trainNo, seatNo);
		}

		boolean[] visit = new boolean[1 << 21];
		int count = 0;
		for (int i = 1; i < trainSeat.length; i++) {
			if (!visit[trainSeat[i]]) {
				count++;
				visit[trainSeat[i]] = true;
			}
		}
		System.out.println(count);
	}


	static void doCommand(int command, int trainNo, int seatNo) {
		switch (command) {
		case 1:
			trainSeat[trainNo] |= 1 << seatNo;
			break;
		case 2:
			trainSeat[trainNo] &= ~(1 << seatNo);
			break;
		case 3:
			trainSeat[trainNo] <<= 1;
			trainSeat[trainNo] &= ((1 << 21) - 1);
			break;
		case 4:
			trainSeat[trainNo] >>= 1;
			trainSeat[trainNo] &= ~1;
			break;
		default:
			// do nothing
			break;
		}
	}

}
