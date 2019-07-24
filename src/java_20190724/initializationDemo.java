package java_20190724;

// i18n => 국제화 i nternationalizatio n
// l10n => 지역화 l ocaliztio n
public class initializationDemo {
	int a;
	static int b;
	static final int C = 10;
	
	// static 초기화
	static {
		System.out.println("static area");
		b = 100;
	}
	// 생성자에서 초기화 할수 있는 변수는 instance 변수만
	public initializationDemo(int a) {
		this.a = a;
	}
	
	public static void main(String[] args) {
		System.out.println("main area");
		initializationDemo i = new initializationDemo(1000);
		System.out.println(i.a);
		System.out.println(b);
		System.out.println(C);
	}
	
}
