package java_20190729;

// ctl + shift + O
import java.util.ArrayList;

public class WrapperDemo {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		// 자바 1.4 이전 버전에서는 primitive data type(pdt)을 Collection에서 저장할 수 없기 때문에 pdt을 객체화
		// 할 수 있는 Warpper으로 변환하여 저장해야 한다.
		// 아래와 같이 1을 add 할 수 없음
		// list.add(1);
		list.add(new Integer(1));
		System.out.println(list);

		// 1. pdt => wrapper class ( 생성자를 이용 => new Integer(10))
		Integer i2 = new Integer(10);
		Integer i3 = new Integer(10);

		// 2. string => wrapper class ( Integer.valueOf("10"))
		String s1 = "10";
		Integer i1 = Integer.valueOf(s1);

		System.out.println(i1);

		// 3. wrapper class => pdt
		int i4 = i2.intValue() + i3.intValue();
		System.out.println(i4);

		// 4. String => pdt
		String s2 = "10";
		String s3 = "20";
		System.out.println(s2 + s3);
		int temp = Integer.parseInt(s2) + Integer.parseInt(s3);
		// int i5 = Integer.valueOf(s2).intValue() + Integer.valueOf(s3).intValue();

		System.out.println(temp);
		// System.out.println(i5);

		// 5. pdt => String(+"")
		int a1 = 10;
		String s4 = String.valueOf(a1);

		System.out.println(s4);

		// 1.5 이상 부터
		// auto-boxing : pdt 자동으로 wapper
		Integer i6 = 10;

		// auto-unboxing : wapper 자동으로 pdt
		int a2 = i2 + i3;
		
		System.out.println(i2 == i3);
		System.out.println(i2.equals(i3));
	}
}
