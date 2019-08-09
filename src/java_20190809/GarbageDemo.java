package java_20190809;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;

class A extends Thread{
	public void run() {
		System.out.println("스레드1");
	}
}

class B implements Runnable {
	public void run() {
		System.out.println("스레드2");
	}
}

class Customer {
	String name;
	Customer(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

class CustomerDao {
	public Customer[] getCustomer() {
		Customer[] cs = new Customer[10];
		cs[0] = new Customer("성영한1");
		cs[1] = new Customer("성영한2");
		cs[2] = new Customer("성영한3");
		cs[3] = new Customer("성영한4");
		cs[4] = new Customer("성영한5");
		cs[5] = new Customer("성영한6");
		cs[6] = new Customer("성영한7");
		cs[7] = new Customer("성영한8");
		cs[8] = new Customer("성영한9");
		cs[9] = new Customer("성영한10");
		return cs;
	}
	
	public ArrayList<Customer> getCustomers(){
		ArrayList<Customer> list = new ArrayList<Customer>();
		list.add(new Customer("영한1"));
		list.add(new Customer("영한2"));
		list.add(new Customer("영한3"));
		list.add(new Customer("영한4"));
		list.add(new Customer("영한5"));
		list.add(new Customer("영한6"));
		list.add(new Customer("영한7"));
		list.add(new Customer("영한8"));
		list.add(new Customer("영한9"));
		list.add(new Customer("영한10"));
		return list;
	}
}
public class GarbageDemo {
	public static void main(String[] args) {
		A a = new A();
		a.start();
		
		B b = new B();
		Thread t1 = new Thread(b);
		t1.start();
		
		Calendar c1 = new GregorianCalendar();
		Calendar c2 = Calendar.getInstance();
		
		// Dao => Data Access Object
		CustomerDao cdao = new CustomerDao();
		
		Customer[] customer = cdao.getCustomer();
		
		for (Customer customer2 : customer) {
			System.out.println(customer2.getName());
		}
		
		ArrayList<Customer> customers = cdao.getCustomers();
		for (Customer customer2 : customers) {
			System.out.println(customer2.getName());
		}
		
 	}
	
	// Calendar 클래스 메서드만 사용 할 수 있다.
	// 단, GregorianCalendar 클래서에서 overriding된 메서드는 사용가능하다.
	public static Calendar getInstance() {
		Calendar c = new GregorianCalendar();
		return c;
	}
}
