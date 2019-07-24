package java_20190724;

public class Box {
	int width;
	int height;
	int depth;
	
	// final 변수는 멤버변수 위치에서 초기화해햐 함
	// 한전 정해지면 변경 불가
	// final 변수명은 대문자로 하는 것이 관례
	// final 변수는 변수의 특성상 인스턴스 변수로 처리하지 않고 static 변수로 처리함.
	static final String NAME = "BOX";
	
	public void chang(Box b) {
		// 메소드내에 매개변수를 포함한 사용자가 정의한 변수를 지역변수라고 한다.
		// 지역변수는 자동으로 초기화 되지 않기 때문에 기본값을 저장해여 사용한다.
		// 지역변수는 유효범위는 메소드 내에서만 사용 가능
		b.width = 300000;
		b.height = 12313;
		b.depth = 2132158;
		
		
		
		
	}
}
