package java_20190808.file.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {
	private int port;
	public FileServer(int port) {
		this.port = port;
	}
	public void run() {
		ServerSocket serverSocket = null;
		Socket socket = null;
		FileServerThread fst =null;
		
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(true) {
			System.out.println("클라이언트 접속 기다리는 중");
			try {
				socket = serverSocket.accept();
				
				String ip = socket.getInetAddress().getHostAddress();
				System.out.println("클라이언트 [ip : "+ip + "]");
				
				fst = new FileServerThread(socket);
				Thread t = new Thread(fst);
				t.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new FileServer(4000).run();
	}
}
