package bonus;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Utility {
	// pattern => "yyyy-MM-dd a hh:mm:ss E요일"
	// yyyy:년도, MM:월, dd:일, a:오전 or 오후, hh:시, mm:분, ss:초, E:요일
	public static String getDate(Calendar c, String pattern) {
		return new SimpleDateFormat(pattern).format(c.getTime());
	}
	public static boolean mkdirs(String path) {
		boolean isSuccess = false;
		File file = new File(path);
		boolean isExsited = file.isDirectory();
		if (!isExsited) {
			file.mkdirs();
			isSuccess = true;
		}
		
		return isSuccess;
	}
	public String getComma(double name, int precision) {
		return String.format("%,." + precision + "f", name);
	}

	public boolean changeFile(String path) {
		boolean isSuccess = false;
		File oldFile = new File(path);
		String fileName = oldFile.getName();
		String name = fileName.substring(0, fileName.lastIndexOf("."));
		String extension = fileName.substring(fileName.lastIndexOf("."));
		
		// 마음에 안들면 아래 부분을 수정하세요.
		name = String.valueOf(System.currentTimeMillis());
		fileName = name + extension;

		String parent = oldFile.getParent();

		File newFile = new File(parent, fileName);
		oldFile.renameTo(newFile);
		
		return isSuccess;
	}

}
