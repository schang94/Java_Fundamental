package java_20190719;

// public은 파일 이름과 같은 클래스에만 추가할 수 있다.
public class A {
	String name;
	int age;
	
	public void m() {
		System.out.println("m() 메서드");
	}
	public static void main(String[] args) {
		A a = new A();
		a.name = "성영한";
		a.age = 20;
		
		System.out.println(a.name);
		System.out.println(a.age);
		
		a.m();
	}
}
// 메인 메소드가 실행 되기 위해서는 public이 추가된 클래스에서만 작동됨
// 메인 메소드가 실행 되기 위해서는 파일 이름과 동일한 클래스에서만 작동됨
class B{
	
}