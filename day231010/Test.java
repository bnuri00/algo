package day231010;


public class Test {

	public static void main(String[] args) {
		//		int sum = 0;
		//		for (int i = 0; i < 10; i++) {
		//			sum++;
		//		}
		//		System.out.println(sum);

		Test t = new Test();
		t.f1(10);
	}


	void f1(int test) {
		if (test < 1) return;

		System.out.println(test);
		f1(test - 1);
	}

}
