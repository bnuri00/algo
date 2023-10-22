package day231021;


import java.io.*;
import java.util.*;


public class boj_1074 {

	public static int logic(int N, int r, int c){
		// end condition
		// when N == 1, Z shape
		if(N == 1){
			if(r == 0){
				if(c == 0) return 0;
				else if (c==1) return 1;
			} else{
				if(c == 0) return 2;
				else if(c==1) return 3;
			}
		}

		// basic logic
		int half = (int) Math.pow(2, N-1);
		if(r >= half && c >= half){ // 4사분면
			return logic(N-1, r-half, c-half) + half*half*3;
		} else if(r >= half){   // 3사분면
			return logic(N-1, r-half, c)+ half*half*2;
		} else if(c >= half){   // 2사분면
			return logic(N-1, r, c-half) + half*half;
		}

		// 1사분면
		return logic(N-1, r, c);
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());   // 제곱수
		int r = Integer.parseInt(st.nextToken());   // 행
		int c = Integer.parseInt(st.nextToken());   // 열

		System.out.print(logic(N, r, c));

	}
}
