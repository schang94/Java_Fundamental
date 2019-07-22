package Java_20190722.aa;

public class NoticeDemo {
	public static void main(String[] args) {
		Notice n1 = new Notice();
		// public 서로 다른 패키지도 접근 가능
		n1.number = 1;
		// protected 서로 다른 패키지이면서 상속 받은 경우 접근 가능
		n1.title = "공지사항";
		// default 같은 패키지 내에서 접근 가능
		n1.hit = 0;
		// privite은 같은 클래스 내에서만 접근 가능
		//n1.regdate = "fsdf";
	}
}
