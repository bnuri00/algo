package day231010;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class boj_2525 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String[] split = line.split(" ");
		int currHour = Integer.parseInt(split[0]);
		int currMin = Integer.parseInt(split[1]);
		int cookMin = Integer.parseInt(br.readLine());

		currMin = currMin + cookMin;
		if (currMin > 59) {
			currHour += currMin / 60;
			currMin %= 60;
		}
		if (currHour > 23) {
			currHour -= 24;
		}

		System.out.print(currHour + " " + currMin);
	}

}
