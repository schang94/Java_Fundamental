package java_20190805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelDemo {
	public static void main(String[] args) {
		// 1. c:\dev\test\test1.txt파일 읽어온다 (BufferedReader)
		// 2. BufferedReader의 readLine() 메서드를 이용해서 한줄 씩 읽어온다.
		// 3. 한줄 읽은 문자열을 String의 split("#")을 이용해서 String[] 반환 받는다.
		// 4. [0] => cell 입력한다. [1] => cell 입력한다.
		// [1] => cell 입력한다. [2] => cell 입력한다.
		// 5. 2,3,4번 반복 작업을 해서 엑셀을 입력
		// 6. 엑셀파일명 : c:\dev\test\test2.xls 파일로 저장한다.

		FileReader fr = null;
		BufferedReader br = null;
		
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet1 = workbook.createSheet("새파일1");
		HSSFSheet sheet2 = workbook.createSheet("새파일2");

		
		try {
			fr = new FileReader("c:\\dev\\test\\test1.txt");
			br = new BufferedReader(fr);

			String readLine = null;
			int rows = 0;
			while ((readLine = br.readLine()) != null) {
				HSSFRow row1 = sheet1.createRow(rows);
				HSSFRow row2 = sheet2.createRow(rows++);
				String[] data = readLine.split("#");
				for (int i = 0; i < data.length; i++) {
					HSSFCell cell1 = row1.createCell(i);
					HSSFCell cell2 = row2.createCell(i);
					cell1.setCellValue(data[i]);
					cell2.setCellValue(data[i]);
				}
			}
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fr != null) fr.close();
				if(br != null) br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			FileOutputStream fos = new FileOutputStream("c:\\dev\\test\\test2.xls");

			workbook.write(fos);

			fos.close();
			workbook.close();

			System.out.println("성공");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {

		}
	}
}
