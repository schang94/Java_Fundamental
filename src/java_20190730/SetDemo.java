package java_20190730;

import java.util.Iterator;
import java.util.TreeSet;

public class SetDemo {
	public static void main(String[] args) {
		// HashSet은 데이터(객체)의 중복을 허용하지 않고, 순서는 없다.
		//HashSet set = new HashSet();
		// TreeSet은 데이터(객체)의 중복을 허용하지 않고, 오름차순으로 정렬
		TreeSet<Integer> set = new TreeSet<Integer>();
		while (true) {
			int random = (int) (Math.random() * 45) + 1;
			set.add(random); // 할당, auto-boxing(pdt => wapper)
			// HashSet의 크기 : size()
			if (set.size() == 6)
				break;
		}

		// HashSet의 출력은 Iterator 변경을 해서 출력해야 한다.
		Iterator<Integer> i = set.iterator();
		while (i.hasNext()) { // hasNext() HashSet에 출력할 객체가 존재하는지 판단하는 메서드
			// auto-unboxing : wrapper => pdt
			int temp = i.next(); // next() 해당 객체를 가져온다.
			System.out.print(temp + "\t");
		}
	}
}
