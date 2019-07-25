package java_20190725;

public class ChildDemo {
	static {
		System.out.println("ChildDemo static 초기화");
	}
	public static void main(String[] args) {
		System.out.println("Main");
		Child c = new Child();
	}
}
