package day240305;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class boj_1094 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();

		int sum = 64;

		List<Integer> list = new ArrayList<>();
		list.add(sum);

		while(sum > x){
			Collections.sort(list);
			int tmp = list.remove(0) / 2;
			list.add(tmp);

			if(sum-tmp == x){
				break;
			} else if(sum - tmp < x){
				list.add(tmp);
			} else{
				sum -= tmp;
			}
		}
		System.out.println(list.size());

	}
}
