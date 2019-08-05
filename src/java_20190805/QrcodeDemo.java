package java_20190805;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import bonus.Utility;

public class QrcodeDemo {
	public static void main(String[] args) {
		Utility.isQrcode("http://www.naver.com",300,300);
	}
}
