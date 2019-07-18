package java_20190715;

public class LiteralDemo {
	public static void main(String[] args) {
		// byte 범위를 넘어가먄 컴파일 에러발생(오버플로어)
		// byte a1 = 128;

		int a1 = 11; // 10진수
		int a2 = 011; // 8진수
		int a3 = 0x11; // 16진수

		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);

		long a4 = 2200000000L;

		System.out.println(a4);

		// float 리터럴은 소수점 뒤에 f,F로 표기함
		float f1 = 1234.56f;
		// double 리터럴은 소수점 뒤에 d,D로 표기하거나 생략
		double d1 = 1234.567d;

		System.out.println(f1);
		System.out.println(d1);

		// boolean 리터럴은 ture,false
		boolean isExisted = false;

		System.out.println(isExisted);

		a1 = 10;
		d1 = 10.0d;

		// primitive data type의 == 연산자는 값만 비교함.
		System.out.println(a1 == d1);

		// b2에 b1의 값이 10이 할당
		int b1 = 10;
		int b2 = b1;
		b2 = 20;

		System.out.println(b1);
		System.out.println(b2);

	}
}
