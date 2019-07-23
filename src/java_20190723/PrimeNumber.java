package java_20190723;

public class PrimeNumber {

	
	
	public int[] getPrime(int temp) {
		int count = 0;
		int[] num = new int[temp];
		boolean isPrimeNumber = false;
		for (int i = 2; i <= temp; i++) {
			isPrimeNumber = true;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					isPrimeNumber = false;
					break;
				}
			}
			if(isPrimeNumber) {
				num[count] = i;
				count++;
			}
		}
		
		int[] last = new int[count];
		System.arraycopy(num, 0, last, 0,count);
		
		return last;
	}
	
	public void checkPrimeNumber(int temp) {
		// temp => 50이면 50이하의 소수를 출력한다.
		int count = 0;
		System.out.printf("소수 : ");
		for (int i = 2; i <= temp; i++) {
			for (int j = 2; j <= i; j++) {
				if (i % j == 0) {
					if (i == j) {
						System.out.printf("%d ", i);
						count++;
					} else {
						break;
					}
				}
			}
		}
		System.out.printf("(총 개수 : %d)\n",count);
		
	}
}
