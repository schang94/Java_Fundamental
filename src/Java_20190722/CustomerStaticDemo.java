package Java_20190722;
import java_20190719.Customer;;

public class CustomerStaticDemo {
	public static void main(String[] args) {
		// static 변수는 클래스 이름으로 접근한다.
		Customer.interestRate = 3.5;
		
		Customer c1 = new Customer();
		
		c1.name = "홍길동";
		c1.age = 40;
		c1.email = "kdhong@test.com";
		c1.phone = "010-3204-1703";
		c1.isRelease = false;
		c1.balance = 23_000_000_000.23;
		// final 변수는 재할당 할 수 없다.
		// Customer.BANKNAME = "국민은행";
		// static 변수는 클래스 이름으로 접하는 하는 것이 관례이지만  reference로도 접근이 가능하다(권장하지 않음)
		// c1.interestRate = 3.5;
		Customer c2 = new Customer();
		c2.name = "아무개";
		c2.age = 50;
		c2.email = "noname@test.com";
		c2.phone = "010-1234-5678";
		c2.isRelease = false;
		c2.balance = 19_000_000.24;

		System.out.println(Customer.interestRate);
		
		Customer c3 = new Customer();
		c3.name = "배조스";
		c2.age = 62;
		c2.email = "jaws@amazon.com";
		c2.phone = "010-1234-1234";
		c2.isRelease = false;
		c2.balance = 19_000_000_000.24;
		System.out.println(Customer.interestRate);
	}
}
