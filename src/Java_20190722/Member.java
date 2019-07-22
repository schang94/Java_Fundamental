package Java_20190722;

public class Member {
	private String name;
	private String zipcode;
	private String addr1;
	private String addr2;
	private String ssn1;
	private String ssn2;
	private int age;
	private String regdate;
	
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getZString() {
		return zipcode;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr1() {
		return addr1;
	}
	
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getAddr2() {
		return addr2;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getRegdate() {
		return regdate;
	}
	
	public void setSsn1(String ssn1) {
		this.ssn1 = ssn1;
	}
	public String getSsn1() {
		return ssn1;
	}
	
	public void setSsn2(String ssn2) {
		this.ssn2 = ssn2;
	}
	public String getSsn2() {
		return ssn2;
	}
}
