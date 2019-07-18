// 특수문자 중에는 $,_는 사용 할 수 있다.
package java_20190715;

// 클래스명의 시작은 대문자로 시작한다.
// 두단어가 합친 경우에는 두번째 단어의 첫글자는 대문자로 사용한다.
// (caml case)
public class IdentifierDemo {
	public static void main(String[] args) {
		int age = 10;
		String name = "hello";
		System.out.println(age + " " + name);
		// 숫자로 시작할 수 없다.
		// String 1fatherName = "John";
		// 공백을 사용할 수 없다.
		// String mother Name = "Michell";
		// 예약어는 변수(식별자)로 사용할 수 없다.
		// String void = "empty";

		// 유니코드를 지원하기 때문에 한글도 식별자로 사용 가능하지만 안쓰는게 좋다.
		String 이름 = "손창민";

		System.out.println(이름);

	}
}
