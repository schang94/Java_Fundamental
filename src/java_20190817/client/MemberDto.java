package java_20190817.client;

public class MemberDto {
	private String id;
	private String name;
	
	
	public MemberDto(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Member [아이디  : " + id + ", 이름 : " + name + "]";
	}
}
