package java_20190817.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;


public class ThreeTierServerThread implements Runnable {
	private Socket socket;
	public ThreeTierServerThread(Socket socket) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		BufferedWriter bw = null;
		MemberDao m = MemberDao.getInstance();
		
		try {
			br = new BufferedReader(
					 new InputStreamReader(
					 socket.getInputStream()));
			bw = new BufferedWriter(
					 new OutputStreamWriter(
					 socket.getOutputStream()));
			boolean isStop = false;
			
			while(!isStop) {
				String readLine = br.readLine();
				String[] split = readLine.split("#");
				if(split[0].equals("1")) {
					String id = split[1];
					String name = split[2];
					
					m.Insert(new MemberDto(id,name));
					
					ArrayList<MemberDto> list = m.Select();
					String str = "";
					for(int i=0;i<list.size();i++) {
						MemberDto m1 = list.get(i);
						id = m1.getId();
						name = m1.getName();
						if(list.size() == (i+1)) {
							str += id+"#"+name;
						}else {
							str += id+"#"+name+"&";
						}
						
					}
					bw.write(str);
					bw.newLine();
					bw.flush();
				} else if(split[0].equals("2")) {
					String  id = split[1];
					String name = split[2];
					
					m.Update(new MemberDto(id,name));
					
					ArrayList<MemberDto> list = m.Select();
					
					String str = "";
					for(int i=0;i<list.size();i++) {
						MemberDto m1 = list.get(i);
						id = m1.getId();
						name = m1.getName();
						if(list.size() == (i+1)) {
							str += id+"#"+name;
						}else {
							str += id+"#"+name+"&";
						}
						
					}
					bw.write(str);
					bw.newLine();
					bw.flush();
				} else if(split[0].equals("3")) {
					String  id = split[1];
					String name = "";
					m.Delete(id);
					
					ArrayList<MemberDto> list = m.Select();
					
					String str = "";
					for(int i=0;i<list.size();i++) {
						MemberDto m1 = list.get(i);
						id = m1.getId();
						name = m1.getName();
						if(list.size() == (i+1)) {
							str += id+"#"+name;
						}else {
							str += id+"#"+name+"&";
						}
						
					}
					bw.write(str);
					bw.newLine();
					bw.flush();
				} else if(split[0].equals("4")) {
					String  id = split[1];
					String name = "";
					
					String str = m.PickSelect(id);
					
					if(str != null) {
						bw.write(str);
						
					}
					else {
						bw.write("");
					}
					bw.newLine();
					bw.flush();
				} else if(split[0].equals("5")) {
					String  id = split[1];
					boolean check = m.Overlap(id);
					
					if(check) {
						bw.write("true");
					} else {
						bw.write("false");
					}
					bw.newLine();
					bw.flush();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("비정상적으로 종료하셨습니다.");
		} finally {
			try {
				if(bw != null) bw.close();
				if(br != null) br.close();
			} catch (IOException e2) {
				// TODO: handle exception
			}
		}
	}
	

}
