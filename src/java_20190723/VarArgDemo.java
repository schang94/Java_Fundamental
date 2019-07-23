package java_20190723;

public class VarArgDemo {
	public long sum(int... temp) {
		long sum = 0; // 지역변수, 메소드 내에서 유효함
		for(int i :temp) {
			sum += i;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		VarArgDemo v1 = new VarArgDemo();
		
		long s1 = v1.sum(1,2);

		long s2 = v1.sum(1,2,3);
		
		System.out.printf("%d %d",s1,s2);
	}
}
