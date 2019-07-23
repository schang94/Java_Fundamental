package java_20190723;

public class AdminDemo {
	public static void main(String[] args) {
		Admin a = new Admin("son", "1234", "son@naver.com");
		System.out.printf("%s %s %s %d \n", a.getId(), a.getPw(), a.getEmail(), a.getLevel());
	}
}
