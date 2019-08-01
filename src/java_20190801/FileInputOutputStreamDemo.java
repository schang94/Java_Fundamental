package java_20190801;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import bonus.Utility;

public class FileInputOutputStreamDemo {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream("c:\\dev\\test\\jdk.exe");
			Utility f1 = new Utility();
			f1.mkdirs("c:\\dev\\2019\\8\\1");
			// FileOutputStream(String path) 생성자는  FileNotFoundException
			// 에러의 의미는 경로가 없기 때문에 발생하는 것이다.
			// 따라서 FileOutputStream 객체를 생성 할때는 경로가 있는지 체크한 후에 객체를 생성해야 한다.
			fos = new FileOutputStream("c:\\dev\\2019\\8\\1\\jdk1.exe");
			int readByte = 0;
			// fis.read() 메서드는 한 바이트 읽어 반환한다.
			// 만약 더 이상 읽을 바이트가 없으면 -1을 반환한다.
			while((readByte = fis.read()) != -1) {
				// fos,write(readBye)는 한바이트씩 쓰기
				fos.write(readByte);
				System.out.print(readByte+" ");
			}
			System.out.println("\n성공");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (fis != null) fis.close();
				if (fos != null) fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
