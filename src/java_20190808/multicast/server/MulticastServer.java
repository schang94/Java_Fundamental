package java_20190808.multicast.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MulticastServer {
	private int port;
	private ArrayList<MulticastServerThread> list;
	public MulticastServer(int port) {
		this.port = port;
		list = new ArrayList<MulticastServerThread>();
	}
	public void run() {
		ServerSocket serverSocket = null;
		MulticastServerThread mst = null;

		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
				
		while(true) {
			System.out.println("클라이언트 기다리는 중");

			try {
				Socket socket = serverSocket.accept();
				
				String ip = socket.getInetAddress().getHostAddress();
				System.out.println("클라이언트 ip : "+ip);
				
				mst = new MulticastServerThread(socket,list);
				
				list.add(mst);
				
				Thread t = new Thread(mst);
				t.start();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
	public static void main(String[] args) {
		new MulticastServer(6000).run();
	}
}
