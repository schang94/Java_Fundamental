package java_20190808.unicast.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class UnicastServerThread implements Runnable{

	Socket socket = null;
	
	public UnicastServerThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			boolean isStop = false;
			while(!isStop) {
				// 정상 메시지 => id : message
				// 종료 메시지 => shutdown
				String readLine = br.readLine();
				System.out.println(readLine);
				
				bw.write(readLine);
				bw.newLine();
				bw.flush();
				
				if(readLine.equals("shutdown")) {
					isStop = true;
				}
			}
		} catch (IOException e) {
			System.out.println("비정상적으로 종료하셨습니다.");
		} 
	}

}
