package java_20190718;

public class LottteryDemo {
	public static void main(String[] args) {
		int[] number = new int[6];
		for (int k = 0; k < 5; k++) {
			// 번호 생성
			for (int i = 0; i < number.length; i++) {

				boolean check = true;
				double random = Math.random(); // Math.random() => 0보다 크거나 1보다 작은 양수를 double 값으로 반환
				int temp = (int) (random * 45) + 1;

				// 증복 체크
				for (int j = 0; j < i; j++) {
					if (temp == number[j]) {
						--i;
						check = false;
						break;
					}
				}

				if (check) {
					number[i] = temp;
				}
			}

			// 오름차순으로 정렬
			for (int i = 0; i < number.length; i++) {
				for (int j = i + 1; j < number.length; j++) {
					if (number[i] > number[j]) {
						int temp = number[i];
						number[i] = number[j];
						number[j] = temp;

					}
				}
			}

			// 츨력
			for (int i = 0; i < number.length; i++) {
				System.out.printf("%3d ", number[i]);
			}
			
			System.out.println();
		}
	
	}
}
