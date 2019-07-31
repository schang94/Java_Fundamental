package java_20190731;

import java.util.ArrayList;

public class ExceptionDeom {
	
	public static void main(String[] args) {
		
		
		int i = Integer.parseInt("111"); // NumberFormatException
		System.out.println(i);
		
		int[] a = {1,2,3,4};
		System.out.println(a[3]); // 인덱스 초과 ArrayIndexOutOfBoundsException
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		System.out.println(list.get(1)); // 인덱스 초과 IndexOutOfBoundsException
		
		String str = null;
		System.out.println(str); // str.length() NullPointerException
		
		System.out.println(1/0); // 분모가 0일때 ArithmeticException
	}
}
