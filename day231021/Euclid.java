package day231021;


public class Euclid {

	public static int logic2(int a, int b) {
		if (b == 0) return a;
		return logic(b, a % b);
	}


	public static void main(String[] args) {
		System.out.println(logic(6, 4));
		System.out.println(logic2(6, 4));
	}


	public static int logic(int a, int b) {
		while (a % b != 0) {
			int c = b;
			b = a % b;
			a = c;
		}
		return b;
	}

}
