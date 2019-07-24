package java_20190724;

public class BoxDemo {
	
	
	public static void main(String[] args) {
		Box b1 = new Box();
		b1.width = 10;
		b1.height = 20;
		b1.depth = 30;
		
		System.out.printf("width : %d, height : %d, depth : %d\n",b1.width,b1.height,b1.depth);
		
		Box b2 = new Box();
		b2.width = 10;
		b2.height = 20;
		b2.depth = 30;
		
		// b1 == b2 => reference 비교일 때에는 b1과 b2가 같은 오브젝트를 참조하면 true, 그렇지 않으면 false
		System.out.println(b1 == b2);
		
		Box b3 = b2;
		
		System.out.println(b2 == b3);
		
		b1.chang(b1);
		
		System.out.printf("width : %d, height : %d, depth : %d\n",b1.width,b1.height,b1.depth);
		
		
	}
}
