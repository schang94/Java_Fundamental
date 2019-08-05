package java_20190802;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamDemo {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;

		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		PrintStream ps = null;
		
		try {
			ps = System.out; // 모니터
			ps.println("Hello World");
			
			fis = new FileInputStream("c:\\dev\\test\\java_pdf.zip");
			fos = new FileOutputStream("c:\\dev\\test\\java_pdf_copy.zip");
			
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			
			ps = new PrintStream(bos,true);
			
			int readByteCount = 0;
			//byte[] b = new byte[8192];
			long start = System.currentTimeMillis();
			while ((readByteCount = bis.read()) != -1) {
				ps.write(readByteCount);
			}
			long end = System.currentTimeMillis();
			System.out.println("경과 시간 : " + (end - start));
			
			//bos.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) fis.close();
				if (fos != null) fos.close();
				if (bis != null) bis.close();
				if (ps != null) ps.close();
				if (bos != null) bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
