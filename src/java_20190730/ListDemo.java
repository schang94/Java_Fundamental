package java_20190730;

import java.util.ArrayList;

class Product {
	int number;
	String name;
	double price;

	Product(int number, String name, double price) {
		this.number = number;
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [number=" + number + ", name=" + name + ", price=" + price + "]";
	}

}

public class ListDemo {
	public static void main(String[] args) {
		// ArrayList : 순서가 있고, 객체의 중복을 허용한다.
		ArrayList<Product> list = new ArrayList<Product>();
		Product p1 = new Product(1, "terra", 2500);
		Product p2 = new Product(2, "신라면", 1000);
		Product p3 = new Product(3, "서울우유", 3000);
		Product p4 = new Product(1, "terra", 2500);

		// 할당
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);

		for (int i = 0; i < list.size(); i++) {
			Product temp = (Product)list.get(i);
			System.out.println(temp);
		}
		System.out.println();
		
		list.remove(1); // 삭제
		
		for (int i = 0; i < list.size(); i++) {
			Product temp = (Product)list.get(i);
			System.out.println(temp);
		}
		
		System.out.println();
		for (Product product : list) {
			System.out.println(product);
		}
		
		for (int i = list.size(); i > 0; i--) {
			list.remove(0);
		}
			
		for (int i = 0; i < list.size(); i++) {
			Product temp = list.get(i);
			System.out.println(temp);
		}
		
		
	}
}
