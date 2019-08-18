package java_20190817.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import java_20190817.server.ThreeTierServerThread;

public class ThreeTierServer {
	private int port;
	public ThreeTierServer(int port) {
		this.port = port;
	}
	private void run() {
		ServerSocket serversocket = null;
		
		try {
			serversocket = new ServerSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		ThreeTierServerThread tst = null;
		
		while(true) {
			System.out.println("클라이언트 기다리는 중....");
			try {
				Socket socket = serversocket.accept();
				
				String ip = socket.getInetAddress().getHostAddress();
				System.out.println("클라이언트 [ip : "+ip + "]");
				
				tst = new ThreeTierServerThread(socket);
				Thread  t1 = new  Thread(tst);
				t1.start();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
		}
	}
	public static void main(String[] args) {
		new ThreeTierServer(6000).run();
	}
}
