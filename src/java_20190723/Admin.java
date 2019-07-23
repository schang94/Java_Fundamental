package java_20190723;

public class Admin {
	
	// alt + shift + s => c
	Admin() {
		super(); // 부모 클래스의 디폴트 생성자를 호출
		id = "admin";
		pw = "admin";
		email = "admin@java.com";
		level = 1;
	}

	// alt + shift + s => o
	Admin(String id, String pw, String email, int level) {
		super();
		this.id = id;
		this.pw = pw;
		this.email = email;
		this.level = level;
	}
	
	Admin(String id, String pw, String email) {
		//this.id = id;
		//this.pw = pw;
		//this.email = email;
		this(id,pw,email,0); // this는 super() 호출 안함
		// this 용법 2가지
		// 1. 자기 자신 개체 this.
		// 2. 다른 생성자 호출 this(); => 생성자에서만 사용
	}

	private String id;
	private String pw;
	private String email;
	private int level;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getPw() {
		return pw;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}
