package java_20190717;

public class ForDemo {
	public static void main(String[] args) {

		int sum = 0;

		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 0) {
				sum += i;
			}
		}

		System.out.printf("1부터 10까지의 짝수의 합은 %d입니다.\n", sum);

		for (int i = 2; i <= 9; i++) {
			System.out.printf("%d단 : ", i);
			for (int j = 1; j <= 9; j++) {
				System.out.printf("%3d ", i * j);
			}
			System.out.println();
		}

		for (int i = 5; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		for (int i = 9; i >= 2; i--) {
			System.out.printf("%d단 : ", i);
			for (int j = 1; j <= 9; j++) {
				System.out.printf("%3d ", i * j);
			}
			System.out.println();
		}

		System.out.printf("\n소수 : ");
		for (int i = 1; i <= 100; i++) {
			for (int j = 2; j <= i; j++) {
				if (i % j == 0) {
					if (i == j) {
						System.out.printf("%d ", i);
						sum += i;
					} else {
						break;
					}
				}
			}
		}
		System.out.printf("\n1부터 100까지의 소수의 합은 %d입니다.\n\n", sum);

		int i = 1;
		while (i++ < 9) {
			System.out.printf("%d단 : ", i);
			int j = 0;
			while (j++ < 9) {
				System.out.printf("%3d ", i * j);
			}
			System.out.println();
		}
	}
}
