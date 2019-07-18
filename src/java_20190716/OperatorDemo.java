package java_20190716;

// ctl + shift + f => 자동으로 줄맞춤
public class OperatorDemo {
	public static void main(String[] args) {
		int a = 10, b = 22;
		int c = 0;
		double d = 0;

		System.out.println(c);

		c = a - b;
		System.out.println(c);

		c = a * b;
		System.out.println(c);

		d = (double) b / (double) a;
		System.out.println(d);

		c = b % a;
		System.out.println(c);

		a += b;
		System.out.println(a);

		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			sum += i;
		}

		System.out.println(sum);

		++a;
		++b;

		System.out.println(a + " " + b);

		a = 10;
		b = 20;
		boolean isSuccess = false;

		isSuccess = a > b;
		System.out.println(isSuccess);

		isSuccess = a < b;
		System.out.println(isSuccess);

		isSuccess = a >= b;
		System.out.println(isSuccess);

		isSuccess = a <= b;
		System.out.println(isSuccess);

		isSuccess = a == b;
		System.out.println(isSuccess);

		isSuccess = a != b;
		System.out.println(isSuccess);

		// && 앞 수식이 false이면 short circuit 발생으로 뒤 수식 연산 X
		// || 앞 수식이 true이면 short circuit 발생으로 뒤 수식 연산 X
		isSuccess = (a == b) && (a++ == b++);
		System.out.println(isSuccess);
		System.out.println(a);
		System.out.println(b);

		System.out.println(1 + 2 + 3 + "4" + (5 + 6));
	}
}
