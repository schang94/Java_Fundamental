package Java_20190722;

public class MethodDemo {
	// 6-11라인까지 메소드를 정의
	// boolean 메소드 반환
	// instance 메소드
	// int year => 매개변수(parameter)
	public boolean isLeafYear(int year) {
		// 메소드의 반환값이 boolean이기 때문에 return value의 value도 boolean이여야 한다.
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}

	// String msg, int index => 매개변수
	public char charofString(String msg, int index) {
		return msg.charAt(index);
	}

	public long plus(long first, long second) {
		return first + second;
	}

	public double divide(double first, double second) {
		return first / second;
	}

	public void ascending(int[] number){
		for (int i = 0; i < number.length; i++) {
			for (int j = i + 1; j < number.length; j++) {
				if (number[i] > number[j]) {
					int temp = number[i];
					number[i] = number[j];
					number[j] = temp;

				}
			}
		}
	}
	public static void main(String[] args) {
		MethodDemo m1 = new MethodDemo();
		// 인스턴스 메소드의 사용 방법
		// 객체 생성한 후에 reference(m1)를 이용해서 호출하면 됨
		boolean isLeafYear = m1.isLeafYear(1400);
		System.out.println(isLeafYear);
		System.out.println(m1.isLeafYear(1232));
		System.out.println(new MethodDemo().isLeafYear(2019));

		// "Hello", 0 => 전달인자
		System.out.println(new MethodDemo().charofString("Hello", 0));

		System.out.println(new MethodDemo().plus(2100000000, 2100000000));
		
		System.out.println(new MethodDemo().divide(0, 0));
		
		int[] a = {5,4,3,6,7,1,18,25,94,56};
		for(int aa : a) {
			System.out.printf("%d ", aa);
		}
		System.out.println();
		new MethodDemo().ascending(a);
		for(int aa : a) {
			System.out.printf("%d ", aa);
		}
	}
}
