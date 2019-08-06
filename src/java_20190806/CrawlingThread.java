package java_20190806;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import bonus.Utility;

public class CrawlingThread extends Thread{
	private String coinName;
	private String fileName;
	
	public CrawlingThread(String coinName, String fileName) {
		this.coinName = coinName;
		this.fileName = fileName;
	}
	@Override
	public void run() {
		Document doc = null;
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("새파일");
		HSSFRow row = null;
		HSSFCell cell = null;
		
		

		String url = "https://coinmarketcap.com/currencies/"+coinName+"/historical-data/?start=20190101&end=20190806";
		
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println("Date\t\tOpen\t\tHigh\t\tLow\t\tClose\t\tVolume\t\tMarket Cap");
		String[] menu = {"Date","Open","High","Low","Close","Volume","Market Cap"};
		
		row = sheet.createRow(0);
		for(int i = 0; i < menu.length ;i++) {
			cell = row.createCell(i);
			cell.setCellValue(menu[i]);
		}
		Elements bodyElements = doc.select(".table-responsive .table tbody tr");
		
		for (int i = 0; i < bodyElements.size(); i++) {
			Element trElemnet = bodyElements.get(i);
			int index = 0;
			String date = Utility.getKoreaDate(trElemnet.child(index++).text());
			String open = trElemnet.child(index++).text();
			String high = trElemnet.child(index++).text();
			String low = trElemnet.child(index++).text();
			String close = trElemnet.child(index++).text();
			String volume = trElemnet.child(index++).text();
			String marketCap = trElemnet.child(index++).text();
			
			row = sheet.createRow(i+1);
			cell = row.createCell(0);
			cell.setCellValue(date);
			cell = row.createCell(1);
			cell.setCellValue(open);
			cell = row.createCell(2);
			cell.setCellValue(high);
			cell = row.createCell(3);
			cell.setCellValue(low);
			cell = row.createCell(4);
			cell.setCellValue(close);
			cell = row.createCell(5);
			cell.setCellValue(volume);
			cell = row.createCell(6);
			cell.setCellValue(marketCap);
			
			
			//System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\t%s\n",date,open,high,low,close,volume,marketCap);
		}
		
		try {
			FileOutputStream fos = new FileOutputStream("c:\\dev\\test\\"+fileName);
			
			workbook.write(fos);
			
			fos.close();
			workbook.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			
		}
		
		try {
			Thread.sleep(1000 * 60 * 60);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
