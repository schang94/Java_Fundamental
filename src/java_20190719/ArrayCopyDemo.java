package java_20190719;

public class ArrayCopyDemo {
	public static void main(String[] args) {
		String[] a = {"apple","banana","watermelon","blueberry"};
		String[] b = {"peach","rasberry"};
		String[] temp = new String[6];
		
		// a => 원본 배열
		// 0 => 원본배열의 위치 즉, 원본배열의 복사할 위치
		// temp => 카피할 배열
		// 0 => 카피할 배열의 위치
		// 4 => 원본배열의 4갸 요소 카피
		System.arraycopy(a, 0, temp, 0, 4);
		System.arraycopy(b, 0, temp, 4, 2);
		
		for(String t : temp) {
			System.out.println(t);
		}
	}
}
