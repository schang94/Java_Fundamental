package java_20190730;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberManagementDemo {
	private ArrayList<Member> list;

	public MemberManagementDemo() {
		list = new ArrayList<Member>();
	}

	public void print() {
		System.out.println("***************************************************");
		System.out.println("* 1. Insert 2. Update 3. Delete 4. Search 5. Exit *");
		System.out.println("***************************************************");
	}

	public String console(String msg) {
		System.out.print(msg);
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}

	private void run(String msg) {
		if (msg.equals("1")) {
			insert();
		} else if (msg.equals("2")) {
			update();
		} else if (msg.equals("3")) {
			delete();
		} else if (msg.equals("4")) {
			search();
		} else if (msg.equals("5")) {
			System.out.println("종료합니다.");
		} else {
			System.out.println("잘못입력했습니다.");
			print();
			String index = console("번호를 선택하세요 : ");
			run(index);
		}
	}

	private void insert() {
		boolean dataCheck = true;
		String id = console("아이디를 입력하세요 : ");

		for (int i = 0; i < list.size(); i++) {
			Member temp = (Member) list.get(i);
			if (id.equals(temp.getId())) {
				dataCheck = false;
				break;
			}
		}
		if (dataCheck) {
			String name = console("이름을 입력하세요 : ");
			list.add(new Member(id, name));
			for (int i = 0; i < list.size(); i++) {
				Member temp = (Member) list.get(i);
				System.out.println(temp);
			}
		} else {
			System.out.println("중복된 아이디 입니다.");
		}
		
		print();
		String index = console("번호를 선택하세요 : ");
		run(index);
	}

	private void update() {
		boolean dataCheck = false;
		String id = console("수정할 아이디를 입력하세요 : ");

		for (int i = 0; i < list.size(); i++) {
			Member temp = (Member) list.get(i);
			if (id.equals(temp.getId())) {
				list.remove(i);
				dataCheck = true;
				break;
			}
		}

		if (dataCheck) {
			String name = console("이름을 수정하시요 : ");
			list.add(new Member(id, name));

			for (int i = 0; i < list.size(); i++) {
				Member temp = (Member) list.get(i);
				System.out.println(temp);
			}
		} else {
			System.out.println("존재하지 않는 아이디 입니다.");
		}

		print();
		String index = console("번호를 선택하세요 : ");
		run(index);
	}

	private void delete() {
		boolean dataCheck = false;
		String id = console("삭제할 아이디를 입력하세요 : ");

		for (int i = 0; i < list.size(); i++) {
			Member temp = (Member) list.get(i);
			if (id.equals(temp.getId())) {
				list.remove(i);
				dataCheck = true;
				break;
			}
		}

		if (dataCheck) {
			for (int i = 0; i < list.size(); i++) {
				Member temp = (Member) list.get(i);
				System.out.println(temp);
			}
		} else {
			System.out.println("존재하지 않는 아이디 입니다.");
		}
		print();
		String index = console("번호를 선택하세요 : ");
		run(index);
	}

	private void search() {
		boolean dataCheck = false;
		String id = console("검색할 아이디를 입력하세요 : ");
		int check = 0;

		for (int i = 0; i < list.size(); i++) {
			Member temp = (Member) list.get(i);
			if (id.equals(temp.getId())) {
				check = i;
				dataCheck = true;
				break;
			}
		}
		if (dataCheck) {
			Member temp = (Member) list.get(check);
			System.out.println(temp);
		} else {
			System.out.println("존재하지 않는 아이디 입니다.");
		}

		print();
		String index = console("번호를 선택하세요 : ");
		run(index);
	}

	public static void main(String[] args) {
		MemberManagementDemo m1 = new MemberManagementDemo();

		m1.print();
		String selectedIndex = m1.console("번호를 선택하세요 : ");
		m1.run(selectedIndex);

	}
}
