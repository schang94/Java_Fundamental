package java_20190724.aa;

public class Test {
	// compulier는 클래스내에 생성자가 없으면 자동으로 디폴트 생성자를 만들어준다.
	// 이때 생성자의 접근 한정자는 클래스의 접근 한정자와 동일하게 만들어준다.
	public static void main(String[] args) {
		System.out.println("Hello");
		
	}
}
// Test1, Test2 클래스는 Test.java 파일안에서 선언은 가능하다.
// 서로 다른 패키지에서 사용할 수 없다.
// Test1, Test2 클래스는 다르
class Test1 {

}

class Test2 {

}