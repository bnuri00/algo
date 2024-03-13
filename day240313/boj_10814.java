package day240313;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class boj_10814 {
static class Person{
	int age, order;
	String name;
	Person(int order, int age, String name){
		this.age = age;
		this.order = order;
		this.name = name;
	}

	public String toString(){
		return this.age + " " + this.name;
	}
}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st ;
		List<Person> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Person(i, Integer.parseInt(st.nextToken()), st.nextToken()));
		}

		list.sort((o1, o2) ->
			o1.age != o2.age ?
				o1.age - o2.age : o1.order - o2.order
		);

		list.forEach(System.out::println);

	}
}
