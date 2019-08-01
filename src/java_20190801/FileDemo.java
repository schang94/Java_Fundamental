package java_20190801;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileDemo {

	public void mkdirs(String path) {
		File f1 = new File(path);
		boolean isExsited = f1.isDirectory();
		if (!isExsited) {
			f1.mkdirs();
		}
	}

	public String getComma(double name, int precision) {
		return String.format("%,." + precision + "f", name);
	}

	public void changeFile(String path) {
		// path => c:\dev\test\jdk.exe => c:\dev\test\201908011041.exe
		File f1 = new File(path);
		// f1.getPath() => 전체경로 + 파일이름
		String fileName = f1.getName(); // 전체 경로중에 파일이름만 반환
		String name = fileName.substring(0, fileName.lastIndexOf("."));
		String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
		name = String.valueOf(System.currentTimeMillis());
		fileName = name + "." + extension;

		String parent = f1.getParent(); // f1의 디렉토리를 반환 => c:\dev\test

		File f2 = new File(parent, fileName);
		f1.renameTo(f2);
	}

	public static void main(String[] args) {

		FileDemo f1 = new FileDemo();

		f1.mkdirs("C:\\dev\\test");

		File f2 = new File("c:\\dev\\test", "jdk-11.0.3_windows-x64_bin.exe");
		long fileSize = f2.length();
		System.out.println(f1.getComma(fileSize / 1024, 2) + "KB");

		boolean isFile = f2.isFile();
		if (isFile) {
			String path = f2.getPath();
			if (path.endsWith("pdf")) {
				System.out.println("PDF 파일");
			} else if (path.endsWith("exe")) {
				System.out.println("EXE 파일");
			} else if (path.endsWith("txt")) {
				System.out.println("TXT 파일");
			}

		} else {
			System.out.println("파일 폴더");

		}

		//f1.changeFile("c:\\dev\\test\\jdk.exe");

		File f4 = new File("c:\\dev\\test\\jdk.exe");
		String fileName = f4.getName();
		String path = f4.getPath();
		String parent = f4.getParent();

		System.out.println(fileName);
		System.out.println(path);
		System.out.println(parent);
		System.out.println(f4.lastModified());

		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(f4.lastModified());
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		System.out.printf("%d, %d, %d \n", year, month, day);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss E요일");
		String date = sdf.format(c.getTime());
		System.out.println(date);

		File f5 = new File("c:\\dev\\test");
		String[] lists = f5.list();

		for (String list : f5.list()) {
			File f6 = new File(f5, list);
			String name = f6.getName();
			if (f6.isDirectory()) {
				System.out.println(name + "-디렉토리");
			} else {
				double fileSizes = (double)f6.length() / 1024;
				c.setTimeInMillis(f6.lastModified());
				String time = sdf.format(c.getTime());
				System.out.printf("%s \t %,f \t %s\n", name, fileSizes, time);
			}
		}
	}

}
