package Java_20190722;

public class MemberDemo {
	public static void main(String[] args) {
		Member m = new Member();
		m.setName("성영한");
		m.setAddr1("서울");
		m.setAddr2("용산구");
		m.setSsn1("111111-");
		m.setSsn2("1234567");
		m.setZipcode("12345");
		m.setAge(30);
		m.setRegdate("2019-07-22");
		
		System.out.printf("%s %s %s %d %s%s %s",m.getName(),m.getAddr1(),m.getAddr2(),m.getAge(),m.getSsn1(),m.getSsn2(),m.getRegdate());
	}
}
