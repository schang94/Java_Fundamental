package java_20190817.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

public class ThreeTierClient {
	private ArrayList<MemberDto> list;
	private String ip;
	private int port;
	private BufferedReader br;
	private BufferedWriter bw;
	
	public ThreeTierClient(String ip, int port) {
		this.ip = ip;
		this.port = port;
		list = new ArrayList<MemberDto>();
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
		String dataCheck = "";
		String id = console("아이디를 입력하세요 : ");
		String msg = "5#"+id;
		
		try {
			bw.write(msg);
			bw.newLine();
			bw.flush();
			
			dataCheck =br.readLine();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		if(dataCheck.equals("true")) {
			String name = console("이름을 입력하세요 : ");
			msg = "1#"+id+"#"+name;
			
			try {
				bw.write(msg);
				bw.newLine();
				bw.flush();
				
				String readLine =br.readLine();
				System.out.println("client readLine : "+readLine);
				String[] split = readLine.split("&");
				for(String temp : split) {
					String[] split2 = temp.split("#");
					list.add(new MemberDto(split2[0], split2[1]));
				}
					
				
				System.out.println("list size : "+list.size());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("존재하는 아이디 입니다.");
		}
		
		
		print();
		String index = console("번호를 선택하세요 : ");
		run(index);
	}

	private void update() {
		String dataCheck = "";
		String id = console("수정할 아이디를 입력하세요 : ");
		String msg = "5#"+id;
		
		try {
			bw.write(msg);
			bw.newLine();
			bw.flush();
			
			dataCheck =br.readLine();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		if(dataCheck.equals("false")) {
			String name = console("이름을 수정하시요 : ");
			msg = "2#"+id+"#"+name;
			
			try {
				bw.write(msg);
				bw.newLine();
				bw.flush();
				
				String readLine =br.readLine();
				System.out.println("client readLine : "+readLine);
				String[] split = readLine.split("&");
				for(String temp : split) {
					String[] split2 = temp.split("#");
					list.add(new MemberDto(split2[0], split2[1]));
				}
					
				
				System.out.println("list size : "+list.size());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("존재하지 않는 아이디 입니다.");
		}
		
		
		print();
		String index = console("번호를 선택하세요 : ");
		run(index);
	}

	private void delete() {
		String dataCheck = "";
		String id = console("삭제할 아이디를 입력하세요 : ");
		String msg = "5#"+id;
		
		try {
			bw.write(msg);
			bw.newLine();
			bw.flush();
			
			dataCheck =br.readLine();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		if(dataCheck.equals("false")) {
			msg = "3#"+id;
			
			try {
				bw.write(msg);
				bw.newLine();
				bw.flush();
				
				String readLine =br.readLine();
				System.out.println("client readLine : "+readLine);
				String[] split = readLine.split("&");
				for(String temp : split) {
					String[] split2 = temp.split("#");
					list.add(new MemberDto(split2[0], split2[1]));
				}
					
				
				System.out.println("list size : "+list.size());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("존재하지 않는 아이디입니다.");
		}
		
		print();
		String index = console("번호를 선택하세요 : ");
		run(index);
	}

	private void search() {
		boolean dataCheck = false;
		String id = console("검색할 아이디를 입력하세요 : ");
		int check = 0;
		String msg = "4#"+id;
		
		try {
			bw.write(msg);
			bw.newLine();
			bw.flush();
			
			String readLine =br.readLine();
			if(!readLine.equals("")) {
				String[] split = readLine.split("#");
				
				System.out.println("아이디 : "+split[0]+", 이름 : "+split[1]);
			} else {
				System.out.println("존재하지 않는 아이디입니다.");
			}
			
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		print();
		String index = console("번호를 선택하세요 : ");
		run(index);
	}

	private void connect() {
		// TODO Auto-generated method stub
		try {
			Socket socket = new Socket(ip,port);
			bw = new BufferedWriter(
					 new OutputStreamWriter(
					socket.getOutputStream()));
			br = new BufferedReader(
					 new InputStreamReader(
					 socket.getInputStream()));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ThreeTierClient m1 = new ThreeTierClient("192.168.0.86",6000);

		m1.print();
		m1.connect();
		String selectedIndex = m1.console("번호를 선택하세요 : ");
		m1.run(selectedIndex);

	}

}