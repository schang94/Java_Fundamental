package java_20190723;

import java.util.*;

public class PrimNumberDemo {

	public static void main(String[] args) {
		PrimeNumber c = new PrimeNumber();
		Scanner scanner = new java.util.Scanner(System.in);
		System.out.print("숫자를 입력하세요 > ");
		String input = scanner.nextLine();
		c.checkPrimeNumber(Integer.parseInt(input));

		int[] num = c.getPrime(Integer.parseInt(input));;
		
		System.out.print("소수 : ");
		for(int i:num) {
			System.out.printf("%d ",i);
		}
		System.out.printf("(총 개수 : %d)",num.length);
		//System.out.printf("(총 개수 : %d)");
	}
}