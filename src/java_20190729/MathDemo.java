package java_20190729;

public class MathDemo {
	public static void main(String[] args) {
		double d1 = Math.ceil(4.1);
		System.out.println(d1);
		
		d1 = Math.floor(4.9);
		System.out.println(d1);
		
		double d2 = 42.789;
		double temp = Math.round(d2*100);
		
		System.out.println(temp/100);
		
		d1 = Math.round(4.5);
		System.out.println(d1);
		
		System.out.println(d1 = Math.abs(4.8));
	}
}
