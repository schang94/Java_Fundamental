package java_20190729;

import java.util.HashSet;

class Car {
	String medelNumber;
	String color;
	public Car(String medelNumber, String color) {
		this.medelNumber = medelNumber;
		this.color = color;
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((medelNumber == null) ? 0 : medelNumber.hashCode());
		return result;
	}
	@Override
	public String toString() {
		return "Car [medelNumber=" + medelNumber + ", color=" + color + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color)) 
			return false;
		if (medelNumber == null) {
			if (other.medelNumber != null)
				return false;
		} else if (!medelNumber.equals(other.medelNumber))
			return false;
		return true;
	}
}
public class EqulasDemo {
	public static void main(String[] args) {
		String s1 = new String("test");
		String s2 = new String("test");
		
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		Car c1 = new Car("1010101010","red");
		Car c2 = new Car("1010101010","red");
		
		// == => c1과 c2가 같은 객체를 참조하면 true, 그렇지 않으면 false
		System.out.println(c1 == c2);
		// equlas => c1과 c2가 같은 객체를 참조하면 true, 그렇지 않으면 false		
		System.out.println(c1.equals(c2));
		
		// 해쉬코드란 객체가 가지는 유일한 값. 반드시 유일한 값을 가져야 함.
		int hashCode1 = c1.hashCode();
		int hashCode2 = c2.hashCode();
		System.out.println(hashCode1);
		System.out.println(hashCode2);
		
		Car c3 = new Car("101010","white");
		Car c4 = c3;
		
		System.out.println(c3 == c4);
		System.out.println(c3.equals(c4));
		// c3,equals(c4)의 결과가  true이면 c3, c4의  hashCode값은 같고
		// c3,equals(c4)의 결과가  false이면 c3, c4의  hashCode값은 다르다.
		int hashCode3 = c3.hashCode();
		int hashCode4 = c4.hashCode();
		System.out.println(hashCode3);
		System.out.println(hashCode4);
		
		System.out.println(c1);
		
		HashSet set = new HashSet();
		set.add(c1);
		set.add(c2);
		System.out.println(set.size());
	}
}
