package java_20190717;

public class BreakDemo {
	public static void main(String[] args) {

		int sum = 0;

		for (int i = 1; i <= 10; i++) {
			if (i == 6)
				break;
			sum += i;
		}

		System.out.println("\n");
		
		System.out.printf("1부터 10까지의 짝수의 합은 %d입니다.\n", sum);

		for (int i = 2; i <= 9; i++) {
			System.out.printf("%d단 : ", i);
			for (int j = 1; j <= 9; j++) {
				System.out.printf("%3d ", i * j);
				if(i == 4 && j == 7) {
					break;
				}
			}
			System.out.println();
		}
		
		System.out.println("\n");
		
	}
}
