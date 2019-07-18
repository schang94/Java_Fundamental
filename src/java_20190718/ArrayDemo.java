package java_20190718;

public class ArrayDemo {
	public static void main(String[] args) {
		// int 배열 선언
		int[] a = new int[4];

		// 배열 할당
		a[0] = 100;
		a[1] = 200;
		a[2] = 300;
		a[3] = 400;

		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
			System.out.println(a[i]);
		}

		System.out.printf("배열의 총합은 : %d\n", sum);

		// 배열 생성과 할당이 동시에 이루어짐
		int b[] = { 1000, 2000, 3000, 4000 };

		b[3] = 1;
		for (int i = 0; i < b.length; i++) {
			sum += b[i];
			System.out.println(b[i]);
		}

		System.out.printf("배열의 총합은 : %d\n", sum);
	}
}
